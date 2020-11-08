package fundamentals.war_and_piece.service.searchers;


import fundamentals.war_and_piece.service.searchers.core.ISearchEngine;

public class EasySearchV2 implements ISearchEngine {

    @Override
    public long search(String text, String word) {

        long counter = 0L;
        int wordLength = word.length();
        int index = text.indexOf(word);

        while (index != -1) {
            counter++;
            index = text.indexOf(word, index + wordLength);
        }

        return counter;

    }

}
