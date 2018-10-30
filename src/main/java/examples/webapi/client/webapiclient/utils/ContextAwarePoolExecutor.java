package examples.webapi.client.webapiclient.utils;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class ContextAwarePoolExecutor extends ThreadPoolTaskExecutor {
    @Override
    public <T> Future<T> submit(Callable<T> task) {
        System.out.println("** : " + ObjectHolder.local.get());
        return super.submit(new ContextAwareCallable(task, ObjectHolder.local.get()));
    }

    @Override
    public <T> ListenableFuture<T> submitListenable(Callable<T> task) {
        System.out.println("!! : " + ObjectHolder.local.get());
        return super.submitListenable(new ContextAwareCallable(task, ObjectHolder.local.get()));
    }


}