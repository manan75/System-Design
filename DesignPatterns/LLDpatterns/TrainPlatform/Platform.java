package DesignPatterns.LLDpatterns.TrainPlatform;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;

public class Platform {
    TreeSet<Integer> platforms;
        
    Queue<Train> waitList;
    HashMap<Train, Integer> trainToPlatform;
    public Platform(){

    }

    public void addTrain(Train train){
        //if all platforms are occupied push to queue
        //for simulation we keep 3 platforms
        if(platforms.isEmpty()){
            waitList.add(train);
            return;
        }
        int availablePlatform = platforms.first();
        platforms.pollFirst();
        trainToPlatform.put(train, availablePlatform);
    }

    public void departTrain(int trainId){
        Train train=null;
        int platform=0;
        for (Map.Entry<Train, Integer> entry : trainToPlatform.entrySet()) {
            Train t = entry.getKey();
            if(t.getId()==trainId){
                train = t;
                platform = entry.getValue();
                break;
            }
        }
        trainToPlatform.remove(train);
        //take the first train from the waitlist
        if(waitList.isEmpty()){
            platforms.add(platform);
            return ;
        }
        Train latest = waitList.peek();
        waitList.poll();
        trainToPlatform.put(latest,platform);
    }
}
