package in.sherinstephen.agent;
import java.lang.instrument.*;
public class Agent {
    public static void premain(String args, Instrumentation instrumentation) {
        ClassLogger transformer = new ClassLogger();
        instrumentation.addTransformer(transformer);
    }
}