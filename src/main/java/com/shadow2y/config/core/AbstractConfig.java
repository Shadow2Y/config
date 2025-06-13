package com.shadow2y.config.core;

import java.util.Map;

public abstract class AbstractConfig implements Config {
    protected abstract Map<String, Object> getConfigData();

    @Override
    public String getString(String key) {
        Object value = getConfigData().get(key);
        if (value == null) {
            throw new ConfigException("Key not found :: " + key);
        }
        return value.toString();
    }

    @Override
    public String getString(String key, String defaultValue) {
        return getConfigData().containsKey(key) ? getString(key) : defaultValue;
    }

    @Override
    public int getInt(String key) {
        try {
            return Integer.parseInt(getString(key));
        } catch (NumberFormatException e) {
            throw new ConfigException("Invalid integer value for key :: " + key);
        }
    }

    @Override
    public int getInt(String key, int defaultValue) {
        return getConfigData().containsKey(key) ? getInt(key) : defaultValue;
    }

    @Override
    public boolean getBoolean(String key) {
        String value = getString(key).toLowerCase();
        if ("true".equals(value) || "1".equals(value)) return true;
        if ("false".equals(value) || "0".equals(value)) return false;
        throw new ConfigException("Invalid boolean value for key :: " + key);
    }

    @Override
    public boolean getBoolean(String key, boolean defaultValue) {
        return getConfigData().containsKey(key) ? getBoolean(key) : defaultValue;
    }

    @Override
    public boolean hasKey(String key) {
        return getConfigData().containsKey(key);
    }
}