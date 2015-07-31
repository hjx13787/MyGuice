package com.test.runnable;

import java.util.Timer;
import java.util.TimerTask;

public class TRun implements Runnable{

    public void run() {
	System.out.println("线程开始");
	Timer t=new Timer();
	t.schedule(new TimerTask() {
	    
	    @Override
	    public void run() {
		System.out.println("线程运行");
		
	    }
	}, 1000, 1000);
	
    }
    public static void main(String[] args) {
	new TRun().run();
    }
}
