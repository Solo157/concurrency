package Introduction;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import net.jcip.annotations.ThreadSafe;

import java.math.BigInteger;

//@ThreadSafe
//public class StatelessFactorizer implements Servlet {
//    public void service(ServletRequest req, ServletResponse resp) {
//        BigInteger i = extractFromRequest(req);
//        BigInteger[] factors = factor(i);
//        encodeIntoResponse(resp, factors);
//    }
//}