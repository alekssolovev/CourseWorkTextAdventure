public class ResumeGameCommand implements Command{
    private final Game game;

    GameState gameState;

    public ResumeGameCommand(Game game) {
      this.game=game;
    }

    @Override
    public void execute() {

        game.returnToGame(gameState);
        //game.save();
        // возврат к квесту,состояние в переменной
        //переменная для сохранения состояние объекта
    }
}
