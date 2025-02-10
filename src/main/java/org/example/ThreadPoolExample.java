package org.example;
import java.util.concurrent.*;

public class ThreadPoolExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
            ExecutorService executor = Executors.newFixedThreadPool(3);
        DataUrls dataUrls = new DataUrls();

        for (int i = 0; i < 10; i++) {
            Task task = new Task(i, dataUrls);
            executor.execute(task);
        }

            shutdownAndAwaitTermination(executor);
        }

        static void shutdownAndAwaitTermination(ExecutorService pool) {
            // Disable new tasks from being submitted
            pool.shutdown();
            try {
                // Wait a while for existing tasks to terminate
                if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                    // Cancel currently executing tasks forcefully
                    pool.shutdownNow();
                    // Wait a while for tasks to respond to being cancelled
                    if (!pool.awaitTermination(60, TimeUnit.SECONDS))
                        System.err.println("Pool did not terminate");
                }
            } catch (InterruptedException ex) {
                // (Re-)Cancel if current thread also interrupted
                pool.shutdownNow();
                // Preserve interrupt status
                Thread.currentThread().interrupt();
            }
        }
    }


