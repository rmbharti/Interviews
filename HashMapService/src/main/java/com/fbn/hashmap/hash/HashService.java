package com.fbn.hashmap.hash;


import org.springframework.stereotype.Component;
import com.fbn.util.FbnHashMap;
import com.fbn.util.Map;

@Component
public class HashService {

    private Map<String, Map<Object, Object>> fbnHashMaps = new com.fbn.util.FbnHashMap<>();

    public void create(String id) {
        fbnHashMaps.put(id, new FbnHashMap<Object, Object>());
    }

    public void delete(String id) {
        fbnHashMaps.remove(id);
    }

    public void put(String id, Object key, Object value) {
        Map<Object, Object> mapInstance = fbnHashMaps.get(id);
        mapInstance.put(key, value);
    }

    public Object get(String id, Object key) {
        Map<Object, Object> mapInstance = fbnHashMaps.get(id);
        return mapInstance.get(key);
    }

    public void delete(String id, Object key) {
        Map<Object, Object> mapInstance = fbnHashMaps.get(id);
        mapInstance.remove(key);
    }

}
