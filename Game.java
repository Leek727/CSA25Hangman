import java.util.Random;
import java.util.Scanner;

public class Game {
    public int numplayers;
    public boolean solved;
    public int round;
    public int pointvalue;

    private Phrase phraseObject = new Phrase();

    Scanner input = new Scanner(System.in);

    Player[] players;

    public void play(int numplayers) {

        this.solved = false;

        Player[] players = new Player[numplayers];
        for (int i = 0; i < numplayers; i++){
            players[i] = new Player();
            players[i].name = "Test";
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
        this.pointvalue = rand.nextInt(10_000_000);
    }
}
