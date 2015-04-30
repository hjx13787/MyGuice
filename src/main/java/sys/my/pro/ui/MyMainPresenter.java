package sys.my.pro.ui;

import sys.my.pro.ui.i.Presenter;

public class MyMainPresenter implements Presenter{
    private MyMainView view;

    public MyMainPresenter(MyMainView view) {
	super();
	this.view = view;
    }

    public void close() {
	this.view.close();
    }
    public void show(){
	this.view.open();
    }

}
