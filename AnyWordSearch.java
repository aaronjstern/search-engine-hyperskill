package search;

import java.util.*;

public class AnyWordSearch extends SearchEngine {
    public AnyWordSearch(Scanner scanner, List<String> entries, Map<String, List<Integer>> index) {
        super(scanner, entries, index);
    }

    @Override
    public void search() {
        System.out.println("Enter a name or email to search all suitable people.");
        String[] query = scanner.nextLine().split(" ");
        Set<Integer> validLineSet = new HashSet<>();

        for (String word : query){
            String token = word.toLowerCase(Locale.ROOT);
            for (String term : index.keySet()) {
                if (token.equals(term)) {
                    validLineSet.addAll(index.get(token));
                }
            }
        }

        int numValidLines = validLineSet.size();
        String personTerm = numValidLines == 1 ? "person" : "people";
        System.out.println(numValidLines + " " + personTerm + " found:");
        for (int i : validLineSet) {
            String validLine = entries.get(i);
            System.out.println(validLine + "\n");
        }

    }
}
