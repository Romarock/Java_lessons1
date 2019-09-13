package ru.stqa.pft.sandbox;

import org.testng.annotations.Test;

public class SquareTests {

    @Test
    public void testArea() {


        Square s;
        s = new Square(5);

        assert  s.area() == 25;

    }
}
