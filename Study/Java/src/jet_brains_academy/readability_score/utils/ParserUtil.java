package jet_brains_academy.readability_score.utils;

import jet_brains_academy.readability_score.entity.TextData;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserUtil {

    public static TextData parse(List<String> lines) {

        TextData textData = new TextData(lines);
        String text = textData.getText();

        textData.setWords(findWords(text));
        textData.setSentences(findSenteces(text));
        textData.setSyllables(countSyllables(text));
        textData.setPolysyllables(countPolysyllables(text));
        textData.setCharacters(countCharacters(text));

        return textData;
    }

    private static List<String> findWords(String line) {

        List<String> words = new ArrayList<>();

        line = line.replaceAll("[\\d]+[,.][\\d]+", "1");
        String[] ls = line.split("[?!.,\\s\\)\\(]+");
        for (String l : ls) {
            words.add(l);
        }

        return words;
    }

    private static List<String> findSenteces(String line) {

        List<String> sentences = new ArrayList<>();
        line = line.replaceAll("[\\d]+[,.][\\d]+", "1");
        if (line.indexOf(".") != -1) {
            String[] ls = line.split("[?!.]");
            for (String l : ls) {
                sentences.add(l);
            }
        }

        return sentences;
    }

    private static int countSyllables(String line) {

        line = line.replaceAll("[\\d]+[,.][\\d]+", "1");

        String lineS = line.toLowerCase().
                replaceAll("e\\b", "").
                replaceAll("you", "a").
                replaceAll("[aeiouy]{2}", "a").
                replaceAll("\\bth\\b|\\bw\\b|\\b\\d+\\b", "a").
                replaceAll("[!.?,]", "");

        Matcher matcher = Pattern.compile("[aeiouy]").matcher(lineS);
        int syllables = 0;
        while (matcher.find()) {
            syllables++;
        }

        return syllables;

    }

    private static int countPolysyllables(String line) {

        line = line.replaceAll("[\\d]+[,.][\\d]+", "1");

        String lineS = line.toLowerCase().
                replaceAll("e\\b", "").
                replaceAll("you", "a").
                replaceAll("[aeiouy]{2}", "a").
                replaceAll("\\bth\\b|\\bw\\b|\\b\\d+\\b", "a").
                replaceAll("[!.?,]", "");

        Matcher matcher = Pattern.compile("\\b[\\S^oiyuea]*[oiuyea][\\S^oiyuea]*[oiyeua][\\S^oiuyea]*[oiyeua][\\S^oiuyea]*\\b").matcher(lineS);
        int polysyllables = 0;
        while (matcher.find()) {
            polysyllables++;
        }

        return polysyllables;
    }

    private static int countCharacters(String line) {

        return line.replaceAll("[\\s]", "").toCharArray().length;

    }

}
