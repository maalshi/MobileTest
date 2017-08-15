package webdriver;

//import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {

    public static final String PROPERTY_FILE_NAME = "run_properties.properties";

    // private final Logger logger = Logger.getLogger(TestProperties.class);

    private static ThreadLocal<TestProperties> instance = new ThreadLocal<TestProperties>();

    private TestProperties() {
        setPropValues();
    }

    public static synchronized TestProperties getInstance() {
        if (null == instance.get())
            instance.set(new TestProperties());
        return instance.get();
    }

    private String baseUrl;

    private String platformName;

    private String saucelabsUserName;

    private String saucelabsUserKay;

    private String applitoolsUserKay;

    private String appiumURL;

    private boolean saucelabsEmulator;

    private Integer defaultTimeout;

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getPlatformName() {
        return this.platformName;
    }

    public boolean getSaucelabsEmulator() {
        return this.saucelabsEmulator;
    }

    public String getSaucelabsUserName() {
        return this.saucelabsUserName;
    }

    public String getSaucelabsUserKay() {
        return this.saucelabsUserKay;
    }

    public String getAppiumURL() {
        return this.appiumURL;
    }
    public String getApplitoolsUserKay() {
        return this.applitoolsUserKay;
    }

    public Integer getDefaultTimeout() {
        return this.defaultTimeout;
    }

    public void setPropValues() {
        InputStream inputStream = null;
        try {

            Properties prop = new Properties();
            inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTY_FILE_NAME);
            if (inputStream == null)
                throw new FileNotFoundException(
                        "property file '" + PROPERTY_FILE_NAME + "' not found in the classpath");

            prop.load(inputStream);

            baseUrl = prop.getProperty("environment.variables.base_url");
            platformName = prop.getProperty("environment.variables.platformName");
            appiumURL = prop.getProperty("environment.variables.appiumURL");
            saucelabsEmulator = Boolean.valueOf(prop.getProperty("environment.variables.saucelabsEmulator"));
            saucelabsUserName = prop.getProperty("environment.variables.saucelabsUserName");
            saucelabsUserKay = prop.getProperty("environment.variables.saucelabsUserKay");
            applitoolsUserKay = prop.getProperty("environment.variables.applitoolsUserKay");
            defaultTimeout = Integer.parseInt(prop.getProperty("test.variables.default.timeout"));
        } catch (Exception ex) {
            // logger.error("Exception while initializing test properties.
            // Exception: " + ex);
        } finally {
            try {
                if (null != inputStream)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
