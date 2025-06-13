package com.shadow2y.config.impl;

import com.shadow2y.config.core.AbstractConfig;
import com.shadow2y.config.core.ConfigException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.util.Map;

public class YamlConfig extends AbstractConfig {
    private final Map<String, Object> configMap;

    public YamlConfig(String filePath) {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            configMap = mapper.readValue(new File(filePath), Map.class);
        } catch (Exception e) {
            throw new ConfigException("Error loading YAML file: " + filePath, e);
        }
    }

    @Override
    protected Map<String, Object> getConfigData() {
        return configMap;
    }
}
