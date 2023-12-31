import java.io.File;

public class LoadGameCommand implements Command {
    private final Game game;



    public LoadGameCommand(Game game) {
           this.game = game;
    }

    @Override
    public void execute() {
        game.load(new File("save"));
    }

}
