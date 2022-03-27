package ru.geekbrains.uiTest;

import lesson4.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    void givenTrueResultWhenEquilateralTriangle(){
    Triangle triangle = new Triangle(5,5,5);
    Assertions.assertEquals(10.825317547305483,triangle.squareTriangle());
    }

    @Test
    void givenTrueResultWhenIsoscelesTriangle(){
        Triangle triangle = new Triangle(5,5,2);
        Assertions.assertEquals(4.898979485566356,triangle.squareTriangle());
    }
    @Test
    void givenTrueResultWhenVersatileTriangle(){
        Triangle triangle = new Triangle(3,4,2);
        Assertions.assertEquals( 2.9047375096555625,triangle.squareTriangle());
    }
    @Test
    void givenTrueResultWhenNoExistTriangle(){
        Triangle triangle = new Triangle(1,4,2);
        Assertions.assertEquals( 0,triangle.squareTriangle());
    }

}
