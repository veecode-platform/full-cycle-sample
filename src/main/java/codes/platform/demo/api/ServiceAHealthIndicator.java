package codes.platform.demo.api;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ServiceAHealthIndicator implements HealthIndicator {
  private static final Logger LOGGER = LoggerFactory.getLogger(ServiceAHealthIndicator.class);
  
  private final String message_key = "Service A";

  @Override
  public Health health() {
    if (!isRunningServiceA()) {
      return Health.down().withDetail(message_key, "Not Available").build();
    }
    return Health.up().withDetail(message_key, "Available").build();
  }

  private Boolean isRunningServiceA() {
    Boolean isRunning = true;
    // Logic Skipped
    LOGGER.info("Is Running: %s at %s".formatted(isRunning, LocalDateTime.now()));
    return isRunning;
  }
}

