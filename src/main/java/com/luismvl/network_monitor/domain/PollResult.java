package com.luismvl.network_monitor.domain;

import java.time.Instant;

public record PollResult(
        Long deviceId,
        boolean icmpReachable,
        Long icmpLatencyMs,
        boolean snmpAttemped,
        boolean snmpSuccessful,
        DeviceStatus status,
        Instant checkedAt,
        String errorMessage

) {
}
