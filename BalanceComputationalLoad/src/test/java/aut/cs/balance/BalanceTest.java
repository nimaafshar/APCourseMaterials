package aut.cs.balance;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BalanceTest {

    @Test
    public void constructorTest(){
        Computer PC1 = new Computer(100);
        assertEquals(100,PC1.getTotalCapacity());
    }

    @Test
    public void functionalityTest() {
        Computer PC1 = new Computer(100);
        Computer PC2 = new Computer(100);
        Computer PC3 = new Computer(50);
        Computer PC4 = new Computer(100);
        Computer PC5 = new Computer(80);
        //connections
        PC1.connect(PC3);
        PC3.connect(PC2);
        PC4.connect(PC5);
        //giving our packages to PC1
        assertTrue(PC1.handle(new CalculationPack(70)) != -1);
        assertTrue(PC1.handle(new CalculationPack(75)) != -1);
        assertTrue(PC1.handle(new CalculationPack(20)) != -1);
        assertTrue(PC1.handle(new CalculationPack(20)) != -1);
        assertEquals(PC1.handle(new CalculationPack(75)), -1);
    }


    @Test
    public void algorithmTest(){
        Computer PC1 = new Computer(100);
        Computer PC2 = new Computer(100);
        Computer PC3 = new Computer(50);
        Computer PC4 = new Computer(100);
        Computer PC5 = new Computer(80);
        //connections
        PC1.connect(PC3);
        PC3.connect(PC2);
        PC4.connect(PC5);
        //giving our packages to PC1
        int[] volumes = new int[]{70, 75, 20, 20, 75};
        PC1.handle(new CalculationPack(70));
        assertEquals(PC1.getUsedCapacity(), 70);
        PC1.handle(new CalculationPack(75));
        assertEquals(PC2.getUsedCapacity(), 75);
        PC1.handle(new CalculationPack(20));
        assertEquals(PC3.getUsedCapacity(), 20);
        PC1.handle(new CalculationPack(20));
        assertEquals(PC3.getUsedCapacity(), 40);
    }
}