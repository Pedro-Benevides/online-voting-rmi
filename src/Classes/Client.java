package Classes;

import Classes.Interfaces.ClientI;
import Classes.Interfaces.RemoteVotingI;

public class Client implements ClientI, RemoteVotingI {
    private VotingServer votingServer;

    public VotingServer getVotingServer() {
        return votingServer;
    }

    public void setVotingServer(VotingServer votingServer) {
        this.votingServer = votingServer;
    }

    public void RegisterVote(int vote) {

    }

    public Results ShowResults() {
        return new Results();
    }

    public void ConnectServer() {

    }
}
