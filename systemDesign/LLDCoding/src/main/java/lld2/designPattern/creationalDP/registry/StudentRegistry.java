package lld2.designPattern.creationalDP.registry;

import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {
    Map<String, Student> map = new HashMap<>();

    public void add(String key, Student st) {
        map.put(key, st);
    }

    public Student get(String key) {
        if (!map.containsKey(key))
            return null;
        return map.get(key);

    }

}
