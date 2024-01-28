package com.example.commandapi;


import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GcTest {
    private Runtime runtime;

    @BeforeEach
    public void setUp() {
        runtime = Runtime.getRuntime();
    }

    private void runGC() throws InterruptedException {
        System.gc();
        Thread.sleep(100);      // GC 실행을 위한 충분한 시간 확보
    }

    private long usedMemory() {
        return runtime.totalMemory() - runtime.freeMemory();
    }

    @Test
    public void testApiMemoryUsage() throws Exception {

    }


}
