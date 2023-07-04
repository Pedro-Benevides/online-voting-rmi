package Classes;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        try {
                // Iniciar o registro RMI no servidor
                VotingServerCopy serverCopy = new VotingServerCopy();
                Registry registry = LocateRegistry.createRegistry(1099);
    
                // Registrar o servidor de votação no registro de nomes
                registry.rebind("VotingServer", ((RemoteVotingI) serverCopy));
                this.AddServerCopy(serverCopy);
    
                System.out.println("Servidor de votação pronto para receber conexões.");
            
        } catch (Exception e) {
            e.toString();
            e.printStackTrace();
        }
    }

    public void CloseServer() {
        //
    }

    public void AddServerCopy(VotingServerCopy serverCopy) {
        this.getServerCopies().add(serverCopy);
    }

    public void RemoveServerCopy(VotingServerCopy serverCopy) {
        this.getServerCopies().remove(serverCopy);
    }

    public int LocalVotes(String option) {
        int totalVotes = 0;

        List<Integer> optionVotes = this.getVotes().entrySet()
        .stream()
        .filter(votes -> votes.getKey() == option )
        .map( votes -> votes.getValue() )
        .collect(Collectors.toList());

        for (int votes:optionVotes){
            totalVotes += votes;
        }

        return totalVotes;
    }

    public void RegisterVote(int vote) {
        if (vote == 1) {
            this.getVotes().put("1", 1);
        } else {
            this.getVotes().put("2", 1);
        }
    }

    public Results ShowResults() {
        return new Results();
    }

    public static void main(String[] args) {
        try {
            // Criar a instância do servidor de votação
            VotingServer servidor = new VotingServer();

            servidor.StartServer();
        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
