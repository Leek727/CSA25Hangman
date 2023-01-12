class Phrase {
    private String phraseString;
    private char[] guessedCharacters;
    public int phraseLength;
    
    public Phrase() {
        this.phraseString = createPhrase();
        this.phraseLength = phraseString.replaceAll("\\s", "").length();
        this.guessedCharacters = new char[phraseLength];
    }

    private String createPhrase() {
        return "Nothing yet";
    }
}
