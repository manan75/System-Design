package DesignPatterns.LLDpatterns.Leaderboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class Leaderboard {

    HashMap<Integer, Player> players;
    TreeSet<Player> leaderboard;

    public Leaderboard() {
        players = new HashMap<>();

        //custom iterator to get sort by biggest score first (descending order)
        leaderboard = new TreeSet<>((a, b) -> {
            if (a.getScore() != b.getScore()) {
                return Integer.compare(b.getScore(), a.getScore());
            }
            return Integer.compare(a.getId(), b.getId());
        });
    }

    public void addScore(int id, int score) {
        //if player does not exist first create it and add in players and leaderboard
        if (!players.containsKey(id)) {
            Player player = new Player(id, score);
            players.put(id, player);
            leaderboard.add(player);
            return;
        }
        //to update the leaderboard first get the player and then remove it and then add the updated score
        Player player = players.get(id);
        leaderboard.remove(player);
       int curr =  player.getScore();
       curr+=score;
       player.setScore(curr);
        leaderboard.add(player);
    }
    //remove the player from both player and leaderboard
    public void reset(int id) {
        if (!players.containsKey(id)) {
            return;
        }
        Player player = players.get(id);
        leaderboard.remove(player);
        players.remove(id);
    }
    //using an iterator 
    public List<Player> topK(int K) {
        List<Player> ans = new ArrayList<>();
        Iterator<Player> it = leaderboard.iterator();
        while (K > 0 && it.hasNext()) {
            ans.add(it.next());
            K--;
        }
        return ans;
    }
}