package com.main.comm.component;


import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class KafkaBrokerLogDirectoryCleaner {


    private static final String LOG_DIR = "embedded-kafka-logs";

    @PreDestroy
    public void cleanOnShutdown() {
        File logDir = new File(LOG_DIR);
        if (logDir.exists() && logDir.isDirectory()) {
            deleteDirectory(logDir);
            System.out.println("Deleted log directory: " + LOG_DIR);
        } else {
            System.out.println("Log directory does not exist: " + LOG_DIR);
        }
    }

    private void deleteDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    file.delete();
                }
            }
        }
        directory.delete();
    }
}
