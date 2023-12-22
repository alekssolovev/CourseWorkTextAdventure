import java.io.*;

public class Game {
    private final MenuInvoker menuInvoker;
    public   GameState gameState;
    Game game;

    //Menu menu;



    public Game(GameState gameState) {
        menuInvoker = new MenuInvoker();
        setupMenu();
        this.gameState=gameState;
    }
    File fileName = new File("save");
    Menu menu = new Menu(game);






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
            System.out.println("1. "+ Chapters.FIRST.getAnswer1()+"\n"+ "2. " +  Chapters.FIRST.getAnswer2() + "\n" +
                    "3.Выйти в меню" + "\n" + "Ваш выбор?");
            gameState = new GameState(Chapters.FIRST);
            String answer1 = Chapters.FIRST.getAnswer1();
            String answer2 = Chapters.FIRST.getAnswer2();
            //Chapters chapters =gameState.getChapter();
    }

    public  void stop() {
        //System.out.println("Игра завершена.");
        System.exit(0);
    } //выход

    public  GameState load(File fileName) {
        try {

            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            gameState = (GameState) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Игра загружена из файла: " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке игры: " + e.getMessage());
        }
        //System.out.println(gameState.getChapter());
        return gameState;

    }// загрузка


    public  void save(GameState gameState, File fileName) {
        try {

            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(gameState);
            out.close();
            fileOut.close();
            System.out.println("Игра сохранена в файл: " + fileName);
            //System.out.println(gameState.getChapter());
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении игры: " + e.getMessage());
        }
    }

    public void returnToGame(GameState gameState){
        System.out.println(gameState.getChapter());
        System.out.println(gameState.getChapter().getChapterTitle() + "\n" + gameState.getChapter().getChapterText());
        System.out.println(gameState.getChapter().getAnswer1() + "\n" + gameState.getChapter().getAnswer2() + "\n");
        System.out.println("3 Выйти в меню");
    }


    public void endOfGame(GameState gameState){
        game = new Game(this.gameState);
        if(gameState.getChapter().isGameOver())
            System.out.println("Вы прогирали!");
        if(gameState.getChapter().isVictory())
            System.out.println("Вы выиграли!");
        game.stop();
    }




    public void executeMenuCommand(String commandName) {
        menuInvoker.executeCommand(commandName);
    }



}