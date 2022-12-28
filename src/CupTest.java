import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CupTest {

    @Test
    void getLiquidType() {
        Cup c = new Cup("Orange Juice", 85.5);
        assertEquals("Orange Juice", c.getLiquidType());
    }

    @Test
    void getPercentageFull() {
        Cup c = new Cup("Orange Juice", 85.5);
        assertEquals(85.5, c.getPercentFull(), 0.001);
    }

    @Test
    void setLiquidType() {
        Cup c = new Cup("Orange Juice", 85.5);
        c.setLiquidType("Water");
        assertEquals("Water", c.getLiquidType());
    }

    @Test
    void testObjectCreation(){
        Cup cup = new Cup ("Water", 75.0);
        assertEquals("Water", cup.getLiquidType());
        assertEquals(75, cup.getPercentFull(), 0.001);
    }

    @Test
    void testIsEmpty(){
        Cup cup = new Cup ("Water", 75.0);
        assertFalse(cup.isEmpty());
    }

    @Test
    void testSetLiquidWithNull(){
        Cup cup = new Cup("Water", 75.0);
        cup.setLiquidType(null);
        assertNotNull(cup.getLiquidType());
    }
    @Disabled("Disable test until Library team fixes bug 2532")
    @Test
    void testTestExternalLibrary(){
        //Imagine depending n someone eles's code...
        //...
        fail();
    }

    @Test
    void testSetBadPercentThrows(){
        Cup cup = new Cup("Water", 75.0);
        assertThrows(IllegalArgumentException.class,
                () -> cup.setPercentFull(-1)
                );
    }
    @Test
    void testObjectCreationWithAssertAll() {
        Cup cup = new Cup("Water", 75.0);
        assertAll("Correctly build object",
                () -> assertEquals("Water", cup.getLiquidType()),
                () -> assertEquals(75, cup.getPercentFull(), 0.001)
        );
    }

    public double guessThePercent(Cup cup) {
        while (true) {
            double guess = Math.random();
            if (Math.abs(guess - cup.getPercentFull()) < 100){
                return guess;
            }
        }
    }
    @Test
    void guessThePercent(){
        Cup cup = new Cup ("Water", 50);
        assertTimeoutPreemptively(
                Duration.ofSeconds(5),
                () -> guessThePercent(cup) > 0);
    }
}