import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NextChapter { //Класс для хранения соответствий
    //между ответами и главами.

    Map<String, Chapters> map1 = new HashMap<>();
    Map<String,Chapters> map2 = new HashMap<>();

    Menu menu;


    public NextChapter(Map<String, Chapters> map1, Map<String, Chapters> map2) {
        this.map1 = map1;
        this.map2 = map2;
    }

    public Chapters nextChapterAfterAnswer1(String answer){
        map1.put(Chapters.FIRST.getAnswer1(),Chapters.SECOND);
        map1.put(Chapters.SECOND.getAnswer2(),null);
        map1.put(Chapters.THIRD.getAnswer1(),Chapters.FOURTH);
        map1.put(Chapters.FOURTH.getAnswer1(),Chapters.SIXTH);
        map1.put(Chapters.FIFTH.getAnswer1(),null);
        map1.put(Chapters.SIXTH.getAnswer1(),Chapters.EIGHTH);
        map1.put(Chapters.SEVENTH.getAnswer1(),Chapters.SECOND);
        map1.put(Chapters.EIGHTH.getAnswer1(),Chapters.FIFTH);
        map1.put(Chapters.NINE.getAnswer1(), Chapters.TENTH);
        map1.put(Chapters.TENTH.getAnswer1(),Chapters.TWELFTH);
        map1.put(Chapters.ELEVENTH.getAnswer1(),null);
        map1.put(Chapters.TWELFTH.getAnswer1(),null);
        map1.put(Chapters.THIRTEENTH.getAnswer1(),Chapters.FIFTH);

        Chapters nextChapter = map1.get(answer);
        return  nextChapter;
    }

    public  Chapters nextChapterAfterAnswer2(String answer){
        map2.put(Chapters.FIRST.getAnswer2(),Chapters.THIRD );
        map2.put(Chapters.SECOND.getAnswer2(),null);
        map2.put(Chapters.THIRD.getAnswer2(),Chapters.FIFTH);
        map2.put(Chapters.FOURTH.getAnswer2(),Chapters.SEVENTH);
        map2.put(Chapters.FIFTH.getAnswer2(),null);
        map2.put(Chapters.SIXTH.getAnswer2(),Chapters.FIFTH);
        map2.put(Chapters.SEVENTH.getAnswer2(),Chapters.FIFTH);
        map2.put(Chapters.EIGHTH.getAnswer2(),Chapters.NINE);
        map2.put(Chapters.NINE.getAnswer2(),Chapters.ELEVENTH);
        map2.put(Chapters.TENTH.getAnswer2(),Chapters.THIRTEENTH);
        map2.put(Chapters.ELEVENTH.getAnswer2(),null);
        map2.put(Chapters.TWELFTH.getAnswer2(),null);
        map2.put(Chapters.THIRTEENTH.getAnswer2(),Chapters.SECOND);

        Chapters nextChapter = map2.get(answer);
        return nextChapter;
    }

    public Chapters switchAnswer(String answer1,String answer2,int userInput){
        //выбор нужной главы
        if (userInput == 1) {
            return nextChapterAfterAnswer1(answer1);
        } else if (userInput == 2){
            return   nextChapterAfterAnswer2(answer2);}

        else return Chapters.FIRST;

    }

    }




