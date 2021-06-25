package LifeGame;

import org.junit.Before;

import static org.junit.Assert.*;

public class CellTest {
    private static Cell cellTest = new Cell();

    @Before
    public void setUp() {
        cellTest.setAlive(false);
    }
    @org.junit.Test
    public void reborn() {
        cellTest.reborn();
        assertEquals(true, cellTest.isAlive());
    }

    @org.junit.Test
    public void die() {
        cellTest.reborn();
        cellTest.die();
        assertEquals(false, cellTest.isAlive());
    }

    @org.junit.Test
    public void isAlive() {
        assertEquals(false, cellTest.isAlive());
        cellTest.reborn();
        assertEquals(true, cellTest.isAlive());
        cellTest.die();
        assertEquals(false, cellTest.isAlive());
    }
}