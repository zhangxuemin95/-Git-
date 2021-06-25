package LifeGame;

public class MockField implements FieldInterface{
    Cell o1 = new Cell();//死细胞
    Cell o2 = new Cell();//活细胞
    Cell[] cells1 = {o1, o1, o1, o1, o2, o2, o2, o1};
    Cell[] cells2 = {o1, o1, o1, o1, o2, o2, o2, o2};
    @Override
    public boolean place(int x, int y, Cell cell) {
        return false;
    }

    @Override
    public Cell getCell(int x, int y) {
        return null;
    }

    @Override
    public Cell[] getNeighbors(int x, int y) {
        o1.die();
        o2.reborn();
        if(x == y) return cells1;
        else return cells2;
    }

    @Override
    public int getHeight() {
        return 3;
    }

    @Override
    public int getWidth() {
        return 3;
    }
}
