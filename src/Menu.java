
import java.io.File;
import java.util.Scanner;



public class Menu {
    private Game game;

    private GameState gameState;

    public Menu(Game game) {
        if(game!=null)
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
            game.returnToGame(gameState);
        else if (choice == 3) {
            game.executeMenuCommand("exit");
        } else if (choice == 4) {
            game.save(gameState, filePath);
            displayMenu();
        } else if (choice == 5) {
            gameState = game.load(filePath);
            game.returnToGame(gameState);
        } else
            System.out.println("Неверный выбор");


    }



 }

