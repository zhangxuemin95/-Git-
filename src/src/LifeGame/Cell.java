package LifeGame;

public class Cell {
	private boolean alive = false;//����״̬

	public Cell() {

	    }
	    public void reborn() { //��������
	        alive = true;
	    }

	    public void die() { //����
	        alive = false;
	    }

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public boolean isAlive() { //�ж��Ƿ���
	        return alive;
	    }
}
