package cn.edu.whut.sept.zuul.util;

import java.util.Map;

public class FindKeyByValueInHashMap {
    /**
     * Retrieves the key corresponding to the specified value in the map.
     *
     * @param map   The map to search.
     * @param value The value to search for.
     * @param <K>   The type of keys in the map.
     * @param <V>   The type of values in the map.
     * @return The key corresponding to the specified value, or null if not found.
     */
    public static <K, V> K getKeyByValue(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
