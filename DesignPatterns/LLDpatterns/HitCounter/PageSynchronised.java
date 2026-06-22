package DesignPatterns.LLDpatterns.HitCounter;

import java.util.HashMap;
import java.util.Map;

public class PageSynchronised {
    
    private final Map<String, Integer> pageHits;

    public PageSynchronised() {
        pageHits = new HashMap<>();
    }

    public synchronized void recordHit(String page) {
        pageHits.put(page,
                pageHits.getOrDefault(page, 0) + 1);
    }

    public synchronized int getHits(String page) {
        return pageHits.getOrDefault(page, 0);
    }
}
