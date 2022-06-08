package search;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        
        if (args[0].equals("--data")) {
            DataEntry dataEntry = new DataEntry(args[1]);
            List<String> entries = dataEntry.collectEntries();
            Map<String, List<Integer>> invertedIndex = dataEntry.createIndex();
            Scanner scanner = new Scanner(System.in);
            UserInterface ui = new UserInterface(scanner, entries, invertedIndex);
            ui.start();
        }

    }
}
