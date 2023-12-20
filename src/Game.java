import java.io.*;

public class Game {
    private final MenuInvoker menuInvoker;
    public   GameState game;

    GameState gameState;

    public Game() {
        menuInvoker = new MenuInvoker();
        setupMenu();
    }

    private void setupMenu() {
        Command startCommand = new StartGameCommand(this);
        Command loadCommand = new LoadGameCommand(this);
        Command exitCommand = new ExitGameCommand(this);
        Command resumeCommand = new ResumeGameCommand(this);
        Command saveCommand = new SaveGameCommand(this);
        // Добавьте другие команды для меню игры

        menuInvoker.setCommand("start", startCommand);
        menuInvoker.setCommand("load", loadCommand);
        menuInvoker.setCommand("exit",exitCommand);
        menuInvoker.setCommand("resume",resumeCommand);
        menuInvoker.setCommand("save",saveCommand);
        // Установите другие команды для меню игры
    }

    public void start() {
            System.out.println("Game started"); //старт игры
            System.out.println(Chapters.FIRST.getChapterTitle() + "\n" + Chapters.FIRST.getChapterText());
            System.out.println(Chapters.FIRST.getAnswer1()+"\n"+ Chapters.FIRST.getAnswer2());
            String answer1 = Chapters.FIRST.getAnswer1();
            String answer2 = Chapters.FIRST.getAnswer2();
            gameState = new GameState(Chapters.FIRST);
    }

    public void stop() {
        return;
    } //выход

    public GameState load(String filename) {
       //GameState game = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            game = (GameState) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return game;

    }// загрузка

    public void unload() {
        System.out.println("Game unloaded");
    }// зачем?

    public  void save(String filename){
        //GameState gameState;
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(game);
            objectOut.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Game save");
    }

    public void returnToGame(){
        System.out.println(gameState.getChapter().getChapterTitle() + "\n" + gameState.getChapter().getChapterText());
        System.out.println(gameState.getChapter().getAnswer1() + "\n" + gameState.getChapter().getAnswer2());
    }


    public void executeMenuCommand(String commandName) {
        menuInvoker.executeCommand(commandName);
    }



}