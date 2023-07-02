package Classes;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

import Classes.Interfaces.RemoteVotingI;
import Classes.Interfaces.ServerI;

public class VotingServer extends UnicastRemoteObject implements ServerI, RemoteVotingI {

    private Map<String, Integer> votes;
    private List<VotingServerCopy> serverCopies;

    public VotingServer() throws RemoteException {
        //
    }

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

    public static void main(String[] args) {
        try {
            // Criar e exportar a instância do servidor de votação
            VotingServer servidor = new VotingServer();
            // RemoteVotingI stub = (RemoteVotingI)
            // UnicastRemoteObject.exportObject(servidor, 0);

            // Iniciar o registro RMI no servidor
            Registry registry = LocateRegistry.createRegistry(1099);

            // Registrar o servidor de votação no registro de nomes
            registry.rebind("VotingServer", ((RemoteVotingI) servidor));

            System.out.println("Servidor de votação pronto para receber conexões.");
        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
