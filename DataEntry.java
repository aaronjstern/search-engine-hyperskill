package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DataEntry {

    File file;

    public DataEntry(String filePath ){
        this.file = new File(filePath);
    }

    public List<String> collectEntries() {

        List<String> entries = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)){

            while (scanner.hasNext()){
                entries.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error " + e);
        }

        return entries;
    }
    public Map<String, List<Integer>> createIndex() throws FileNotFoundException {

        Map<String, List <Integer>> invertedIndex = new HashMap<>();

        int lineCount = 0;
        try (Scanner scanner = new Scanner(file)){

            while (scanner.hasNext()){
                List<String> lineEntries = List.of(scanner.nextLine().split(" "));
                for (String entry : lineEntries){
                    String token = entry.toLowerCase(Locale.ROOT);
                    invertedIndex.putIfAbsent(token, new ArrayList<>());
                    invertedIndex.get(token).add(lineCount);
                }
                lineCount++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error " + e);
        }

        return invertedIndex;
    }
}
