public class StartGameCommand implements Command {
    private final Game game;

    public StartGameCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.start();
    }

    @Override
    public void undo() {
        game.stop();
    }
}