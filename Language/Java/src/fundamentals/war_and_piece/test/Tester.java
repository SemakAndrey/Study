package fundamentals.war_and_piece.test;

import fundamentals.war_and_piece.service.Novel;
import fundamentals.war_and_piece.service.searchers.EasySearch;
import fundamentals.war_and_piece.service.searchers.EasySearchV2;
import fundamentals.war_and_piece.service.searchers.RegExSearch;
import fundamentals.war_and_piece.service.searchers.core.ISearchEngine;
import fundamentals.war_and_piece.utils.PrinterUtil;

public class Tester {

    private Novel novel;

    public Tester(Novel novel) {
        this.novel = novel;
    }

    public void printTop() {
        System.out.println("Task 2 _______________________");
        this.novel.printTopWords(10);
    }

    public void testSearchEngine() {

        System.out.println("Task 5 _______________________");
        String text = novel.getText();

        ISearchEngine search = new EasySearch();
        System.out.println("EasySearch :");
        PrinterUtil.print("война", search.search(text, "война"));
        //на "и" валится в StackOverflow на моем компе
        //Printer.print("и", search.search(text, " и "));
        PrinterUtil.print("мир", search.search(text, "мир "));

        search = new EasySearchV2();
        System.out.println("EasySearchV2 :");
        PrinterUtil.print("война", search.search(text, "война"));
        PrinterUtil.print("и", search.search(text, " и "));
        PrinterUtil.print("мир", search.search(text, "мир"));

        search = new RegExSearch();
        System.out.println("RegExSearch :");
        PrinterUtil.print("война", search.search(text, "\\b[В|в]ойна\\b"));
        PrinterUtil.print("и", search.search(text, "\\b[И|и]\\b"));
        PrinterUtil.print("мир", search.search(text, "\\b[М|м]ир\\b"));

    }

}
