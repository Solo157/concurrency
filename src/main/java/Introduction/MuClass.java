package Introduction;

public class MuClass {


    public static void main(String[] args) {
        LoggingWidget widget = new LoggingWidget();
        widget.doSomething();
    }
}


class Widget {
    public synchronized void doSomething() {
        System.out.println("Widget");
        System.out.println(this);
    }
}

class LoggingWidget extends Widget {
    public synchronized void doSomething() {
        System.out.println(toString() + ": calling doSomething");
        super.doSomething();
        System.out.println(this);
    }
}