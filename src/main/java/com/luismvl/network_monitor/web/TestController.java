package com.luismvl.network_monitor.web;

import org.springframework.web.bind.annotation.RestController;

import com.luismvl.network_monitor.domain.DeviceConfig;
import com.luismvl.network_monitor.domain.PollResult;
import com.luismvl.network_monitor.domain.PollWorker;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class TestController {
    private final PollWorker pollWorker;

    public TestController(PollWorker pollWorker) {
        this.pollWorker = pollWorker;
    }

    @GetMapping("/test-poll")
    public PollResult testPoll() {
        DeviceConfig config = new DeviceConfig(1L, "router-lab-01", "127.0.0.1", 1161, "v2c", "public", true, true);

        return pollWorker.pollOne(config);
    }

}
