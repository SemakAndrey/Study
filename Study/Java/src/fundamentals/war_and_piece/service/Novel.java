package fundamentals.war_and_piece.service;

import fundamentals.war_and_piece.utils.PrinterUtil;

import java.util.*;

public class Novel {

    private final String text;
    private final Map<String, Integer> mapWords;
    private final Set<Map.Entry<String, Integer>> topWords;

    public Novel(String text) {

        this.mapWords = new HashMap<>();
        this.text = text;
        this.topWords = new TreeSet<>((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        if (!text.isBlank()) {
            fillMapWords();
            fillTopWords();
        }
    }

    public String getText() {
        return this.text;
    }

    private void fillMapWords() {

        String[] words = this.text.split("[\\p{Punct}\"\\s]+");
        for (String word : words) {
            Integer value = mapWords.get(word.toLowerCase());
            mapWords.put(word.toLowerCase(), value == null ? 1 : ++value);
        }

    }

    private void fillTopWords() {

        if (!this.mapWords.isEmpty()) {
            this.topWords.addAll(this.mapWords.entrySet());
        }

    }

    public Set<String> getUniqueWords() {

        if (this.mapWords.isEmpty()) {
            return null;
        }

        return this.mapWords.keySet();
    }

    public void printTopWords(int numberWords) {

        if (this.mapWords.isEmpty()) {
            System.out.println("The text hasn't words!!");
            return;
        }

        for (Map.Entry<String, Integer> topWord : this.topWords) {
            PrinterUtil.print(topWord.getKey(), topWord.getValue());
            if (--numberWords == 0) {
                break;
            }
        }

    }

}
