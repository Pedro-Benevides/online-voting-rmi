package Classes;

import java.rmi.RemoteException;

public class VotingServerCopy extends VotingServer {

    public VotingServerCopy() throws RemoteException {
        this.getVotes().put("1", 0);
        this.getVotes().put("2", 0);
    }
}
