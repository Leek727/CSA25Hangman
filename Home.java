class Home {
    public static void main(String[] args) {
        int numberOfPlayers = 3;

        Game gameRunner = new Game();
        gameRunner.play(numberOfPlayers);
    }
}