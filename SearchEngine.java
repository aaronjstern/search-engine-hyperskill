package search;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class SearchEngine {

    Scanner scanner;
    List<String> entries;
    Map<String, List<Integer>> index;

        public SearchEngine(Scanner scanner, List<String> entries, Map<String, List<Integer>> index){
            this.scanner = scanner;
            this.entries = entries;
            this.index = index;

        }

        public abstract void search();
}


