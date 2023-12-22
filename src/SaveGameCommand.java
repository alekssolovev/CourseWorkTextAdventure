import java.io.File;

public class SaveGameCommand implements Command{
    private final Game game;
    private GameState gameState;

    File fileName;

    public SaveGameCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.save(gameState,fileName);
    }



}
