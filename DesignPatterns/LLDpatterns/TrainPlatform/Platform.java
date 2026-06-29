package DesignPatterns.LLDpatterns.TrainPlatform;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;

public class Platform {
    int numberOfPlatforms = 3;
    TreeSet<Integer> platforms;
    Queue<Train> waitList;
    HashMap<Train, Integer> trainToPlatform;
    HashMap<Integer, Train> platformToTrain;

    public Platform(){
        platforms = new TreeSet<>();
        waitList = new LinkedList<>();
        trainToPlatform = new HashMap<>();
        platformToTrain = new HashMap<>();

        for (int i = 1; i <= numberOfPlatforms; i++) {
            platforms.add(i);
        }
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
        platformToTrain.put(availablePlatform, train);

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
        platformToTrain.remove(platform);
        //take the first train from the waitlist
        if(waitList.isEmpty()){
            platforms.add(platform);
            return ;
        }
        Train latest = waitList.peek();
        waitList.poll();
        trainToPlatform.put(latest,platform);
        platformToTrain.put(platform, latest);
    }

    public void displayPlatform(){
        int train = 0;
        int platform =0;
        for(Map.Entry<Integer,Train>entry: platformToTrain.entrySet()){
            platform = entry.getKey();
            train = entry.getValue().getId();
            System.out.println("Platform: "+ platform+ "is occupied with Train: "+ train);
        }
    }
}
