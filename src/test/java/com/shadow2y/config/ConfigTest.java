package com.shadow2y.config;

import com.shadow2y.config.core.Config;
import com.shadow2y.config.core.ConfigFactory;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

import static com.shadow2y.config.Constants.*;

public class ConfigTest {

    private static final Logger log = (Logger) LoggerFactory.getLogger(ConfigTest.class);

    private final Config config;

    public ConfigTest(String filepath) {
        config = ConfigFactory.createConfig(filepath);
    }

    public void testConfig() {
        log.info(":-: Running Tests :-:");
        String value = config.getString(testKey);
        log.info("Read Value from file :: {}",value);
        assert value.equals(testValue);
    }

    public static void main(String[] args) {
        log.info(":-: Instantiating ConfigFactory :-:");
        String filepath = System.getProperty("user.dir") + "\\" + "config.properties";
        ConfigTest configTest = new ConfigTest(filepath);
        configTest.testConfig();
    }

}
