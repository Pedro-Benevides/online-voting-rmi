package Classes;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Classes.Interfaces.ClientI;
import Classes.Interfaces.RemoteVotingI;

public class Client extends UnicastRemoteObject implements ClientI, RemoteVotingI {
    private RemoteVotingI votingServer;

    protected Client() throws RemoteException {
        super();
    }

    public RemoteVotingI getVotingServer() {
        return votingServer;
    }

    public void setVotingServer(RemoteVotingI votingServer) {
        this.votingServer = votingServer;
    }

    @Override
    public void RegisterVote(int vote) {
        try {
            if (vote > 2) {
                System.out.println("Voto invalido");
            } else {
                this.getVotingServer().RegisterVote(vote);
            }
        } catch (RemoteException e) {

            e.printStackTrace();
        }
    }

    @Override
    public String ShowResults() throws RemoteException {
        return this.getVotingServer().ShowResults();
    }

    @Override
    public void ConnectServer() {
        try {
            // Obter o servidor de votação no registro de nomes
            RemoteVotingI votingServer = (RemoteVotingI) Naming.lookup("//127.0.0.1:1099/VotingServer");

            this.setVotingServer(votingServer);
            System.err.println("Conexão com servior estabelecida");

            // Inicio da thread de Votação
            new Vote(this);

        } catch (MalformedURLException e) {
            e.toString();
            e.printStackTrace();
        } catch (RemoteException e) {
            e.toString();
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.toString();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Client client = new Client();

            // Conectar ao servidor de votação
            client.ConnectServer();
        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.toString());
            e.printStackTrace();
        }
    }

}
