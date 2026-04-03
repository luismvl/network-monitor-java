package com.luismvl.network_monitor.domain;

import java.time.Instant;

public record IcmpResult(
        boolean reachable,
        Long latencyMs,
        Instant checkedAt,
        String errorMessage

) {

}
