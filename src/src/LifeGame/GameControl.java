package LifeGame;

public class GameControl {
	private Field field;

    public Field getField() {
        return field;
    }

    public void InitField(int width, int height) {//初始化地图
        field = new Field(width, height);
        for(int row = 0; row < field.getHeight(); row++)
            for(int col = 0; col < field.getWidth(); col++) {
                field.place(row, col, new Cell());
            }
        for(int row = 0; row < field.getHeight(); row++)
            for(int col = 0; col < field.getWidth(); col++) {
                Cell cell = field.getCell(row, col);
                if(Math.random() < 0.2) {
                    cell.reborn();
                }
            }
    }

    public void updateView() {//更新地图
                for(int row = 0; row < field.getHeight(); row++)
                    for(int col = 0; col < field.getWidth(); col++) {
                        Cell cell = field.getCell(row, col);
                        Cell cells[] = field.getNeighbors(row, col);
                        int count = 0;
                        for(Cell o : cells) {
                            if(o != null && o.isAlive()) count++;
                        }
                        switch (count) {
                            case 1: {
                                cell.die();
                                break;
                            }
                            case 2: {
                                break;
                            }
                            case 3: {
                                cell.reborn();
                                break;
                            }
                            default:{
                                cell.die();
                            }
                        }
                    }
    }
}
