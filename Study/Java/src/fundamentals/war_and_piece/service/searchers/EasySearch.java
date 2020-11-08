package fundamentals.war_and_piece.service.searchers;


import fundamentals.war_and_piece.service.searchers.core.ISearchEngine;

public class EasySearch implements ISearchEngine {

    private long counter = 0L;

    @Override
    public long search(String text, String word) {

        countDuplicates(text.toLowerCase(), word, 0);
        return this.counter;

    }

    private void countDuplicates(String text, String word, int indexFrom) {

        indexFrom = text.indexOf(word, indexFrom);
        if (indexFrom == -1) {
            return;
        }

        this.counter++;
        countDuplicates(text, word, indexFrom + word.length());

    }

}
