package com.shadow2y.config;

import com.shadow2y.config.core.Config;
import com.shadow2y.config.core.ConfigException;
import com.shadow2y.config.core.ConfigFactory;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

import static com.shadow2y.config.Constants.*;

public class ConfigTest {

    private static final Logger log = (Logger) LoggerFactory.getLogger(ConfigTest.class);


    public static void positiveConfig(String filepath) {
        Config config = ConfigFactory.createConfig(filepath);
        log.info(":-: Running - POSITIVE - Tests :-:");
        String value = config.getString(testKey);
        log.info("Read Value from - POSITIVE - file :: {}",value);

        if(!value.equals(testValue)) {
            throw new RuntimeException("Test failed :: Expected :: "+testValue+" :: found :: "+value);
        }
        log.info("\n>>>>>> :-: Test :: positiveConfig :: Passed Successfully OoO :-:\n");
    }

    public static void negativeConfig(String filepath) {
        Config config = ConfigFactory.createConfig(filepath);
        log.info(":-: Running - NEGATIVE - Tests :-:");
        String value = config.getString(testKey);
        log.info("Read Value from - NEGATIVE - file :: {}",value);

        if(value.equals(testValue)) {
            throw new RuntimeException("Test failed :: Expected not :: "+testValue+" :: found :: "+value);
        }
        log.info("\n>>>>>> :-: Test :: negativeConfig :: Passed Successfully OoO :-:\n");
    }

    public static void nonExistentConfig(String filepath) {
        Config config = ConfigFactory.createConfig(filepath);
        log.info(":-: Running - Non-Existent - Tests :-:");
        try {
            String value = config.getString(testKey);
            log.info("Read Value from - Non-Existent - file :: {}", value);
        } catch (ConfigException e) {
            log.info("\n>>>>>> :-: Test :: nonExistentConfig :: Passed Successfully OoO :-:\n");
            return;
        }
        throw new RuntimeException("Test failed :: Didn't Expect Key :: "+testValue);
    }

    public static void main(String[] args) {
        log.info(":-: Instantiating ConfigFactory :-:");
        String[] positiveTestFiles = {"config.properties","config.json","config.yaml","config.yml"};

        String baseFilepath = System.getProperty("user.dir") + "\\";
        positiveConfig(baseFilepath + positiveTestFiles[0]);
        positiveConfig(baseFilepath + positiveTestFiles[1]);
        positiveConfig(baseFilepath + positiveTestFiles[2]);
        positiveConfig(baseFilepath + positiveTestFiles[3]);

        negativeConfig(baseFilepath + "negative.properties");
        nonExistentConfig(baseFilepath + "nonexistent.properties");
    }

}