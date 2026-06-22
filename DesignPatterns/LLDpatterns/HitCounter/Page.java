package DesignPatterns.LLDpatterns.HitCounter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Page {
    
    private HashMap<String,Integer> pageHits;
    private HashMap<String, Deque<Integer>> Last5mins;
    public Page(){
        pageHits = new HashMap<>();
        Last5mins = new HashMap<>();
    }
   public void recordHit(String page) {
    int count = pageHits.getOrDefault(page, 0);
    pageHits.put(page, count + 1);
    }

   public void recordHit(String page, int timeStamp){
        Last5mins.putIfAbsent(page, new ArrayDeque<>());
        Last5mins.get(page).addLast(timeStamp);
    }
    public int getHits(String page){
        int count  = pageHits.getOrDefault(page, 0);
        return count;
    }
    //last 5 mins means 300 sec
    public int last5minHits(String page, int currTime){
        Deque<Integer> dq = Last5mins.get(page);
        if(dq == null) return 0;
        while(!dq.isEmpty() &&
            dq.peekFirst() < currTime - 300)
        {
            dq.pollFirst();
        }
        return dq.size();
    }

    //we create the pq every time per call isntead of maintaing it gloabally, as gethits calls 
    // are far more than getTopK
  public List<String> getTopK(int k) {

    List<String> result = new ArrayList<>();
    //min heap
    PriorityQueue<Map.Entry<String,Integer>> pq =
        new PriorityQueue<>(
            (a,b) -> a.getValue() - b.getValue()
        );
        //min heap of size K so the only the required ones stay
    for(Map.Entry<String,Integer> entry : pageHits.entrySet()) {
        pq.offer(entry);

        if(pq.size() > k) {
            pq.poll();
        }
    }

    while(!pq.isEmpty()) {
        result.add(pq.poll().getKey());
    }
    return result;
}
}
