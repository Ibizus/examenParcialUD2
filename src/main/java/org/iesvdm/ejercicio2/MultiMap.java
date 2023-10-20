package org.iesvdm.ejercicio2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class MultiMap<K,V> {

    // ATTRIBUTES:
    private HashMap<K, List<V>> mapa;

    // CONSTRUCTOR:
    public MultiMap(){
        this.mapa = new HashMap<>();
    }

    // METHODS:
    public void add(K key, V value){

        if(this.mapa.containsKey(key)){

            this.mapa.get(key).add(value);
        }

    }

    public void addIfAbsent(K key, V value){

        if(!this.mapa.containsKey(key)){

            List<V> valores = new ArrayList<>();
            valores.add(value);
            this.mapa.put(key, valores);
        }
    }

    public Collection<V> get(K key){

        if(this.mapa.containsKey(key)){

            return this.mapa.get(key);
        }
        else{
            return null;
        }
    }

    public boolean remove(K key, V value){

        boolean removed = false;

        if(this.mapa.containsKey(key)){

            this.mapa.remove(key, value);
            removed = true;
        }
        return removed;
    }

    public long totalSize(){

        long total = 0;
        for (K key: this.mapa.keySet()) {

            total+= this.mapa.get(key).size();
        }
        return total;
    }
}
