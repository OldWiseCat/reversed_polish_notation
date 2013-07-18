package com.company;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: art
 * Date: 16.07.13
 * Time: 20:25
 * To change this template use File | Settings | File Templates.
 */
public class Dictionary implements Map {
    private Vector<Struct<String, Integer>> vault = new Vector<Struct<String, Integer>>();
    @Override
    public int size() {
        return vault.size();
    }

    @Override
    public boolean isEmpty() {
        if (vault.isEmpty()) {
            return true;
        }
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean containsKey(Object o) {
        for (Struct struct: vault) {
            if (struct.key().equals(o)) {
                return true;
            }
        }
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean containsValue(Object o) {
        for (Struct struct: vault) {
            if (struct.value().equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(Object o) {
        for (Struct struct: vault) {
            if (struct.key().equals(o)) {
                return struct.value();
            }
        }
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object put(Object o, Object o2) {
        boolean fl = true;
        for (Struct struct: vault) {
            if (struct.key().equals(o)) {
                fl = false;
                break;
            }
        }
        if (fl) {
            vault.add(new Struct(o,o2));
        }
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object remove(Object o) {
        int i =0;
        while (i < vault.size())
        if (vault.elementAt(i).key().equals(o)) {
            Object ret = vault.elementAt(i).value();
            vault.remove(i);
            return ret;
        }
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void putAll(Map map) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void clear() {
        vault.clear();
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Set keySet() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection values() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Set<Entry> entrySet() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
