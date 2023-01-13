class Phrase {
    private String phraseString;
    private char[] guessedCharacters;
    public int phraseLength;

    
    public Phrase() {
        //initalize game elements
        this.phraseString = createPhrase();
        this.phraseLength = phraseString.replaceAll("\\s", "").length();
        this.guessedCharacters = new char[phraseLength];

        //initalize file reading elements
        //still working on
    }

    private String createPhrase() {
        return "Nothing yet";
    }

    /*
    private String grabWord() {
        return "Nothing Yet";
    } */
}
