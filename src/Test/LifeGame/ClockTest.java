package LifeGame;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class ClockTest {
    private static Clock clockTest = new Clock(1000);
    @Test
    public void pause() throws InterruptedException {
        /*
        白盒测试
        代码覆盖标准: 语句覆盖
        代码覆盖率: 100%
         */
        long time1 = new Date().getTime();
        clockTest.pause();
        long time2 = new Date().getTime();
        boolean flag = (time2 - time1) < 1015 ? true : false;
        assertEquals(true, flag);
    }

    @Test
    public void setOK() {
        assertEquals(false, clockTest.getOK().booleanValue());
        clockTest.setOK();
        assertEquals(true, clockTest.getOK().booleanValue());
        clockTest.setOK();
        assertEquals(false, clockTest.getOK());
    }
}