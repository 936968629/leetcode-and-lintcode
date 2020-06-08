package common;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyMap<K,V> extends AbstractMap<K,V> implements Serializable,Cloneable {

    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private float loadFactor;

    MyMap.MyNode<K,V>[] table;

    public static class MyNode<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        MyNode<K,V> next;
        MyNode(int hash, K key, V value, MyNode<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
    }

    public MyMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    @Override
    public V put(K key, V value) {
        int hash = key.hashCode();
        MyNode<K,V>[] cur = table;
        int n;
        if ( cur == null || cur.length == 0 ) {
//           cur = resize();
           n = cur.length;
        }

        return value;
    }


//    private MyNode<K,V>[] resize() {
//
//    }





    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
