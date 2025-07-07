package com.nuevo.spa.gestortareas.util;

public interface ObjectFactory<T,V> {
    T createObject(V data);
}
