public class ResumeGameCommand implements Command{
    private final Game game;

    public ResumeGameCommand(Game game) {
      this.game=game;
    }

    @Override
    public void execute() {
        game.save();
    }

    @Override
    public void undo() {
        game.returnToMenu();
    }
}
