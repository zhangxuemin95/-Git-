package LifeGame;

public class Clock {
	 private static long theTick;//ҳ����µļ��
	 private Boolean OK = false; //�ж���Ϸ�Ƿ���Կ�ʼ
	    public Clock(long tick) {
	        theTick = tick;
	    }

	    public void pause() throws InterruptedException {//ϵͳ����ͣʱ��
	        Thread.sleep(theTick);
	    }
	    
	    public Boolean getOK() {
			return OK;
		}
	    
	    public void setOK() {
			OK = !(OK.booleanValue());
		}
}
