package LifeGame;

public class Clock {
	 private static long theTick;//页面更新的间隔
	 private Boolean OK = false; //判断游戏是否可以开始
	    public Clock(long tick) {
	        theTick = tick;
	    }

	    public void pause() throws InterruptedException {//系统的暂停时间
	        Thread.sleep(theTick);
	    }
	    
	    public Boolean getOK() {
			return OK;
		}
	    
	    public void setOK() {
			OK = !(OK.booleanValue());
		}
}
