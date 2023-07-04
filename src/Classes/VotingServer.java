package Classes;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Classes.Interfaces.RemoteVotingI;
import Classes.Interfaces.ServerI;

public class VotingServer extends UnicastRemoteObject implements ServerI, RemoteVotingI {

    private Map<String, Integer> votes = new HashMap<String, Integer>();
    private List<VotingServerCopy> serverCopies = new ArrayList<VotingServerCopy>();

    public VotingServer() throws RemoteException {
        this.getVotes().put("1", 0);
        this.getVotes().put("2", 0);
    }

    public Map<String, Integer> getVotes() {
        return votes;
    }

    public List<VotingServerCopy> getServerCopies() {
        return serverCopies;
    }

    public void StartServer() {
        try {
            // Iniciar o registro RMI no servidor
            // VotingServerCopy serverCopy = new VotingServerCopy();
            Registry registry = LocateRegistry.createRegistry(1099);

            // Registrar o servidor de votação no registro de nomes
            registry.rebind("VotingServer", this);
            // this.AddServerCopy(serverCopy);

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
                .filter(votes -> votes.getKey() == option)
                .map(votes -> votes.getValue())
                .collect(Collectors.toList());

        for (int votes : optionVotes) {
            totalVotes += votes;
        }

        return totalVotes;
    }

    public void RegisterVote(int optionVote) {
        String option = String.valueOf(optionVote);
        if (optionVote == 1) {
            this.getVotes().put(option, this.getVotes().get(option) + 1);
        } else {
            this.getVotes().put(option, this.getVotes().get(option) + 1);
        }

    }

    public String ShowResults() {
        return ("\n Votos na opção 1: " + this.LocalVotes("1")) + ("\n Votos na opção 2: " + this.LocalVotes("2"));
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
