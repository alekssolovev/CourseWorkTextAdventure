import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game =new Game();
        Menu menu = new Menu();
        game.executeMenuCommand("start");
        menu.displayMenu();
        menu.selectMenu();



        //игра сохраняется и загружается,доработать класс Main и Game




    }
}