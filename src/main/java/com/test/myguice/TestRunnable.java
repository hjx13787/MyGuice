package com.test.myguice;

import java.util.Timer;

import com.test.date.TestTimerTask;

public class TestRunnable implements Runnable {
    private LoginModol lm;
    public TestRunnable(LoginModol lm){
	this.lm=lm;
    }
    public void run() {
	Timer timer=new Timer();
	timer.schedule(new TestTimerTask(lm), 0, 1000);

    }

}
