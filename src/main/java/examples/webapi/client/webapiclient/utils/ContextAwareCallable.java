package examples.webapi.client.webapiclient.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.concurrent.Callable;

public class ContextAwareCallable<T> implements Callable<T> {
    private Callable<T> task;
    private Object object;

    public ContextAwareCallable(Callable<T> task, Object context) {
        this.task = task;
        this.object = context;
    }

    @Override
    public T call() throws Exception {
        if (object != null) {
            ObjectHolder.local.set(object);
        }

        try {
            return task.call();
        } finally {
            ObjectHolder.local.set(null);
        }
    }
}