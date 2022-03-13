package aut.cs.balance;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculationPackTest {

    @Test
    public void constructorTest(){
        CalculationPack cp = new CalculationPack(15);
        assertEquals(15,cp.getVolume());
    }
}
