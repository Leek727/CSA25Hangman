import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.*;

class Phrase {
    public String phraseString; //made this pulic for debuging
    private char[] guessedCharacters;
    public int phraseLength;
    
    public Phrase() {
        //initalize game elements
        this.phraseString = createPhrase();
        this.phraseLength = phraseString.replaceAll("\\s", "").length();
        this.guessedCharacters = new char[phraseLength];
    }

    private int numberGenerator(double max) {
        int number = 0;
        while (number <= 0) { //will never return zero
            number = (int) (Math.random() * max);
        }
        return number;
    }

    private String createPhrase() {
        int numberOfWords = numberGenerator(10);
        String buildingPhrase = "";
        for (int i = 0; i < numberOfWords; i++) {
            buildingPhrase = buildingPhrase + " " + grabRandomWord() + " ";
        }
        return buildingPhrase;
    }

    private String grabRandomWord() {
        String word = null;
        try (Stream<String> words = Files.lines(Paths.get("wordList.txt"))) {
            word = words.skip(numberGenerator(466550)).findFirst().get();
        } catch (IOException e) {
            System.out.println("Problem getting word.");
        }
        return word;
    }

    private boolean checkCharacter(char character) {
        for (int i = 0; i < this.phraseString.length(); i++) {
            if (this.phraseString.charAt(i) == character) {
                this.guessedCharacters[i] = character;
                return true;
            }
        }
        return false;
    }
}
