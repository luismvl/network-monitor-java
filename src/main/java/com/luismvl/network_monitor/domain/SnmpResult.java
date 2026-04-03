package com.luismvl.network_monitor.domain;

import java.time.Instant;

public record SnmpResult(
        Boolean attempted,
        Boolean successful,
        String sysName,
        Instant checkedAt,
        String errorMessage

) {
}
