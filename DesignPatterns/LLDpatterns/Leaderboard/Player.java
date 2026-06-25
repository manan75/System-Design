package DesignPatterns.LLDpatterns.Leaderboard;

public class Player {
    private int id;
    // private String name;
    private int score;

    public Player(int id, int score){
        //instantiate the id
        this.id = id;
        this.score = score;
    }
    //getters

    // public String getName(){
    //     return name;
    // }

    public int getScore(){
        return score;
    }
    public int getId(){
        return id;
    }

    public void setScore(int score){
        this.score = score;
    }
    

}
