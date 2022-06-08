package search;

import java.util.*;

public class AllWordSearch extends SearchEngine {
    public AllWordSearch(Scanner scanner, List<String> entries, Map<String, List<Integer>> index) {
        super(scanner, entries, index);
    }

    @Override
    public void search() {
        System.out.println("Enter a name or email to search all suitable people.");
        String[] query = scanner.nextLine().split(" ");

        int numWords = query.length;
        Map<Integer, Integer> foundLineIndicesCount = new HashMap<>();

        for (String word : query) {
            String token = word.toLowerCase(Locale.ROOT);
            for (String term : index.keySet()) {
                if (token.equals(term)){
                    for (int i : index.get(term)){
                        foundLineIndicesCount.put(i, foundLineIndicesCount.getOrDefault(i, 0) + 1);
                    }
                }
            }
        }

        List<Integer> validLines = new ArrayList<>();

        for (int i : foundLineIndicesCount.keySet()) {
            if (foundLineIndicesCount.get(i) == numWords){
                validLines.add(i);
            }
        }

        int numValidLines = validLines.size();
        String personTerm = numValidLines == 1 ? "person" : "people";

        System.out.println(numValidLines + " " + personTerm + " found:");
        for (int i : validLines) {
            String validLine = entries.get(i);
            System.out.println(validLine + "\n");
        }
    }
}
