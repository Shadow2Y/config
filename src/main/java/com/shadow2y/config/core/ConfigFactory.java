package com.shadow2y.config.core;

import com.shadow2y.config.constant.SupportedFileTypes;
import com.shadow2y.config.impl.JsonConfig;
import com.shadow2y.config.impl.PropertiesConfig;
import com.shadow2y.config.impl.YamlConfig;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public class ConfigFactory {

    private static final Logger log = (Logger) LoggerFactory.getLogger(ConfigFactory.class);

    public static Config createConfig(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }
        log.info("Extracting config from the filename :: {}",filePath);
        String extension = getFileExtension(filePath).toLowerCase();
        SupportedFileTypes fileType = SupportedFileTypes.getFileType(extension);

        return switch (fileType) {
            case PROPERTIES -> new PropertiesConfig(filePath);
            case JSON -> new JsonConfig(filePath);
            case YML, YAML -> new YamlConfig(filePath);
        };
    }

    private static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == fileName.length() - 1) {
            throw new IllegalArgumentException("File has no extension: " + fileName);
        }
        return fileName.substring(dotIndex + 1);
    }
}
