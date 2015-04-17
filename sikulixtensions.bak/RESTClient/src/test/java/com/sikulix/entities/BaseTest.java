package com.sikulix.entities;

import com.sikulix.restclient.client.Client;
import com.sikulix.restcore.interfaces.RemoteSikulix;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.URISyntaxException;
import java.util.logging.Logger;

/**
 * Author: Sergey Kuts
 */
public class BaseTest {

    // You should set real IP, instead of localhost
    public static final String SIKULIX_SERVER_IP = "127.0.0.1";
    public static final int SIKULIX_SERVER_PORT = 4041;

    // Don't forget to change resource batches' extension from .txt to .bat
    public static final String RESOURCE_RUNNER_BATCH = "batches/runner.bat";
    public static final String RESOURCE_SAMPLE_BATCH = "batches/sampleBatch.bat";
    public static final String RESOURCE_BUTTON_START_IMAGE = "images/buttonStart.png";
    public static final String RESOURCE_INPUT_FIND_FILES_IMAGE = "images/inputFindFiles.png";
    public static final String RESOURCE_INPUT_CMD_IMAGE = "images/inputCmd.png";
    public static final String RESOURCE_TERMINAL_IMAGE = "images/terminal.png";
    public static final String RESOURCE_INPUT_TERMINAL_IMAGE = "images/inputTerminal.png";
    public static final String RESOURCE_LABEL_FF_IMAGE = "images/labelFF.png";
    public static final String RESOURCE_SH_SCRIPT = "sh/script.sh";

    public static final String EMPTY_FILE = "empty.txt";

    public static final int WAIT_TIMEOUT = 3;
    public static final float SIMILARITY = 0.9f;

    private static final Logger BASE_TEST_LOGGER = Logger.getLogger(BaseTest.class.getName());

    // In case of tests scalability, you should take care about Sikulix thread-safety!
    private static RemoteSikulix sikuliXClient;

    @BeforeSuite
    public void initClient() {
        if (sikuliXClient == null) {
            sikuliXClient = new Client(SIKULIX_SERVER_IP, SIKULIX_SERVER_PORT);
        }
    }

    @AfterSuite
    public void disposeClient() {
        if (sikuliXClient != null) {
            sikuliXClient.close();
        }
    }

    public RemoteSikulix getClient() {
        return sikuliXClient;
    }

    public static File getResource(final String resourceName) {
        try {
            return new File(ClassLoader.getSystemResource(resourceName).toURI());
        } catch (URISyntaxException e) {
            BASE_TEST_LOGGER.severe("Unable to get URI from resource " + resourceName + ": " + e.getMessage());
            return null;
        }
    }
}
