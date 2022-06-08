package search;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner;
    List<String> entries;
    Map<String, List<Integer>> invertedIndex;

    public UserInterface(Scanner scanner, List<String> entries, Map<String, List<Integer>> invertedIndex) {
        this.scanner = scanner;
        this.entries = entries;
        this.invertedIndex = invertedIndex;
    }

    public void start(){
        while (true){
            System.out.println("=== Menu ===");
            System.out.println("1. Find a person");
            System.out.println("2. Print all people");
            System.out.println("0. Exit");

            String input = scanner.nextLine();
            if (input.equals("0")){
                break;
            }
            if (input.equals("1")){
                System.out.println("Select a matching strategy: ALL, ANY, NONE");
                String command = scanner.nextLine().toUpperCase(Locale.ROOT);
                switch (command) {
                    case "ALL":
                        SearchEngine allSearch = new AllWordSearch(scanner, entries, invertedIndex);
                        allSearch.search();
                        break;
                    case "ANY":
                        SearchEngine anySearch = new AnyWordSearch(scanner, entries, invertedIndex);
                        anySearch.search();
                        break;
                    case "NONE":
                        SearchEngine noneSearch = new NoneWordSearch(scanner, entries, invertedIndex);
                        noneSearch.search();
                        break;
                    default:
                        System.out.println("Invalid strategy");
                }
            }

            if (input.equals("2")){
                System.out.println("=== List of people ===");
                for (String entry : entries){
                    System.out.println(entry + "\n");
                };
            }
        }
    }

}
