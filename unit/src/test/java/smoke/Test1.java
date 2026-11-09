package smoke;

import methods.Methods;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    @BeforeEach
        // Пишем перед запуском каждого тестов
    void setup() {
        System.out.println("====================");
        System.out.println("Test method start");
    }

    @AfterEach
        // Пишем после каждого теста
    void cleanup() {
        System.out.println("Test method end");
        System.out.println("====================");
        System.out.println(); // Пробел между итерациями
    }


    @ParameterizedTest
    @CsvSource({
            "19, true",
            "18, true",
            "17, false"
    })
    @DisplayName("Test testAssertAge")
    void testAssertAge(int age, boolean expected){

        boolean resultAge = Methods.checkAge(age);

        System.out.println("Method testAssertAge()");
        System.out.println("Initial data: " + age + " >= 18?");
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result: " + resultAge);


        Assertions.assertThat(resultAge)
                .as("Age does not align with the expected result")
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("Test removeSpecificName")
    void testAssertRemoveSpecificName(){
        // Массив на удаление имени
        List<String> arrNames = new ArrayList<>();
        List<String> arrResult;
        arrNames.add("Valera");
        arrNames.add("Ivan");
        arrNames.add("Petr");

        String nameDelete = "Ivan";  // Удаляем несуществующее имя

        arrResult = Methods.removeSpecificName(arrNames, nameDelete);

        System.out.println("Method testAssertRemoveSpecificName()");
        System.out.println("Initial data: " + arrNames);
        System.out.println("Expected result: no " + nameDelete + " in list");
        System.out.println("Actual result: " + arrResult);


        Assertions.assertThat(arrResult)
                .as("he list contains the name to be deleted")
                .doesNotContain("Ivan");  // Найдем Ивана
    }


    //Methods.getEvenInRange(11, 22));
    @ParameterizedTest
    @CsvSource({
            "1,  5,  '2 4'",
            "1,  2,  '2'",         // Бага получается
            "4,  4,  '4'",         // Бага получается
            "-4, 2,  '-4 -2 0 2'", // Бага получается
            "2,  6,  '2 4 6'"      // Бага получается
    })
    @DisplayName("Test GetEvenInRange")
    void testAssertGetEvenInRange(int rangeS, int rangeF, String value){

        String evenInRange = Methods.getEvenInRange(rangeS, rangeF);

        System.out.println("Method GetEvenInRange()");
        System.out.println("Initial data: range to " + rangeS + ", do " + rangeF);
        System.out.println("Expected result: " + value);
        System.out.println("Actual result: " + evenInRange);


        Assertions.assertThat(evenInRange)
                .as("Expected result <> Actual result")
                .isEqualTo(value);
    }

    @ParameterizedTest
    @CsvSource({
            "'Searching for a substring within a string',  'substring', true",
            "'Searching for a substring within a string',  'subString', true",
            "'Searching for a substring within a string',  'arbuz', false",
    })
    @DisplayName("Test findSubInString")
    void testAssertSubInString(String myText, String findSub, boolean exResult){

        boolean actResult = Methods.findSubInString(myText, findSub);

        System.out.println("Method findSubInString()");
        System.out.println("Initial data: text: " + myText + ", find sub: " + findSub);
        System.out.println("Expected result: " + exResult);
        System.out.println("Actual result: " + actResult);

        Assertions.assertThat(actResult)
                .as("Search is broken")
                .isEqualTo(exResult);


    }

}
