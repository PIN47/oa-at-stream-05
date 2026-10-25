import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {



    public static void main(String[] args){
        String[] bugList = {"Lol","Bug","Bam"};

        // Создаем и заполняем список на среднее значение
        int[] arrList = {1,3,67,4,-1};
        List<Integer> arrAvg = new ArrayList<>();
        arrAvg.add(1);
        arrAvg.add(6);
        arrAvg.add(-1);
        arrAvg.add(2);

        // Массив на удаления имени
        List<String> arrNames = new ArrayList<>();
        arrNames.add("Valera");
        arrNames.add("Ivan");
        arrNames.add("Petr");

        // Массив на реверсивный вывод
        String[] arrR = new String[bugList.length-1];


        System.out.println("Задание 1: " + Methods.isEven(2));
        System.out.println("Задание 2: " + Methods.checkAccess(19));
        System.out.println("Задание 3: " + Methods.isPositive(-1));
        System.out.println("Задание 4: " + Methods.getGrade(20));
        System.out.println("Задание 5: " + Methods.blastOff(-3));
        System.out.println("Задание 6: " + Methods.sumToN(1));
        System.out.println("Задание 7: " + Methods.hasBug(bugList));
        System.out.println("Задание 8: " + Methods.getEvenInRange(11, 22));
        System.out.println("Задание 9: " + Methods.findMax(arrList));

        System.out.println("Задание 10: ");
        arrR = Methods.reverse(bugList);
        for (String str : arrR) {
            System.out.print(" " + str);
        };
        System.out.println("");


        System.out.println("Задание 11: " + Methods.calcAverage(arrAvg));
        System.out.println("Задание 12: " + Methods.removeSpecificName(arrNames, "Petr"));




    }

}
