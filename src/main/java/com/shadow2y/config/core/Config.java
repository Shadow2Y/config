package com.shadow2y.config.core;

public interface Config {
    String getString(String key);
    String getString(String key, String defaultValue);
    int getInt(String key);
    int getInt(String key, int defaultValue);
    boolean getBoolean(String key);
    boolean getBoolean(String key, boolean defaultValue);
    boolean hasKey(String key);
}