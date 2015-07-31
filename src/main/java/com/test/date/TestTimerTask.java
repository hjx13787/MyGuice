package com.test.date;

import java.util.Date;
import java.util.TimerTask;

import com.ibm.icu.text.SimpleDateFormat;
import com.test.myguice.LoginModol;

public class TestTimerTask extends TimerTask {
    private LoginModol lm;
    public TestTimerTask(LoginModol lm){
	this.lm=lm;
    }
    @Override
    public void run() {
	Date date=new Date();
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	lm.setTime(sdf.format(date));

    }

}
