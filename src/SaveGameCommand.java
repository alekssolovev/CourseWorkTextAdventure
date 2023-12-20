public class SaveGameCommand implements Command{
    private final Game game;

    String fileName;

    public SaveGameCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.save("Save1");
    }



}
