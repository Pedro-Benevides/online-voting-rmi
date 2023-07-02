package Classes.Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Classes.Results;

public interface RemoteVotingI extends Remote {
    public void RegisterVote(int vote) throws RemoteException;

    public Results ShowResults() throws RemoteException;

}
