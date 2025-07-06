package com.nuevo.spa.gestortareas.util;

public interface ObjectFactory<T> {
    T createObject(String name);
}
