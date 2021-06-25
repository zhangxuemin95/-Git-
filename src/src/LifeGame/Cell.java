package LifeGame;

public class Cell {
	private boolean alive = false;//ÉúÃü×´Ì¬

	public Cell() {

	    }
	    public void reborn() { //¸³ÓèÉúÃü
	        alive = true;
	    }

	    public void die() { //ËÀÍö
	        alive = false;
	    }

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public boolean isAlive() { //ÅĞ¶ÏÊÇ·ñ´æ»î
	        return alive;
	    }
}
