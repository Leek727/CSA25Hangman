import java.util.Random;

public class Game {
    public int numplayers;
    public boolean solved;
    public int round;
    public int pointvalue;

    public void play(int numplayers){
        Player[] players = new Player[numplayers];
        for (int i = 0; i < numplayers; i++){
            players[i] = new Player();
            players[i].name = "Test";
        }

        

        
    }
    
    private void incrementRound(){

    }

    private void editScore(){

    }

    private void getInput(){

    }

    private void displayPts(){

    }

    private void victory(){

    }
    
    private changePtValue(){
        Random rand = new Random(); 
        this.pointvalue = rand.nextInt(10_000_000);
    }
}
