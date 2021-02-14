package javabrains;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("When running MathUtils")
//The idea is to form a sentence
class MathUtillsTest {
    MathUtills mathUtills=new MathUtills();
    @BeforeEach
    void init(){
      mathUtills=new MathUtills();
    }

    @Test
    @DisplayName("When adding two positive numbers ")
    void add() {
        int expected=4;
        int actual=mathUtills.add(2,2);
        assertEquals(expected,actual,"The add method should add two numbers");
    }
    @Test
    @DisplayName("When subtracting two positive numbers ")
    void subtract() {
        int expected=2;
        int actual=mathUtills.subtract(4,2);
        assertEquals(expected,actual,"The subtract method should subtract two numbers");
    }
    //
//    @Test
//    We can repeat a test and also pass arguments void....(RepetitionInfo rep)
//    if.....get...
//    https://www.youtube.com/watch?v=tTbBXf9Uh0s&list=PLqq-6Pq4lTTa4ad5JISViSb2FVG8Vwa4o&index=26&ab_channel=JavaBrains
    @RepeatedTest(4)
    @DisplayName("When multiplying two positive numbers ")
    void multiply() {
        int expected=8;
        int actual=mathUtills.multiply(4,2);
        assertEquals(expected,actual,"The multiply method should multiply two numbers");
    }

    @Test
    @Tag("Math")
//    you can configure The tags using intellji or the surefire plugin you add configuration
//    Then Junit will only run the Tag test only
    @DisplayName("Multiply methods")
    void multiplyAssertAll(){
        assertAll(
                ()->     assertEquals(4,mathUtills.multiply(2,2)),
                ()-> assertEquals(0,mathUtills.multiply(2,0)),
                ()->  assertEquals(-2,mathUtills.multiply(2,-1))
        );
    }
    @Test
    @Tag("Math")
    @DisplayName("divide methods that throws exception")
    void testdivideThrowException(){
        assertThrows(ArithmeticException.class,()->mathUtills.divide(1,0)," Throw exception");
    }

    @Test
    void testComputeCircleRaduis(){
        assertEquals(Math.PI*10*10,mathUtills.computeCircleArea(10), "should return ");
    }
    @Test
    @DisplayName("Inside the first class negative")
    void testNegative2(){
        int expected=-2;
        int actual=mathUtills.add(-1,-1);
        assertEquals(expected, actual,()->"should return sum "+expected+ " but returned "+actual);
    }

    @Nested
    class Addtest{

        @Test
        @DisplayName("Inside the first class positive")
        void testPositive(){
            assertEquals(2,mathUtills.add(1,1));
        }
        @Test
        @DisplayName("Inside the first class negative")
        void testNegative(){
            assertEquals(-2,mathUtills.add(-1,-1));
        }

        @Nested
        class AnotherTest{
            @Test
            @DisplayName("Inside the second class positive")
            void testPositive(){
                assertEquals(2,mathUtills.add(1,1));
            }
            @Test
            @DisplayName("Inside the second class negative")
            void testNegative(){
                assertEquals(-2,mathUtills.add(-1,-1));
            }
        }
    }
}