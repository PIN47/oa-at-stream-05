import java.util.Arrays;
import java.util.List;

public class Methods {
    //Задание 1
    public static boolean isEven(int n){
        return n % 2 == 0;
    }



    // Задание 2
    public static String checkAccess(int age){
        if (age>18){
            return "Allowed";
        }else{
            return "Denied";
        }
    }

    // задание 3
    public static boolean isPositive(int n){
        return (n>=0) ? true : false;
    }

    // Задание 4
    public static String getGrade(int score){
        if ((score >=0) && (score <21)){
            return "E";
        }else if ((score >=21) && (score <41)){
            return "D";
        }else if ((score >=41) && (score <61)){
            return "C";
        }else if ((score >=61) && (score <81)){
            return "B";
        }else if ((score >=81) && (score <=100)){
            return "A";
        }
        return "Out of range";
    }

    // Задание 5
    public static String blastOff(int start) {
        String str = "";
        if (start > 0) { // Если > 0
            for (int i = start; i > 0; i--) {
                str = str + i + " ";
            }
        } else if (start < 0) { // Если < 0
            for (int i = start; i < 0; i++) {
                str = str + i + " ";
            }
        };
        return str + "Поехали!";
    }

    // Задание 6
    public static int sumToN(int n){
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = sum + i;

        }
        return sum;
    }

    // Задание 7 Можно подумать над lowerCase
    public static boolean hasBug(String[] messages){
        for (String msg : messages){
            if (msg == "Bug"){
                return true;
            }
        }
        return false;
    }

    // Задание 8
    public static String getEvenInRange(int start, int end){
        String str = "";
        for (int i = start; i < end; i++) {
            if (i % 2 == 0){
                if (str == ""){  // Что бы небыло пробела лишнего
                    str = i + "";
                }else{
                    str = str + " " + i;
                }

            }
        }
        return str;
    }

    // Задание 9
    public static int findMax(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length-1];
    }

    // Задание 10
    public static String[] reverse(String[] arr){
        String[] arrReverse = new String[arr.length];
        int rCalc = arr.length-1;
        for (int i = 0; i < arr.length; i++) {
            arrReverse[rCalc] = arr[i];
            rCalc--;
        }
        return arrReverse;
    }

    // Задание 11
    public static int calcAverage(List<Integer> list){
        int sum = 0;
        for (int n: list){
            sum = sum + n;
        }
        return sum / list.size();
    }

    // Задание 12
    public static List<String> removeSpecificName(List<String> list, String nameToRemove){
        list.remove(nameToRemove);
        return list;
    }
}
