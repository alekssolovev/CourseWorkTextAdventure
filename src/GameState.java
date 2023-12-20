import java.io.Serializable;

public class GameState implements Serializable {
    public Chapters chapter ;
    Game game;

    public GameState(Chapters chapter) {
        if(chapter!=null)
            this.chapter = chapter;
    }

    public Chapters getChapter() {
        return chapter;
    }

    public void endOfGame(GameState gameState){
        if(gameState.getChapter().isGameOver())
            System.out.println("Вы прогирали!");
            game.stop();
        if(gameState.getChapter().isVictory())
            System.out.println("Вы выиграли!");
            game.stop();
    }
}
