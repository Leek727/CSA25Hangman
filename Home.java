class Home {
    public static void main(String[] args) {
        int numberOfPlayers = 3;

        Game gameRunner = new Game();
        gameRunner.play(numberOfPlayers);
        System.out.println("Players: ");
        for (int i = 0; i < gameRunner.numPlayers; i++){
            System.out.println("Player name : " + gameRunner.players[i].name);
            System.out.println("Player score : " + gameRunner.players[i].score);
            
        }
    }
}