package examples.webapi.client.webapiclient;

import examples.webapi.client.webapiclient.dto.Todo;
import examples.webapi.client.webapiclient.service.TodoService;
import examples.webapi.client.webapiclient.utils.ObjectHolder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AppRunner implements CommandLineRunner {

    private final TodoService todoService;

    public AppRunner(TodoService todoService) {
        this.todoService = todoService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Start the clock
        long start = System.currentTimeMillis();

        ObjectHolder.local.set(new String("hello"));
        // Kick of multiple, asynchronous lookups
        CompletableFuture<Todo> page1 = todoService.findUser(1L);
        CompletableFuture<Todo> page2 = todoService.findUser(2L);
        CompletableFuture<Todo> page3 = todoService.findUser(3L);

        // Wait until they are all done
        CompletableFuture.allOf(page1,page2,page3).join();

        // Print results, including elapsed time
        System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
        System.out.println("--> " + page1.get());
        System.out.println("--> " + page2.get());
        System.out.println("--> " + page3.get());

    }

}