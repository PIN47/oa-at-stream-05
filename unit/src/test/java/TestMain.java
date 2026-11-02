import methods.Methods;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

class TestMain {

    @BeforeAll  // Пишем перед запуском всех тестов
    static void init() {System.out.println("Start tests!");}

    @BeforeEach // Пишем перед запуском каждого тестов
    void setup() {
        System.out.println("====================");
        System.out.println("Test method start");
    }

    @AfterEach // Пишем после каждого теста
    void cleanup() {
        System.out.println("Test method end");
        System.out.println("====================");
        System.out.println(); // Пробел между итерациями
    }

    @AfterAll   // Пишем после прохода всех тестов
    static void close() {System.out.println("End tests!");}



    // Запустить метод один раз со случайным числом от 1 до 100
    @Test
    @DisplayName("Test IsEven()")
    void testIsEven(){
        System.out.println("Method IsEven()");
        Random random = new Random();
        int  n = random.nextInt(1, 100);
        System.out.println("Random value = " + n + ", is Even = " + Methods.isEven(n));
    }

    // Запустить метод 20 раз со случайными числами от 0 до 99
    @RepeatedTest(20)
    @DisplayName("Test CheckAccess()")
    void testCheckAccess(){
        System.out.println("Method CheckAccess()");
        Random random = new Random();
        int  n = random.nextInt(0, 99);

        System.out.println("Age " + n + " Access " + Methods.checkAccess(n));

    }


    // Генерация массива для теста ниже
    static int[] scoreArray() {
        int length = 10;
        int[] nums = new int[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            nums[i] = random.nextInt(100);
        }
        return nums;
    }

    // Запустить метод в параметризованных тестах с массивом случайных чисел от 0 до 100
    @ParameterizedTest
    @MethodSource("scoreArray")
    @DisplayName("Test GetGrade()")
    void testGetGrade(int param){
        System.out.println("Method GetGrade()");
        System.out.println("Score " + param + ", grade " + Methods.getGrade(param));
    }
}

class AllTests{
    @BeforeAll  // Пишем перед запуском всех тестов
    static void init() {System.out.println("Start All tests!");}

    @BeforeEach // Пишем перед запуском каждого тестов
    void setup() {
        System.out.println("====================");
        System.out.println("Test method start");
    }

    @AfterEach // Пишем после каждого теста
    void cleanup() {
        System.out.println("Test method end");
        System.out.println("====================");
        System.out.println(); // Пробел между итерациями
    }

    @AfterAll   // Пишем после прохода всех тестов
    static void close() {System.out.println("End tests!");}





    @Test
    @DisplayName("Test IsEven()")
    void testIsEven(){
        System.out.println("Method IsEven()");
        Random random = new Random();
        int  n = random.nextInt(1, 100);
        //System.out.println("Random value = " + n + ", is Even = " + Methods.isEven(n));

        String status = (Methods.isEven(n)) == (n % 2 == 0) ? "TEST PASS" : "TEST FAILED";
        System.out.println(status);

    }


    //Methods.checkAccess(19));
    @ParameterizedTest
    @CsvSource({
            "19, Allowed",
            "18, Allowed",  //Неверное значение, там > будет фейлить
            "17, Denied"
    })
    @DisplayName("Test CheckAccess()")
    void testCheckAccess(int age, String expected){
        System.out.println("Method CheckAccess()");
        String actual = Methods.checkAccess(age);

        String status = actual.equals(expected) ? "TEST PASSED" : "TEST FAILED";
        System.out.println(status);
    }

    //Methods.isPositive(-1));
    @ParameterizedTest
    @ValueSource(ints = {1, -2, 3, 0})
    @DisplayName("Test IsPositive()")
    void testIsPositive(int n){
        System.out.println("Method IsPositive()");
        boolean value = Methods.isPositive(n);

        boolean positive = n >= 0;

        String status = (value == positive) ? "TEST PASSED" : "TEST FAILED";
        System.out.println(status);
    }

    //Methods.getGrade(20));
    @ParameterizedTest
    @CsvSource({
            "20, E",
            "47, C",
            "68, B"
    })
    @DisplayName("Test getGrade()")
    void testGetGrade(int score, String grade){
        System.out.println("Method getGrade()");
        String getGrade = Methods.getGrade(score);

        String status = getGrade.equals(grade) ? "TEST PASSED" : "TEST FAILED";
        System.out.println(status);
    }


    //Methods.blastOff(-3));
    @ParameterizedTest
    @CsvSource({
            "3, '3 2 1 Поехали!'",
            "1, '1 Поехали!'",
            "2, '2 1 Поехали!'"
    })
    @DisplayName("Test blastOff()")
    void testBlastOff(int stage, String text){
        System.out.println("Method blastOff()");
        String getText = Methods.blastOff(stage);



        String status = getText.equals(text) ? "TEST PASSED" : "TEST FAILED";
        System.out.println(status);
    }

    //Methods.sumToN(1));
    @RepeatedTest(3)
    @DisplayName("Test sumToN()")
    void testSumToN(RepetitionInfo repetitionInfo){
        System.out.println("Method sumToN()");
        System.out.println("Running repeated test -> " + repetitionInfo.getCurrentRepetition());
        Random random = new Random();
        int randomNum = random.nextInt(1, 100);

        int sumTest = 0;
        for (int i = 0; i <= randomNum; i++) {
            sumTest = sumTest + i;
        }

        String status = (Methods.sumToN(randomNum) == sumTest) ? "TEST PASSED" : "TEST FAILED";
        System.out.println(status);

    }


    //Methods.hasBug(bugList));
    @Test
    @DisplayName("Test hasBug()")
    void testHasBug(){
        System.out.println("Method hasBug()");
        String[] bugList = {"Lol","Bug","Bam", "Bom", "Dam", "Zam"};
        String[] RandomList = new String[3];
        Random random = new Random();

        // Рандомим массив
        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(bugList.length);
            RandomList[i] = bugList[randomIndex];
        }

        boolean FindBug = false;
        for (String msg : RandomList){
            if (msg.equals("Bug")) {
                FindBug = true;
                break;
            }
        }

        System.out.println("Random array: " + Arrays.toString(RandomList));
        System.out.println("Bug find?: " + FindBug);

        String status = (Methods.hasBug(RandomList) == FindBug) ? "TEST PASSED" : "TEST FAILED";
        System.out.println(status);



    }

    //Methods.getEvenInRange(11, 22));
    @ParameterizedTest
    @CsvSource({
            "1,  5,  '2 4'",
            "1,  2,  '2'",         // Бага получается
            "4,  4,  '4'",
            "-4, 2,  '-4 -2 0 2'", // Бага получается
            "2,  6,  '2 4 6'"      // Бага получается
    })
    @DisplayName("Test GetEvenInRange()")
    void testGetEvenInRange(int rangeS, int rangeF, String value){
        System.out.println("Method GetEvenInRange()");

        String evenInRange = Methods.getEvenInRange(rangeS, rangeF);
        System.out.println("Data in Methods: " + evenInRange + " Expected " + value);

        String status = (evenInRange.equals(value)) ? "TEST PASSED" : "TEST FAILED";
        System.out.println(status);
    }


    //Methods.findMax(arrList));
    @RepeatedTest(10)
    @DisplayName("Test FindMax()")
    void testFindMax(RepetitionInfo repetitionInfo){
        System.out.println("Method FindMax()");
        System.out.println("Running repeated test -> " + repetitionInfo.getCurrentRepetition());
        int length = 10;
        int[] nums = new int[length];
        Random random = new Random();

        System.out.println("Array:");

        for (int i = 0; i < length; i++) {
            nums[i] = random.nextInt(-10, 24);
            System.out.print(nums[i] + " ");
        }

        int expected = Arrays.stream(nums).max().getAsInt();

        System.out.println("Max:" + expected);

        int MethodMax = Methods.findMax(nums);
        System.out.println("Method max:" + MethodMax);


        String status = (MethodMax == expected) ? "TEST PASSED" : "TEST FAILED";
        System.out.println(status);


    }


    //Methods.reverse(bugList);
    @Test
    @DisplayName("Test Reverse()")
    void testReverse(){
        System.out.println("Method Reverse()");
        String[] numList = {"one","two","three", "four", "five", "six", "seven"};
        String[] RandomList = new String[5];
        Random random = new Random();

        // Рандомим массив
        for (int i = 0; i < RandomList.length; i++) {
            int randomIndex = random.nextInt(numList.length);
            RandomList[i] = numList[randomIndex];
        }

        // Получаем из метода развернутый массив
        String[] reversedMethods;
        reversedMethods = Methods.reverse(RandomList);

        // Генерируем тестовый массив
        String[] reversedTest = new String[RandomList.length];
        for (int i = 0; i < reversedTest.length; i++) {
            reversedTest[i] = RandomList[reversedTest.length - 1 - i];
        }

        String status = (Arrays.equals(reversedMethods, reversedTest)) ? "TEST PASSED" : "TEST FAILED";
        System.out.println(status);
    }


    //Methods.calcAverage(arrAvg));
    @Test
    @DisplayName("Test CalcAverage()")
    void testCalcAverage(){
        System.out.println("Method CalcAverage()");
        // Создаем и заполняем список на среднее значение рандомными значениями
        List<Integer> arrAvg = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            arrAvg.add(random.nextInt(-10, 24));
        }


        int avgMethods = Methods.calcAverage(arrAvg);
        // Считаем среднюю
        int avgTest = 0;
        for (int n: arrAvg){
            avgTest = avgTest + n;
        }
        avgTest = avgTest / arrAvg.size();

        String status = (avgMethods == avgTest) ? "TEST PASSED" : "TEST FAILED";
        System.out.println(status);
    }

    // Генерируем рандомные уникальные значения для теста ниже
    static List<String> getRandomName(){
        List<String> list = new ArrayList<>(List.of("Peter", "Andree", "Vasua", "Valera", "Zina", "Galya"));

        Collections.shuffle(list);
        return new ArrayList<>(list.subList(0, 3));
    }


    //Methods.removeSpecificName(arrNames, "Petr"));
    @RepeatedTest(10)
    @DisplayName("Test removeSpecificName()")
    void testRemoveSpecName(RepetitionInfo repetitionInfo){
        System.out.println("Method removeSpecificName()");
        System.out.println("Running repeated test -> " + repetitionInfo.getCurrentRepetition());
        List<String> randomNameList;

        randomNameList = getRandomName();

        // Выбираем имя
        Random random = new Random();
        String deleteName = randomNameList.get(random.nextInt(randomNameList.size()));

        System.out.println("To " + randomNameList + " .Delete name: " + deleteName);

        List<String> MethodsNames;
        MethodsNames = Methods.removeSpecificName(randomNameList, deleteName);

        System.out.println("After " + randomNameList + " .Delete name: " + deleteName);




        String status = (MethodsNames.contains(deleteName)) ? "TEST FAILED" : "TEST PASSED";
        System.out.println(status);
    }
}

