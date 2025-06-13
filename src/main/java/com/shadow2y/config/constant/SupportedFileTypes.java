package com.shadow2y.config.constant;

import lombok.Getter;

import static com.shadow2y.config.constant.Constants.SupportedFileExtensions.*;

@Getter
public enum SupportedFileTypes {

    PROPERTIES("properties"),
    JSON("json"),
    YAML("yaml"),
    YML("yml"),
    ;

    private final String extensionName;

    SupportedFileTypes(String extensionName) {
        this.extensionName = extensionName;
    }

    public static SupportedFileTypes getFileType(String extensionName) {
        return switch (extensionName) {
            case properties -> PROPERTIES;
            case json -> JSON;
            case yaml -> YAML;
            case yml -> YML;
            default -> throw new UnsupportedOperationException("File type not supported");
        };
    }

}
