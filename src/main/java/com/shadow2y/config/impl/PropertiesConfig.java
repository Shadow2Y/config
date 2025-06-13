package com.shadow2y.config.impl;

import com.shadow2y.config.core.AbstractConfig;
import com.shadow2y.config.core.ConfigException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesConfig extends AbstractConfig {
    private final Map<String, Object> configMap = new HashMap<>();

    public PropertiesConfig(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            Properties props = new Properties();
            props.load(fis);
            props.forEach((k, v) -> configMap.put(k.toString(), v));
        } catch (IOException e) {
            throw new ConfigException("Error loading properties file: " + filePath, e);
        }
    }

    @Override
    protected Map<String, Object> getConfigData() {
        return configMap;
    }
}
