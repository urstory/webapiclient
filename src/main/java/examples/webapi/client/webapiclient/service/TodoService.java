package examples.webapi.client.webapiclient.service;

import examples.webapi.client.webapiclient.dto.Todo;
import examples.webapi.client.webapiclient.utils.ObjectHolder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class TodoService {
    private final RestTemplate restTemplate;

    public TodoService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<Todo> findUser(Long id) throws InterruptedException {
        Object obj = ObjectHolder.local.get();
        System.out.println("object : " + obj);
        String url = String.format("http://localhost:8080/todos/%d", id);
        Todo results = restTemplate.getForObject(url, Todo.class);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);
    }

}
