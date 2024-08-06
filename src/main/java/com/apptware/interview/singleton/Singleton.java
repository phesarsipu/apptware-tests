/** This class is expected to be a singleton. Please make necessary changes. */
package com.apptware.interview.singleton;

import java.io.Serializable;
import java.util.Objects;

public class Singleton implements Serializable {

    private static volatile Singleton single_instance = null;
    private static final long serialVersionUID = 1L;

    public String s;

    private Singleton() {
        s = "Hello I am a string part of Singleton class";
    }

    public static Singleton getInstance() {
        if (single_instance == null) {
            synchronized (Singleton.class) {
                if (single_instance == null) {
                    single_instance = new Singleton();
                }
            }
        }
        return single_instance;
    }

    private Object readResolve() {
        return getInstance();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Singleton singleton = (Singleton) o;

        return Objects.equals(s, singleton.s);
    }

    @Override
    public int hashCode() {
        return s != null ? s.hashCode() : 0;
    }
}