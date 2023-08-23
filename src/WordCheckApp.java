package src;

public class WordCheckApp {
    public static void main(String[] args) {
        WordCheckGame game = new WordCheckGame(new InMemoryWordDictionary(), new ConsoleUI());
        game.play();
    }
}
