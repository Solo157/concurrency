package Introduction;

import jdk.jfr.Event;

import javax.xml.transform.Source;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.EventListener;

public class SafeListener {

    private EventListener eventListener;

    private SafeListener() {
        eventListener = new EventListener() {
            public void onEvent(Event e) {
                //doSomething(e);
            }
        };
    }

    public static SafeListener newInstance() {
        SafeListener safe = new SafeListener();
        return safe;
    }

    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
        public Connection initialValue() {
            try {
                return DriverManager.getConnection("URL");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    };
    public static Connection getConnection() {
        return connectionHolder.get();
    }
}
