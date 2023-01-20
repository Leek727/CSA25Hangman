class Player {
    public String name;
    public int score;
    public boolean ejected;

    //intialize the player as a class
    //there are no specific preconditions
    public Player(){
        this.name = "";
        this.score = 0;
        this.ejected = false;
    }

    //edits the name of the player class
    //must input a string parameter
    public void editName(String name) {
        this.name = name;
    }

    //edits the new score of the player class
    //must input a int parameter
    public void editScore(int newScore) {
        this.score = newScore;
    }
}
