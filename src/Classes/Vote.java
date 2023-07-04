package Classes;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;

import Classes.Interfaces.RemoteVotingI;

public class Vote extends Thread {
    RemoteVotingI voting;

    public Vote(RemoteVotingI votingI) {
        this.voting = votingI;
        System.out.println("Utilize as teclas de 1 e 2 do teclado para votar na opcao desejada.");

        this.run();
    }

    public void run() {
        Boolean choice = true;
        while (choice) {
            try {
                System.out.println("\n Qual o melhor? \n 1)Bahia \n 2)Vitoria");

                DataInputStream in = new DataInputStream(System.in);
                BufferedReader buffer = new BufferedReader(new InputStreamReader(in));

                this.voting.RegisterVote(Integer.valueOf(buffer.readLine()));

                // Controle da repetição do loop
                System.out.println("\n 1)Votar novamente \n 2)Mostrar resultados atualizados e sair");

                DataInputStream voteAgain = new DataInputStream(System.in);
                BufferedReader choiceBuffer = new BufferedReader(new InputStreamReader(voteAgain));

                if (Integer.valueOf(choiceBuffer.readLine()) != 1) {
                    choice = false;
                    System.out.println(this.voting.ShowResults());
                }

            } catch (Exception e) {
                e.toString();
                e.printStackTrace();
            }
        }
    }
}
