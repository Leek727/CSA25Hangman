import java.util.Random;
import java.util.Scanner;

public class Game {
    public int numPlayers;
    public boolean solved;
    public int round;
    public int pointValue;

    private Phrase phraseObject = new Phrase();
    public Player[] players;

    Scanner input = new Scanner(System.in);
    
    // called initially
    public void play(int numPlayers) {

        //initalize variables
        this.numPlayers = numPlayers;
        this.solved = false;

        //add players to the player array
        this.players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++){
            this.players[i] = new Player();
            this.players[i].name = getInput("Hello player " + (i+1) + ". Please enter your name.");
        }

        //Wecome message
        System.out.println("Welcome to Hangman! In this game you will be given a random phrase that you will need to guess. Each round, every player will have a guess at potential charachters or the entire phrase. If you incorectly guess a character, you will loose points for that round. If you incorectly guess a phrase, you are ejected from the game. The first person to complete the phrase wins the game. Good luck, and have fun!");
        System.out.print("\nThe game will now commence: ");

        System.out.println(phraseObject.displayCurrentPhrase());
        
        
        // game logic
        while (!solved) {
            System.out.println("ROUND " + this.round + ": " + phraseObject.displayCurrentPhrase());
            changePtValue();
            
            for (Player curPlayer : players) {
                System.out.println("Guess the phrase (a) or guess the character (b) : ");
                if (input.next().charAt(0) == 'a'){
                    System.out.println("Input phrase: ");
                    if (phraseObject.phraseString.equals(input.next())){
                        victory(curPlayer.name);
                        solved = true;
                        break;
                    }
                    else{
                        System.out.println("Wrong!");
                    }
                }
                else {
                    System.out.println("Guess a char " + curPlayer.name + ": ");
                    if (phraseObject.checkCharacter(input.next().charAt(0))){
                        curPlayer.score += this.pointValue;
                        System.out.println("Correct! You got " + this.pointValue + " points!");
                    }
                    else {
                        System.out.println("Incorrect!");
                    }
                }
            }
            incrementRound();
        }      
        
    }
    
    // this is called to get the user input, returns the user input string
    private void incrementRound() {
        this.round += 1;
    }

    // this is called to get the user input, returns the user input string
    private String getInput(String what) {
        System.out.println(what + "\n >:");
        String data = input.next();
        return data;
    }

    // this is called every round after all the players have answered, and prints the scoreboard
    private void displayPts() {
        System.out.println("------------SCOREBOARD------------");
        for (Player player : this.players) {
            System.out.println(player.name + ": " + player.score);
        }
        System.out.println("------------------------");
    }

    // this is called after a user wins, and prints their name
    private void victory(String victoriousPlayer) {
        System.out.println("The game has been won by " + victoriousPlayer);
    }
    
    // this is called every round, and updates the point value with a random number
    private void changePtValue() {
        Random rand = new Random(); 
        this.pointValue = rand.nextInt(10_000_000);
    }
}
