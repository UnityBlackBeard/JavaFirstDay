
import java.security.SecureRandom;
import java.util.*;
import java.sql.SQLOutput;


public class Main {

    static String wordE = "javalove";
    static String wordM = "polymorphism";
    static String wordH = "talkischeapshowmethecode";
    static String word="";






    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        //разделим уровни сложности
        System.out.println("Выберите уровнь сложности ");
        System.out.println("Введите 1 для легкого уровня,2 для среднего, 3 для сложного");

            int level=input.nextInt();
        int variant;
        switch  (level) {
            case 1:  variant=1;
               word= getrandomvalue(1);
                 //word=wordE;

            break;
            case 2:variant=2;
                word= getrandomvalue(2);
                    //word=wordM;
            break;
            case 3:variant=3;
                word= getrandomvalue(3);
                   // word=wordH;
            break;
            default:
                System.out.println("Введенное значение невозможно обработать.Автоматический выбор легкого уровня");
                variant=1;
                break;


        }

        // javalove --------
        //Hellowordl ----------
        System.out.println("Угадай слово");
        int lengthWord = word.length();

        String maskWord = "-".repeat(lengthWord);
        System.out.println(maskWord);

        // --------
        // a
        // -a-a----
        // o
        // -a-a-o--
        do {
            System.out.println("Введите букву");
            char c = input.next().charAt(0);
            // a 2
            // w -1
            if (word.indexOf(c) >= 0) {
                System.out.println("Удача");
                for (char elem : word.toCharArray()) {
                    if (elem == c) {
                        maskWord = replaceMaskLetter(c, maskWord);
                    }
                }
                System.out.println(maskWord);
            } else {
                System.out.println("Промах, поробуй еще раз");
                System.out.println(maskWord);
            }
        } while (maskWord.contains("-"));
        System.out.println("Поздравляем ты выйграл");
    }

    /*
    -a-a---- j
    ja-a----
     */
    public static String replaceMaskLetter(char c, String maskWord) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c) {
                stringBuilder.append(c);
            } else if (maskWord.charAt(i) != '-') {
                stringBuilder.append(maskWord.charAt(i));
            } else {
                stringBuilder.append("-");
            }
        }
        return stringBuilder.toString();
    }

    public static String getrandomvalue(int variant){

        //создадим по три варианта для каждого уровня
        //используем arraylist
        //ArrayList<String> easywords= new ArrayList<String>();
        //easywords.add(1,"javalove");
        //easywords.add(2,"helloworld");
        //easywords.add(3,"idea");
        String[] easywords= {"javalove","helloworld","idea"};




        ArrayList<String> mediumwords= new ArrayList<String>();
        mediumwords.add("runtime");
        mediumwords.add("exception");
        mediumwords.add("compilation");

        ArrayList<String> hardwords= new ArrayList<String>();
        mediumwords.add("polymorphism");
        mediumwords.add("abstraction");
        mediumwords.add("encapsulation");

        Random rand = new SecureRandom();
        String randomElement="";

        if ( variant==1) {
            randomElement= easywords[rand.nextInt(easywords.length)];

            //int numberOfElements = 3;
            //for (int i = 0; i<numberOfElements; i++) {
            //    int randomIndex = rand.nextInt(easywords.size());
            //     randomElement = easywords.get(randomIndex);
            //    //easywords.remove(randomIndex);
            //}
        }
        else if (variant==2){

            int numberOfElements = 3;
            for (int i = 1; i<numberOfElements; i++) {
                int randomIndex = rand.nextInt(mediumwords.size());
                 randomElement = mediumwords.get(randomIndex);


            }

            }
        else if (variant==3){

                int numberOfElements = 3;
                for (int i = 1; i<numberOfElements; i++) {
                    int randomIndex = rand.nextInt(hardwords.size());
                    randomElement = hardwords.get(randomIndex);


            }

        }
        else{
            randomElement="talkischeapshowmethecode";


        }
        return randomElement;




    }
}
