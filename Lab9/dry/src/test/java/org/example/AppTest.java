package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private App newApp;

    @BeforeEach
    public void setup() {
        newApp = new App();
    }

    @Test
    public void testAddBasic() {
        assertEquals(newApp.add(2, 5), 7);
        assertEquals(newApp.add(0, 0), 0);
        assertEquals(newApp.add(2, -5), -3);
    }

    @Test
    public void testCommutativeness() {
        assertEquals(newApp.add(2, 5), newApp.add(5, 2));
    }

    @Test
    public void testArrayContent() {
        String[] appArr = newApp.getArr();
        String[] testArr = {"apple", "banana", "coconut", "jordan"};
        assertNotNull(appArr);
        assertEquals(4, appArr.length);
        for(int i=0; i<appArr.length; i++) {
            assertEquals(appArr[i], testArr[i]);
        }
    }

    @Test
    public void testMain() {
        // test 1:
        try{
            newApp.main(new String[] {});
            assertTrue(true);
        } catch (Exception e) {
            fail(e);
        }
        // test 2:
        try{
            newApp.main(new String[] {"Leon"});
            assertTrue(true);
        } catch (Exception e) {
            fail(e);
        }
        // test 3:
        try{
            newApp.main(new String[] {"Avishai", "Oz", "is", "cool"});
            assertTrue(true);
        } catch (Exception e) {
            fail(e);
        }
    }
}
