package cbi.generator.meta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class MetaBase {
    Map<String, Object> map;
    public Boolean getBoolean(String name, Boolean defaultValue) {
        if(defaultValue == null && !map.containsKey(name))
            return null;
        return map.getOrDefault(name, defaultValue).equals(true);
    }
    public boolean getBoolean(String name, boolean defaultValue) {
        return map.getOrDefault(name, defaultValue).equals(true);
    }
    public String getString(String name, String defaultValue){
        if(defaultValue == null && !map.containsKey(name))
            return null;
        return map.getOrDefault(name, defaultValue).toString();
    }
    public <T_Enum extends Enum<T_Enum>> T_Enum getEnum(String name, T_Enum defaultValue, Class<T_Enum> enumClass){
        Object value = map.get(name);
        if(value != null) {
            return T_Enum.valueOf(enumClass, value.toString());
        }
        return defaultValue;
    }
    public ArrayList<String> getStringArray(String name){
        ArrayList<String> strings = new ArrayList<>();
        Object values = map.get(name);
        if(values instanceof Collection<?>){
            for(Object value : (Collection<?>)values) {
                strings.add(value.toString());
            }
        }
        return strings;
    }
    public MetaBase(Map<String, Object> map) {
        this.map = map;
    }
}
