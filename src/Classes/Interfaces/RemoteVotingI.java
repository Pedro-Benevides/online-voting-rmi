package Classes.Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteVotingI extends Remote {
    public void RegisterVote(int vote) throws RemoteException;

    public String ShowResults() throws RemoteException;

}
