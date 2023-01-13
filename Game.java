import java.util.Random;
import java.util.Scanner;

public class Game {
    public int numPlayers;
    public boolean solved;
    public int round;
    public int pointValue;

    private Phrase phraseObject = new Phrase();

    Scanner input = new Scanner(System.in);

    public Player[] players;

    public void play(int numPlayers) {

        this.numPlayers = numPlayers;
        this.solved = false;

        this.players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++){
            this.players[i] = new Player();
            this.players[i].name = getInput("Hello player " + i + ". Please enter your name.");
        }
    }
    
    private void incrementRound() {
        this.round += 1;
    }

    private void editScore() {
        //Don't know what this is for
    }

    private String getInput(String what) {
        System.out.println(what + "\n >:");
        String data = input.next();
        return data;
    }

    private void displayPts() {
        System.out.println("------------SCOREBOARD------------");
        for (Player player : this.players) {
            System.out.println(player.name + ": " + player.score);
        }
        System.out.println("------------------------");
    }

    private void victory(String victoriousPlayer) {
        System.out.println("The game has been won by " + victoriousPlayer);
    }
    
    private void changePtValue() {
        Random rand = new Random(); 
        this.pointValue = rand.nextInt(10_000_000);
    }
}
