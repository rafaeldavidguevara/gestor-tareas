package com.nuevo.spa.gestortareas.util.factory;

public interface ObjectFactory<T,V> {
    T createObject(V data);
}
