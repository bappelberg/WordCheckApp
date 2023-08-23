package src;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class WordCheckGame {
    private final WordDictionary wordDictionary;
    private final UI ui;

    public WordCheckGame(WordDictionary wordDictionary, UI ui) {
        this.wordDictionary = wordDictionary;
        this.ui = ui;
    }

    public void play() {
        ui.display("--------------------------------------------------------------- Write the english word. Quit the program by pressing Q ---------------------------------------------------------------");

        int fullWordPoints = 0;
        int currentWordCounter = 0;
        WordSpellchecker spellchecker = new WordSpellchecker();
        Set<Map.Entry<String, List<String>>> wordEntries = wordDictionary.getWords().entrySet();
        Iterator<Map.Entry<String, List<String>>> dictionaryIterator = wordEntries.iterator();

        while (dictionaryIterator.hasNext()) {
            currentWordCounter++;
            Map.Entry<String, List<String>> entry = dictionaryIterator.next();

            ui.display(entry.getKey().toString());
            String inputAnswer = ui.getInput();

            if (inputAnswer.equals(ConsoleUI.QUIT_COMMAND)) {
                printResults(currentWordCounter - 1, fullWordPoints, wordDictionary.getSize());
                System.exit(0);
            }

            String resultMessage = getResultMessage(spellchecker.spellcheck(inputAnswer, entry.getValue()));
            fullWordPoints += resultMessage.equals("Correct!") ? 1 : 0;

            ui.display(resultMessage + " " + fullWordPoints + "/" + currentWordCounter);
        }

        printResults(currentWordCounter - 1, fullWordPoints, wordDictionary.getSize());
    }



    private String getResultMessage(float result) {
        if (result == 1) {
            return "Correct!";
        } else if (result > 0.5) {
            return "Almost!";
        } else {
            return "Incorrect!";
        }
    }

    private void printResults(int currentWordCounter, int fullWordPoints, int totalWords) {
        ui.display("You answered a total of " +
                currentWordCounter + " words and had " + fullWordPoints + " right. Kind regards!");
    }
}