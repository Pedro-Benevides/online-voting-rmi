package Classes;

import java.util.Map;

import Classes.Interfaces.RemoteVotingI;
import Classes.Interfaces.ServerI;

public class VotingServerCopy implements ServerI, RemoteVotingI {
    private Map<String, Integer> votes;

    public Map<String, Integer> getVotes() {
        return votes;
    }

    public void setVotes(Map<String, Integer> votes) {
        this.votes = votes;
    }

    public void StartServer() {

    }

    public void CloseServer() {

    }

    public int LocalVotes() {
        // TODO: percorrer somando os votos
        return 1;
    }

    public void RegisterVote(int vote) {
        this.getVotes().put(null, null);
    }

    public Results ShowResults() {
        return new Results();
    }
}
