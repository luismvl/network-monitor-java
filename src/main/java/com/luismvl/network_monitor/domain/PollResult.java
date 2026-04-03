package com.luismvl.network_monitor.domain;

public record PollResult(
        Long deviceId,
        Boolean reachable,
        Long latencyMs

) {
}
