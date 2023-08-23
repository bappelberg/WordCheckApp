package src;

import java.util.List;

class WordSpellchecker {
    public float spellcheck(String word, List<String> correctWords) {
        float bestResult = 0;

        for (String correctAnswer : correctWords) {
            float result = spellcheckWord(word, correctAnswer);
            if (result > bestResult) {
                bestResult = result;
            }
        }
        return bestResult;
    }

    private float spellcheckWord(String word, String correctWord) {
        if (correctWord == null || word == null) {
            return 0;
        }
        word = word.toLowerCase();
        correctWord = correctWord.toLowerCase();
        int shortestWordLength = Math.min(word.length(), correctWord.length());
        int longestWordLength = Math.max(word.length(), correctWord.length());
        float matchingChars = 0;

        for (int i = 0; i < shortestWordLength; i++) {
            if (word.charAt(i) == correctWord.charAt(i)) {
                matchingChars++;
            }
        }
        return matchingChars / longestWordLength;
    }
}