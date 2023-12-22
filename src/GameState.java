import java.io.Serializable;

public class GameState implements Serializable {
    Game game;
    private Chapters chapters;


    public GameState( Chapters chapters) {
       // this.game = game;
        this.chapters = chapters;
    }

    public Chapters getChapter() {
        return chapters;
    }


    public void setChapter(Chapters chapters) {
        this.chapters = chapters;
    }


}
