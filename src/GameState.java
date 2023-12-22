import java.io.Serializable;

public class GameState implements Serializable { //класс для сохранения состояния игры
    private Chapters chapters;


    public GameState( Chapters chapters) {
        if(chapters!=null)
            this.chapters = chapters;
    }

    public Chapters getChapter() {
        return chapters;
    }


    public void setChapter(Chapters chapters) {
       this.chapters = chapters;
    }


}
