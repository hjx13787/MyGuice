package com.test.date;

import java.util.Date;
import java.util.TimerTask;

import com.ibm.icu.text.SimpleDateFormat;

public class TestTimerTask extends TimerTask {
    private int i;
    
    public TestTimerTask(int i){
	this.i=i;
    }
    @Override
    public void run() {
	Date date=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	System.out.println(i+"====="+sdf.format(date));
	i++;

    }

}
