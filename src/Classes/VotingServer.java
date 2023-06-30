package Classes;

import java.util.List;
import java.util.Map;

import Classes.Interfaces.RemoteVotingI;
import Classes.Interfaces.ServerI;

public class VotingServer implements ServerI, RemoteVotingI {
    private Map<String, Integer> votes;
    private List<VotingServerCopy> serverCopies;

    public Map<String, Integer> getVotes() {
        return votes;
    }

    public void setVotes(Map<String, Integer> votes) {
        this.votes = votes;
    }

    public List<VotingServerCopy> getServerCopies() {
        return serverCopies;
    }

    public void setServerCopies(List<VotingServerCopy> serverCopies) {
        this.serverCopies = serverCopies;
    }

    public void StartServer() {

    }

    public void CloseServer() {

    }

    public void AddServerCopy() {
        this.getServerCopies().add(null);
    }

    public void RemoveServerCopy(VotingServerCopy serverCopy) {
        this.getServerCopies().remove(serverCopy);
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
