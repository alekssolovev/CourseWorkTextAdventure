public class ResumeGameCommand implements Command{
    private final Game game;

    private GameState gameState;

    public ResumeGameCommand(Game game) {
      this.game=game;
    }

    @Override
    public void execute() {

        game.returnToGame(gameState);
    }
}
