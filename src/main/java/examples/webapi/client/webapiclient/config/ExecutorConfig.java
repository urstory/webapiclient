package examples.webapi.client.webapiclient.config;

import examples.webapi.client.webapiclient.utils.ContextAwarePoolExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;

import java.util.concurrent.Executor;

@Configuration
public class ExecutorConfig extends AsyncConfigurerSupport {
    @Override
    @Bean
    public Executor getAsyncExecutor() {
        System.out.println("********");
        ContextAwarePoolExecutor executor = new ContextAwarePoolExecutor();

        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("todo-");
        executor.initialize();

        return executor;
    }
}