package src;

import java.util.List;
import java.util.Map;

interface WordDictionary {
    Map<String, List<String>> getWords();
    int getSize();
}