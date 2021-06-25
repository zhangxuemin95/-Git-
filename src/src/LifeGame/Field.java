package LifeGame;

public class Field implements FieldInterface {
	private Cell[][] cells;//细胞集合
    private int height;//界面高度
    private int width;//界面宽度
    public Field(int width, int height) {
        this.height = height;
        this.width = width;
        cells = new Cell[width][height];
    }

    @Override
    public boolean place(int x, int y, Cell cell) {//初始化细胞
        if(x < 0 || x >= width) return false;
        if(y < 0 || y >= height) return false;
        cells[x][y] = cell;
        return true;
    }

    @Override
    public Cell getCell(int x, int y) {//得到某个位置的细胞
        //超过边界
        if(x < 0 || x >= width) return null;
        if(y < 0 || y >= height) return null;
        return cells[x][y];
    }

    @Override
    public Cell[] getNeighbors(int x, int y) {//得到所有邻居
        Cell[] neighbors = new Cell[8];
        int index = 0;
        for(int i = x - 1; i <= x + 1; i++) {
            for(int j = y - 1; j <= y + 1; j++) {
                if(i != x || j != y) {//不是本身
                    neighbors[index++] = getCell(i, j);
                }
            }
        }
        return neighbors;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void clear() {
        for(int i = 0; i < height; i++)
            for(int j = 0; j < width; j++) {
                cells[i][j] = null;
            }
    }
}
