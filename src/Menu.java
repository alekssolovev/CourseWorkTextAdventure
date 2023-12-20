import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    GameState gameState;
    Game game;

    public void displayMenu() {
        System.out.println("Меню:");
        System.out.println("1. Начать игру");
        System.out.println("2. Вернуться к игре");
        System.out.println("3. Выйти из игры");
        System.out.println("4. Сохранить игру");
        System.out.println("5. Загрузить игру");
        System.out.println("Выберите пункт меню:");
    }

    public void selectMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice==1)
            game.executeMenuCommand("start");
        else if(choice==2)
            game.executeMenuCommand("resume");
        else if (choice==3)
            game.executeMenuCommand("exit");
        else if (choice==4) {
            game.executeMenuCommand("save");
            displayMenu();}
        else if (choice==5)
            game.executeMenuCommand("load");
        else
            System.out.println("Неверный выбор");

    }

    public Chapters nextChapter(String answer) {  //переход к следующей главе
        List<Chapters> chaptersList = new ArrayList<>();

        chaptersList.addAll(Arrays.asList(Chapters.values()));
        for (Chapters chapter : chaptersList) {
            String title = chapter.getChapterTitle();
            if (answer.contains(title)) {
                return Chapters.valueOf(title);
            } else {
                System.out.println("Строка не содержит предложение после символов ->");
            }
        }
        return gameState.getChapter();
    }


    public String selectAnswer(String answer1,String answer2){
        System.out.println("Сделайте свой выбор");
        String answer = null;
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                answer = answer1;
                break;
            case 2:
                answer = answer2;
                break;
            default:
                System.out.println("Неверный выбор");
        break;}

        return answer;
    }

    //Дописать класс shortMenu с отображением 2 пунктов меню и выйти из игры

 }

