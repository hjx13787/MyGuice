package sys.my.pro.ui.splash;

import sys.my.pro.ui.manage.BasicJavaBeanModel;

public class SplashModel extends BasicJavaBeanModel {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        pcs.firePropertyChange("message", this.message, this.message = message);
    }
    
    
}
