# search-engine-hyperskill
Command line application for searching text files with listed personal data, like names or emails. Made as part of the Java Backend Developer track for JetBrains Academy. 
See more here https://hyperskill.org/projects/66  

Run with arguments:
```
  --data <pathToFile>
```

Three different search strategies are provided:
- Any: returns lines where any of the query terms are present
- All: returns lines where all of the query terms are present
- None: returns lines where none of the query terms are present

All strategies use an inverted index for efficient searching. 
