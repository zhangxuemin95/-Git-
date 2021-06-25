package LifeGame;

public interface FieldInterface {
    boolean place(int x, int y, Cell cell);

    Cell getCell(int x, int y);

    Cell[] getNeighbors(int x, int y);

    public int getHeight();

    public int getWidth();
}
