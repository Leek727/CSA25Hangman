import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.*;

class Phrase {
    private String phraseString; //made this pulic for debuging
    private char[] guessedCharacters;

    //intializes the phrase class
    //will occur whenever a game class is intializes
    //this will create the phrase, length of the phrase and array of guessedCharacters
    public Phrase() {
        //initalize game elements
        this.phraseString = createPhrase();
        int phraseLength = phraseString.length();
        this.guessedCharacters = new char[phraseLength];
    }

    /**
     * Attempt to generate a random number
     * 
     * Precondition:
     *      parameter 'max' must exist as a double
     * Postcondition:
     *      modifies the int number to return a random number from zero to max
     */
    private int numberGenerator(double max) {
        int number = 0;
        while (number <= 0) { //will never return zero
            number = (int) (Math.random() * max);
        }
        return number;
    }

    //generates a phrase from the word list
    private String createPhrase() {
        int numberOfWords = numberGenerator(6);
        String buildingPhrase = "";
        for (int i = 0; i < numberOfWords; i++) {
            buildingPhrase = buildingPhrase + " " + grabRandomWord() + " ";
        }
        return buildingPhrase.toLowerCase();
    }

    //grabs a random word from the word list
    private String grabRandomWord() {
        String word = null;
        try (Stream<String> words = Files.lines(Paths.get("wordList.txt"))) {
            word = words.skip(numberGenerator(466550)).findFirst().get();
        } catch (IOException e) {
            System.out.println("Problem getting word.");
        }
        return word.stripLeading().stripTrailing();
    }

    //checks if a char character is in the phraseString for the game class
    public boolean checkCharacter(char character) {
        boolean foundChar = false;
        for (int i = 0; i < this.phraseString.length(); i++) {
            if (this.guessedCharacters[i] == character) {
                return foundChar;
            }
            else if (this.phraseString.charAt(i) == character) {
                this.guessedCharacters[i] = character;
                foundChar = true;
            }
        }
        return foundChar;
    }

    public String displayCurrentPhrase() {
        String workingPhrase = "";
        for (char character : guessedCharacters) {
            if (character == 0) {
                workingPhrase += "_";
            } else {
                workingPhrase += character;
            }
        }
        return workingPhrase;
    }

    public boolean checkEntirePhrase(String input) {
        if (this.phraseString.equals(input)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkIfWon(){
        for (char character : guessedCharacters) {
            if (character == 0)
                return false;
        }
        return true;
    }
}
