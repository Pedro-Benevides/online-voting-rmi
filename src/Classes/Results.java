package Classes;

import java.util.Map;

public class Results {
    private int totalVotes;
    private Map<String,Integer> localResults;

    public Map<String, Integer> getLocalResults() {
        return localResults;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public void addLocalVotes() {
        this.totalVotes += 1;
    }

    public void addLocalResults() {
     this.localResults.put(null, null);   
    }
}
