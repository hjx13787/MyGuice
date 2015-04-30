package sys.my.pro.ui.guice;

import com.google.inject.ImplementedBy;

@ImplementedBy(GuiceImpl.class)
public interface GuiceI {
    public void sayHello();
}
