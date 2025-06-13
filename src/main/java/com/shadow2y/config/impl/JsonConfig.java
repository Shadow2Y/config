package com.shadow2y.config.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shadow2y.config.core.AbstractConfig;
import com.shadow2y.config.core.ConfigException;

import java.io.File;
import java.util.Map;

public class JsonConfig extends AbstractConfig {
    private final Map<String,Object> configMap;

    public JsonConfig(String filePath) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            configMap = mapper.readValue(new File(filePath), Map.class);
        } catch (Exception e) {
            throw new ConfigException("Error loading JSON file: " + filePath, e);
        }
    }

    @Override
    protected Map<String, Object> getConfigData() {
        return configMap;
    }
}
