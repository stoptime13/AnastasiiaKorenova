package hw5.context;

import java.util.HashMap;
public class TestContext {

    private static TestContext instance;
    private HashMap<String, Object> context = new HashMap<>();

    private TestContext() {}

    public static TestContext getInstance(){
        if(instance == null) {
            instance= new TestContext();
        }
        return instance;
    }

    public <T> T getObject(String key) {
        return (T) context.get(key);
    }

    public TestContext putObject(String key, Object value) {
        context.put(key, value);
        return this;
    }

    public void clear() {
        instance = null;
        context.clear();
    }

}