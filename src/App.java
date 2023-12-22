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
        System.out.println(gameState.getChapter().toString());

        game.executeMenuCommand("start");
        System.out.println(gameState.getChapter());
        while (true){
            int choice = scanner.nextInt();
        if(choice ==1 || choice ==2)
        {
            chapters =nextChapter.switchAnswer(gameState.getChapter().getAnswer1(),gameState.getChapter().getAnswer2(),choice);
            gameState = new GameState(chapters);
            game = new Game(gameState);
            System.out.println(gameState.getChapter());
            if(chapters.getAnswer1()==null)
                {game.endOfGame(gameState);}
        }
        if(choice==3){
            gameState = new GameState(Chapters.ELEVENTH);
            game = new Game(gameState);
            System.out.println(gameState.getChapter());
            menu.displayMenu();
            System.out.println(gameState.getChapter());
            menu.selectMenu(gameState,fileName);}

        }

        //Добавить переход в программе между главами.






        }
    }

