package fundamentals.war_and_piece.service.searchers;

import fundamentals.war_and_piece.service.searchers.core.ISearchEngine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExSearch implements ISearchEngine {

    @Override
    public long search(String text, String regex) {

        long count = 0L;

        Matcher matcher = Pattern.compile(regex).matcher(text);
        while (matcher.find()) {
            count++;
        }

        return count;
    }
}
