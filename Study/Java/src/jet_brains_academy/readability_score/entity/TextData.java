package jet_brains_academy.readability_score.entity;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private String text;
    private List<String> words;
    private List<String> sentences;
    private int syllables;
    private int polysyllables;
    private int characters;

    public Storage(List<String> lines) {

        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line);
        }

        this.text = sb.toString();
        this.words = new ArrayList<>();
        this.sentences = new ArrayList<>();
        this.syllables = 0;
        this.polysyllables = 0;
        this.characters = 0;
    }

    public String getText() {
        return text;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public List<String> getSentences() {
        return sentences;
    }

    public void setSentences(List<String> sentences) {
        this.sentences = sentences;
    }

    public int getSyllables() {
        return syllables;
    }

    public void setSyllables(int syllables) {
        this.syllables = syllables;
    }

    public int getPolysyllables() {
        return polysyllables;
    }

    public void setPolysyllables(int polysyllables) {
        this.polysyllables = polysyllables;
    }

    public int getCharacters() {
        return characters;
    }

    public void setCharacters(int characters) {
        this.characters = characters;
    }

    public void print() {

        System.out.println("The text is:\n" + this.text);
        System.out.println("\nWords: " + this.words.size());
        System.out.println("Sentences: " + this.sentences.size());
        System.out.println("Characters: " + this.characters);
        System.out.println("Syllables: " + this.syllables);
        System.out.println("Polysyllables: " + this.polysyllables);

    }
}

