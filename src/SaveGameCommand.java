public class SaveGameCommand implements Command{
    private final Game game;

    public SaveGameCommand(Game game) {
        this.game = game;
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
