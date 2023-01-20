class Home {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");

        int numberOfPlayers = 2;

        Game gameRunner = new Game();
        gameRunner.play(numberOfPlayers);
    }
}