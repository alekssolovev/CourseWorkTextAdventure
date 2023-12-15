public class Game {
    private final MenuInvoker menuInvoker;

    public Game() {
        menuInvoker = new MenuInvoker();
        setupMenu();
    }

    private void setupMenu() {
        Command startCommand = new StartGameCommand(this);
        Command loadCommand = new LoadGameCommand(this);
        // Добавьте другие команды для меню игры

        menuInvoker.setCommand("start", startCommand);
        menuInvoker.setCommand("load", loadCommand);
        // Установите другие команды для меню игры
    }

    public void start() {
        System.out.println("Game started"); //старт игры
    }

    public void stop() {
        System.out.println("Game stopped");
    } //выход

    public void load() {
        System.out.println("Game loaded");
    }// загрузка

    public void unload() {
        System.out.println("Game unloaded");
    }// зачем?

    public void save(){
        System.out.println("Game save");
    }

    public void returnToMenu(){
        System.out.println("Return to menu");
    }


    public void executeMenuCommand(String commandName) {
        menuInvoker.executeCommand(commandName);
    }

    public void undoMenuCommand(String commandName) {
        menuInvoker.undoCommand(commandName);
    }
}