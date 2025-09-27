package exercise1.creational.singleton;

import java.util.HashMap;
import java.util.Map;

public class VotingSystem {
    private static volatile VotingSystem instance; // thread-safe lazy init
    private final Map<String, Integer> votes;

    private VotingSystem() {
        votes = new HashMap<>();
    }

    public static VotingSystem getInstance() {
        if (instance == null) {  // first check
            synchronized (VotingSystem.class) {
                if (instance == null) {  // second check (double-checked locking)
                    instance = new VotingSystem();
                }
            }
        }
        return instance;
    }

    public synchronized void castVote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        System.out.println("Vote casted for " + candidate);
    }

    public void showResults() {
        System.out.println("Current Voting Results:");
        votes.forEach((c, v) -> System.out.println(c + " : " + v + " votes"));
    }
}
