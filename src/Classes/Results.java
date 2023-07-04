package Classes;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Results {
    private int totalVotes;
    private Map<String, Integer> localResults;

    public Results(int totalVotes, Map<String, Integer> localResults) {
        this.totalVotes = totalVotes;
        this.localResults = localResults;

        this.ShowLocalResults();
    }

    public Map<String, Integer> getLocalResults() {
        return localResults;
    }

    public void ShowLocalResults() {

        System.out.println("\n Votos na opção 1: " + this.countVotes("1"));

        System.out.println("\n Votos na opção 2: " + this.countVotes("2"));

    }

    private int countVotes(String option) {
        int totalVotes = 0;

        List<Integer> optionVotes = this.getLocalResults().entrySet()
                .stream()
                .filter(votes -> votes.getKey() == option)
                .map(votes -> votes.getValue())
                .collect(Collectors.toList());

        for (int votes : optionVotes) {
            totalVotes += votes;
        }

        return totalVotes;
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
