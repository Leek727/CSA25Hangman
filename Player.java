class Player {
    public String name;
    public int score;

    public Player(){
        this.name = "";
        this.score = 0;
    }

    public void editName(String name) {
        this.name = name;
    }

    public void editScore(int newScore) {
        this.score = newScore;
    }
}
