package DesignPatterns.LLDpatterns.HitCounter;

public class HitCounterMain {
    
    public static void main(String[] args) {
        
        Page pg = new Page();

        pg.recordHit("/home");
        pg.recordHit("/home");
        pg.recordHit("/about");
        pg.recordHit("/contacts");

       System.out.println( pg.getHits("/home"));
       System.out.println(pg.getHits("/about")); 
       System.out.println(pg.getHits("/hi")); 

    }
}
