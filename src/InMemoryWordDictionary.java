package src;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class InMemoryWordDictionary implements WordDictionary {
    private final Map<String, List<String>> dictionary;

    public InMemoryWordDictionary() {
        this.dictionary = initializeDictionary();
    }

    private Map<String, List<String>> initializeDictionary() {
        Map<String, List<String>> dictionary = new LinkedHashMap<>();
        dictionary.put("bil", List.of("car"));
        dictionary.put("hus", List.of("house"));
        dictionary.put("springa", List.of("run"));
        dictionary.put("blå", List.of("blue"));
        dictionary.put("baka", List.of("bake"));
        dictionary.put("hoppa", List.of("jump"));
        dictionary.put("simma", List.of("swim"));
        dictionary.put("måne", List.of("moon"));
        dictionary.put("väg", List.of("road"));
        dictionary.put("snäll", List.of("kind", "sweet"));
        return dictionary;
    }

    @Override
    public Map<String, List<String>> getWords() {
        return dictionary;
    }

    @Override
    public int getSize() {
        return dictionary.size();
    }
}