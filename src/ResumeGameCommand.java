public class ResumeGameCommand implements Command{
    private final Game game;

    public ResumeGameCommand(Game game) {
      this.game=game;
    }

    @Override
    public void execute() {
        game.returnToGame();
        //game.save();
        // возврат к квесту,состояние в переменной
        //переменная для сохранения состояние объекта
    }
}
