import methods.Methods;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;

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
    static void close() {System.out.println("Stop tests!");}



    // Запустить метод один раз со случайным числом от 1 до 100
    @Test
    void testIsEven(){
        System.out.println("Method IsEven()");
        Random random = new Random();
        int  n = random.nextInt(1, 100);
        System.out.println("Random value = " + n + ", is Even = " + Methods.isEven(n));
    }

    // Запустить метод 20 раз со случайными числами от 0 до 99
    @RepeatedTest(20)
    void testCheckAccess(){
        System.out.println("Method CheckAccess()");
        Random random = new Random();
        int  n = random.nextInt(0, 99);

        System.out.println("Age " + n + " Access " + Methods.checkAccess(n));

    }


    // Генерация массива для теста ниже
    static int[] scoreArray() {
        int length = 100;
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
    void testGetGrade(int param){
        System.out.println("Method GetGrade()");
        System.out.println("Score " + param + ", grade " + Methods.getGrade(param));
    }


}
