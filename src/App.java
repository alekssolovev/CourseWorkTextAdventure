import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {


    public static void main(String[] args) {
        Map<String, Chapters> map1 = new HashMap<>();
        Map<String,Chapters> map2 = new HashMap<>();
        Chapters chapters =Chapters.FIRST;
        GameState gameState = new GameState(chapters);
        Game game = new Game(gameState);
        Menu menu = new Menu(game);
        File fileName = new File("save");
        NextChapter nextChapter = new NextChapter(map1,map2);
        Scanner scanner = new Scanner(System.in);

        game.executeMenuCommand("start");
        while (true){
            int choice = scanner.nextInt();
            if(choice ==1 || choice ==2)
            {
                //определяем следующую главу
                chapters =nextChapter.switchAnswer(gameState.getChapter().getAnswer1(),gameState.getChapter().getAnswer2(),choice);
                //обновляем прогресс игры через Gamestate
                gameState = new GameState(chapters);
                game.returnToGame(gameState);
                if(chapters.getAnswer1()==null)
                    game.endOfGame(gameState);
        }
            if(choice==3){
                menu.displayMenu();
                if(gameState!=null)
                    menu.selectMenu(gameState,fileName);
                //определяем следующую главу
                nextChapter.switchAnswer(gameState.getChapter().getAnswer1(),gameState.getChapter().getAnswer2(),choice);}
            else
                System.out.println("Неверный ввод");

        }

        }
}

