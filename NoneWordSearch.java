package search;

import java.util.*;

public class NoneWordSearch extends SearchEngine {
    public NoneWordSearch(Scanner scanner, List<String> entries, Map<String, List<Integer>> index) {
        super(scanner, entries, index);
    }

    @Override
    public void search() {
        System.out.println("Enter a name or email to search all suitable people.");
        String[] query = scanner.nextLine().split(" ");
        Set<Integer> NonValidLineSet = new HashSet<>();

        for (String word : query){
            String token = word.toLowerCase(Locale.ROOT);
            for (String term : index.keySet()) {
                if (token.equals(term)) {
                    NonValidLineSet.addAll(index.get(token));
                }
            }
        }

        int numValidLines = entries.size() - NonValidLineSet.size();
        String personTerm = numValidLines == 1 ? "person" : "people";
        System.out.println(numValidLines + " " + personTerm + " found:");
        for (int i = 0; i < entries.size(); i++) {
            if (!NonValidLineSet.contains(i)){
                String validLine = entries.get(i);
                System.out.println(validLine + "\n");
            }
        }
    }
}
