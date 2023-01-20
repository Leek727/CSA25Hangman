class Player {
    private String name;
    private int score;
    private boolean ejected;

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
        this.score += newScore;
    }

    public void editEjected(boolean yes) {
        this.ejected = yes;
    }

    public String getName(){
        return this.name;
    }
    
    public int getScore(){
        return this.score;
    }

    public boolean getEjected(){
        return this.ejected;
    }
}
