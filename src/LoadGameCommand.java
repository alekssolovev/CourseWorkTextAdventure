public class LoadGameCommand implements Command {
    private final Game game;

    private String fileName;

    public LoadGameCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.load("Save1");
    }

}
