package edu.java.configuration.retry;

import edu.java.configuration.ApplicationConfig;
import edu.java.retry.strategy.LinearRetryStrategy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.util.retry.Retry;
@Configuration
@ConditionalOnProperty(prefix = "app", name = "retry-config.policy", havingValue = "linear")
public class LinearRetryConfig {
    @Bean
    public Retry retry(ApplicationConfig.RetryConfig retryConfig) {
        return new LinearRetryStrategy(retryConfig.maxAttempts(), retryConfig.backoff(), retryConfig.maxBackoff(), retryConfig.statusCodes()).getRetryPolice();
    }
}
