package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: art
 * Date: 16.07.13
 * Time: 20:33
 * To change this template use File | Settings | File Templates.
 */
public class Struct {
    private Object key;
    private Object value;
    Struct(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
    public Object key() {
        return this.key;
    }
    public Object value() {
        return this.value;
    }
    public void setKey(Object key) {
        this.key = key;
    }
    public void setValue(Object value) {
        this.value = value;
    }
}
