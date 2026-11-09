import methods.Methods;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static tags.Tags.SMOKE;

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
    @RepeatedTest(10)
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





    @RepeatedTest(10)
    @DisplayName("Test IsEven()")
    @Tag(SMOKE)
    void testIsEven(){
        System.out.println("Method IsEven()");
        Random random = new Random();
        int  n = random.nextInt(1, 100);
        //System.out.println("Random value = " + n + ", is Even = " + Methods.isEven(n));
        boolean isEven = Methods.isEven(n);
        boolean exResult = n % 2 == 0;


        System.out.println("Method testAssertAge()");
        System.out.println("Initial data: " + n);
        System.out.println("Expected result: " + exResult);
        System.out.println("Actual result: " + isEven);



        Assertions.assertThat(Methods.isEven(n))
                .as("Methods.isEven(%d) сломался", n)
                .isEqualTo(n % 2 == 0);

    }


    //Methods.checkAccess(19));
    @ParameterizedTest
    @CsvSource({
            "26, Allowed",
            "25, Allowed",
            "24, Allowed",
            "23, Allowed",
            "22, Allowed",
            "21, Allowed",
            "20, Allowed",
            "19, Allowed",
            "18, Allowed",  //Неверное значение, там > будет фейлить
            "17, Denied"
    })
    @DisplayName("Test CheckAccess()")
    @Tag(SMOKE)
    void testCheckAccess(int age, String expected){
        System.out.println("Method CheckAccess()");
        String actual = Methods.checkAccess(age);


        Assertions.assertThat(actual)
                .as("Methods.CheckAccess(%d) сломался", age)
                .isEqualTo(expected);
    }

    //Methods.isPositive(-1));
    @ParameterizedTest
    @ValueSource(ints = {1, -2, 3, 0, 2, 5, -9, 12, -33, 46})
    @DisplayName("Test IsPositive()")
    @Tag(SMOKE)
    void testIsPositive(int n){
        System.out.println("Method IsPositive()");
        boolean value = Methods.isPositive(n);

        boolean positive = n >= 0;

        Assertions.assertThat(value)
                .as("Methods.IsPositive(%d) сломался", n)
                .isEqualTo(positive);
    }

    //Methods.getGrade(20));
    @ParameterizedTest
    @CsvSource({
            "0, E",
            "20, E",
            "21, D",
            "22, D",
            "40, D",
            "41, C",
            "42, C",
            "60, C",
            "61, B",
            "81, A",
    })
    @DisplayName("Test getGrade()")
    @Tag(SMOKE)
    void testGetGrade(int score, String grade){
        System.out.println("Method getGrade()");
        String getGrade = Methods.getGrade(score);


        Assertions.assertThat(getGrade)
                .as("Methods.getGrade(%d) сломался", score)
                .isEqualTo(grade);
    }


    //Methods.blastOff(-3));
    @ParameterizedTest
    @CsvSource({
            "1, '1 Поехали!'",
            "2, '2 1 Поехали!'",
            "3, '3 2 1 Поехали!'",
            "4, '4 3 2 1 Поехали!'",
            "5, '5 4 3 2 1 Поехали!'",
            "6, '6 5 4 3 2 1 Поехали!'",
            "7, '7 6 5 4 3 2 1 Поехали!'",
            "8, '8 7 6 5 4 3 2 1 Поехали!'",
            "9, '9 8 7 6 5 4 3 2 1 Поехали!'",
            "10, '10 9 8 7 6 5 4 3 2 1 Поехали!'"
    })
    @DisplayName("Test blastOff()")
    @Tag(SMOKE)
    void testBlastOff(int stage, String text){
        System.out.println("Method blastOff()");
        String getText = Methods.blastOff(stage);

        Assertions.assertThat(getText)
                .as("Methods.blastOff(%d) сломался", stage)
                .isEqualTo(text);
    }

    //Methods.sumToN(1));
    @RepeatedTest(10)
    @DisplayName("Test sumToN()")
    @Tag(SMOKE)
    void testSumToN(RepetitionInfo repetitionInfo){
        System.out.println("Method sumToN()");
        System.out.println("Running repeated test -> " + repetitionInfo.getCurrentRepetition());
        Random random = new Random();
        int randomNum = random.nextInt(1, 100);

        int sumTest = 0;
        for (int i = 0; i <= randomNum; i++) {
            sumTest = sumTest + i;
        }

        Assertions.assertThat(Methods.sumToN(randomNum))
                .as("Methods.sumToN(%d) сломался", randomNum)
                .isEqualTo(sumTest);
    }


    //Methods.hasBug(bugList));
    @RepeatedTest(10)
    @DisplayName("Test hasBug()")
    @Tag(SMOKE)
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

        Assertions.assertThat(Methods.hasBug(RandomList))
                .as("Methods.sumToN(%d) сломался",  Arrays.toString(RandomList))
                .isEqualTo(FindBug);
    }

    //Methods.getEvenInRange(11, 22));
    @ParameterizedTest
    @CsvSource({
            "1,  5,  '2 4'",
            "1,  2,  '2'",
            "4,  4,  '4'",
            "-4, 2,  '-4 -2 0 2'",
            "1,  6,  '2 4 6'",
            "6,  6,  '6'",
            "7,  10,  '8 10'",
            "-3,  1,  '-2 0'",
            "0,  2,  '0 2'",
            "1,  1,  ''"
    })
    @DisplayName("Test GetEvenInRange()")
    @Tag(SMOKE)
    void testGetEvenInRange(int rangeS, int rangeF, String value){
        System.out.println("Method GetEvenInRange()");

        String evenInRange = Methods.getEvenInRange(rangeS, rangeF);
        System.out.println("Data in Methods: " + evenInRange + " Expected " + value);

        Assertions.assertThat(evenInRange)
                .as("Methods.GetEvenInRange(%d) сломался",  evenInRange)
                .isEqualTo(value);

        //String status = (evenInRange.equals(value)) ? "TEST PASSED" : "TEST FAILED";
        //System.out.println(status);
    }


    //Methods.findMax(arrList));
    @RepeatedTest(10)
    @DisplayName("Test FindMax()")
    @Tag(SMOKE)
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


        Assertions.assertThat(MethodMax)
                .as("Methods.FindMax(%d) сломался",  MethodMax)
                .isEqualTo(expected);
    }


    //Methods.reverse(bugList);
    @RepeatedTest(10)
    @DisplayName("Test Reverse()")
    @Tag(SMOKE)
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

        Assertions.assertThat(reversedMethods)
                .as("Method Reverse() сломался")
                .isEqualTo(reversedTest);
    }


    //Methods.calcAverage(arrAvg));
    @RepeatedTest(10)
    @DisplayName("Test CalcAverage()")
    @Tag(SMOKE)
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

        Assertions.assertThat(avgMethods)
                .isEqualTo(avgTest);
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
    @Tag(SMOKE)
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



        Assertions.assertThat(MethodsNames)
                .as("he list contains the name to be deleted")
                .doesNotContain(deleteName);
    }
}

