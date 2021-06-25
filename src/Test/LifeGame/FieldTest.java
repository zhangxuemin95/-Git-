package LifeGame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FieldTest {
    private final Field fieldTest = new Field(20, 20);

    @Before
    public void setUp() {
        fieldTest.clear();
    }
    @Test
    /*
    mark是place()方法的返回值,
     */

    public void place() {
        boolean mark;
        mark = fieldTest.place(-1, -1, new Cell());
        assertEquals(false, mark);
        mark = fieldTest.place(20, 20, new Cell());
        assertEquals(false, mark);
        mark = fieldTest.place(0, 0, new Cell());
        assertEquals(true, mark);
        mark = fieldTest.place(19, 19, new Cell());
        /*
        白盒测试:
        代码覆盖标准 : 判定条件覆盖
        测试用例 : (x, y): (-1, 5), (7, 29), (7, 8), (29, -1)
         测试覆盖率: 100%
         */
        assertEquals(true, mark);
        mark = fieldTest.place(-1, 5, new Cell());
        assertEquals(false, mark);
        mark = fieldTest.place(7, 29, new Cell());
        assertEquals(false, mark);
        mark = fieldTest.place(7, 8, new Cell());
        assertEquals(true, mark);
        mark = fieldTest.place(29, -1, new Cell());
        assertEquals(false, mark);
    }

    @Test
    public void getCell() {
        /*
        黑盒测试: 边界条件测试
        测试用例: (x, y): (-1, -1), (20, 20), (0, 0), (19, 19), (10, 10)
         */
        assertEquals(null, fieldTest.getCell(10, 10));
        Cell theCell1 = new Cell();
        fieldTest.place(10, 10, theCell1);
        fieldTest.place(0, 0, theCell1);
        fieldTest.place(19, 19, theCell1);
        assertEquals(theCell1, fieldTest.getCell(10,10));
        assertEquals(null, fieldTest.getCell(-1, -1));
        assertEquals(null, fieldTest.getCell(20, 20));
        assertEquals(theCell1, fieldTest.getCell(0, 0));
        assertEquals(theCell1, fieldTest.getCell(19, 19));
        /*
        白盒测试
        代码覆盖标准: 判定条件覆盖
        测试用例: (x, y): (-1, 10), (10, -1), (10, 10), (20, 20)
        代码覆盖率: 100%
         */
        assertEquals(null, fieldTest.getCell(-1, 10));
        assertEquals(null, fieldTest.getCell(10, -1));
        assertEquals(theCell1, fieldTest.getCell(10, 10));
        assertEquals(null, fieldTest.getCell(20, 20));
    }

    @Test
    public void getNeighbors() {
        fieldTest.place(0,0,new Cell());
        fieldTest.place(0,1,new Cell());
        fieldTest.place(1, 0, new Cell());
        fieldTest.place(1, 1, new Cell());
        Cell[] cells1 = fieldTest.getNeighbors(0,0);
        int numExist = 0;
        int numNull = 0;
        for(Cell o : cells1) {
            if(o == null) numNull++;
            else numExist++;
        }
        assertEquals(3, numExist);
        assertEquals(5, numNull);
        fieldTest.place(19,19,new Cell());
        fieldTest.place(18,19,new Cell());
        fieldTest.place(19, 18, new Cell());
        fieldTest.place(18, 18, new Cell());
        Cell[] cells2 = fieldTest.getNeighbors(19,19);
        numExist = 0;
        numNull = 0;
        for(Cell o : cells2) {
            if(o == null) numNull++;
            else numExist++;
        }
        assertEquals(3, numExist);
        assertEquals(5, numNull);
        fieldTest.place(5,5,new Cell());
        fieldTest.place(4,4,new Cell());
        fieldTest.place(6, 6, new Cell());
        Cell[] cells3 = fieldTest.getNeighbors(5,5);
        numExist = 0;
        numNull = 0;
        for(Cell o : cells3) {
            if(o == null) numNull++;
            else numExist++;
        }
        assertEquals(2, numExist);
        assertEquals(6, numNull);
        fieldTest.place(4,5,new Cell());
        fieldTest.place(4,6,new Cell());
        fieldTest.place(5, 4, new Cell());
        fieldTest.place(5,6,new Cell());
        fieldTest.place(6,4,new Cell());
        fieldTest.place(6, 5, new Cell());
        Cell[] cells4 = fieldTest.getNeighbors(5,5);
        numExist = 0;
        numNull = 0;
        for(Cell o : cells4) {
            if(o == null) numNull++;
            else numExist++;
        }
        assertEquals(8, numExist);
        assertEquals(0, numNull);
    }

    @Test
    public void getHeight() {
        assertEquals(20, fieldTest.getHeight());
    }

    @Test
    public void getWidth() {
        assertEquals(20, fieldTest.getWidth());
    }
}