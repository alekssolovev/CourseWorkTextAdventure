
import java.io.File;
import java.util.Scanner;



public class Menu {
    Game game;

    GameState gameState;

    String filePath ="C:\\Users\\Администратор\\IdeaProjects\\CourseWorkTextAdventure\\save";

    public Menu(Game game) {
        this.game = game;
    }

    public void displayMenu() {
        game = new Game(gameState);
        System.out.println("Меню:");
        System.out.println("1. Начать игру");
        System.out.println("2. Вернуться к игре");
        System.out.println("3. Выйти из игры");
        System.out.println("4. Сохранить игру");
        if(game.fileName.exists())
            System.out.println("5. Загрузить игру");
        System.out.println("Выберите пункт меню:");
    }

    public void selectMenu(GameState gameState, File filePath) {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1)
            game.executeMenuCommand("start");
        else if (choice == 2)
            //game.executeMenuCommand("resume");
            game.returnToGame(gameState);
        else if (choice == 3) {
            game.executeMenuCommand("exit");
        } else if (choice == 4) {
            //game.executeMenuCommand("save");
            game.save(gameState, filePath);
            displayMenu();
        } else if (choice == 5) {
            //game.executeMenuCommand("load");
            game.load(filePath);
            game.returnToGame(gameState);
        } else
            System.out.println("Неверный выбор");


    }

    public String displayShortMenu(GameState gameState){
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        System.out.println(gameState.getChapter().getAnswer1()+"\n"+ gameState.getChapter().getAnswer2() + "\n" +
                "3. Выйти в меню");
        String answer1 = gameState.getChapter().getAnswer1();
        String answer2 = gameState.getChapter().getAnswer2();
        return answer1;

    }

    //Дописать класс shortMenu с отображением 2 пунктов меню и выйти из игры

 }

