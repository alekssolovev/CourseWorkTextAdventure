import java.io.*;

public class Game {
    private final MenuInvoker menuInvoker;
    private GameState gameState;
    private Game game;

    File fileName = new File("save");
    Menu menu = new Menu(game);



    public Game(GameState gameState) {
        menuInvoker = new MenuInvoker();
        setupMenu();
        this.gameState=gameState;
    }


    private void setupMenu() {
        Command startCommand = new StartGameCommand(this);
        Command loadCommand = new LoadGameCommand(this);
        Command exitCommand = new ExitGameCommand(this);
        Command resumeCommand = new ResumeGameCommand(this);
        Command saveCommand = new SaveGameCommand(this);


        menuInvoker.setCommand("start", startCommand);
        menuInvoker.setCommand("load", loadCommand);
        menuInvoker.setCommand("exit",exitCommand);
        menuInvoker.setCommand("resume",resumeCommand);
        menuInvoker.setCommand("save",saveCommand);

    }

    public void start() {
            System.out.println("Game started"); //старт игры
            System.out.println(Chapters.FIRST.getChapterTitle() + "\n" + Chapters.FIRST.getChapterText());
            System.out.println("1. "+ Chapters.FIRST.getAnswer1()+"\n"+ "2. " +  Chapters.FIRST.getAnswer2() + "\n" +
                    "3.Выйти в меню" + "\n" + "Ваш выбор?");
            gameState = new GameState(Chapters.FIRST);
    }

    public void stop() {
        System.exit(0);
    } //выход

    public  GameState load(File fileName) {
        try {
            FileInputStream fileIn = new FileInputStream(this.fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.gameState = (GameState) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Игра загружена из файла: " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке игры: " + e.getMessage());
        }
        return gameState;

    }// загрузка


    public  void save(GameState gameState, File fileName) {
        try {

            FileOutputStream fileOut = new FileOutputStream(this.fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(gameState);
            out.close();
            fileOut.close();
            System.out.println("Игра сохранена в файл: " + this.fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении игры: " + e.getMessage());
        }
    }

    public void returnToGame(GameState gameState){
        if(gameState!=null) {
            game = new Game(gameState);
            System.out.println(gameState.getChapter().getChapterTitle() + "\n" +  gameState.getChapter().getChapterText());
            if(gameState.getChapter().getAnswer1()==null||gameState.getChapter().getAnswer2()==null)
                game.endOfGame(gameState);
            System.out.println("1 " + gameState.getChapter().getAnswer1() + "\n" + "2 "+  gameState.getChapter().getAnswer2() + "\n");
            System.out.println("3 Выйти в меню");}
    }


    public void endOfGame(GameState gameState){
        if(gameState.getChapter().isGameOver())
            System.out.println("Вы прогирали!");
        if(gameState.getChapter().isVictory())
            System.out.println("Вы выиграли!");
        System.exit(0);
    }




    public void executeMenuCommand(String commandName) {
        menuInvoker.executeCommand(commandName);
    }



}