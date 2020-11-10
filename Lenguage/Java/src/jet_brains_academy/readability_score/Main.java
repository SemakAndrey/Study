package jet_brains_academy.readability_score;

import jet_brains_academy.readability_score.entity.TextData;
import jet_brains_academy.readability_score.service.ScoreCalculator;
import jet_brains_academy.readability_score.utils.InteractionUtil;
import jet_brains_academy.readability_score.utils.ParserUtil;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        if (args.length == 0) {
            return;
        }

        List<String> lines = InteractionUtil.readInputData("./" + args[0]);
        TextData textData = ParserUtil.parse(lines);

        String option = InteractionUtil.getOption();
        ScoreCalculator score = new ScoreCalculator(textData);
        score.calculate(option);
        score.print();

    }

}

