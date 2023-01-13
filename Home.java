class Home {
    public static void main(String[] args) {
        int numberOfPlayers = 3;

        Game gameRunner = new Game();
        gameRunner.play(numberOfPlayers);
        System.out.println(gameRunner.players);
        System.out.println(gameRunner.solved);
    }

}