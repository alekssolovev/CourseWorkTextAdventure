public class ExitGameCommand implements Command{
    private final Game game;

    public ExitGameCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.stop();
    }

}
