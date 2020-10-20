package org.example.example3_threadpool;

import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.*;

@Slf4j
public class ThreadPools {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callableTask = () -> {
            TimeUnit.SECONDS.sleep(1);
            return "Task's execution";
        };


        // example 1
        int processors = Runtime.getRuntime().availableProcessors();
        LOGGER.info("Number of processors: {}\n", processors);

        ExecutorService executor1 = Executors.newFixedThreadPool(processors);
        Future<String> future1 = executor1.submit(callableTask );
        LOGGER.info(executor1.toString());
        LOGGER.info("{}", future1.get());
        LOGGER.info(executor1.toString());
        executor1.shutdown();



        // example 2
        LOGGER.info("Example 2\n");

        ExecutorService executor2 = Executors.newFixedThreadPool(1);
        // Assigning Tasks to the ExecutorService
        Future<String> future2 = executor2.submit(callableTask);
        LOGGER.info("Future done? {}", future2.isDone());
        LOGGER.info(executor2.toString());

        String result = future2.get();
        LOGGER.info("Future done? {}", future2.isDone());
        LOGGER.info(executor2.toString());
        LOGGER.info("Result {}\n", result);

        executor2.shutdown();



        // example 3 - list of task objects
        LOGGER.info("Example 3\n");

        Callable<Person> callableTask1 = () -> {
            TimeUnit.SECONDS.sleep(1);

            Random rand = SecureRandom.getInstanceStrong(); // SecureRandom is preferred to Random
            int randValue = rand.nextInt(50); // returns pseudo-random value between 0 and 50

            return new Person("Name" + randValue, randValue);
        };

        List<Callable<Person>> callableTasks  = new ArrayList<>();
        callableTasks.add(callableTask1);
        callableTasks.add(callableTask1);
        callableTasks.add(callableTask1);
        callableTasks.add(callableTask1);
        callableTasks.add(callableTask1);
        callableTasks.add(callableTask1);
        callableTasks.add(callableTask1);
        callableTasks.add(callableTask1);
        callableTasks.add(callableTask1);
        callableTasks.add(callableTask1);

        ExecutorService executor3 = Executors.newFixedThreadPool(processors);

        // Execute all tasks and get reference to Future objects
        List<Future<Person>> resultList = null;
        try {
            resultList = executor3.invokeAll(callableTasks);
        } catch (InterruptedException e) {
            // InterruptedException when an another thread interrupts this thread
            LOGGER.error("Interrupted!", e);
            // Restore interrupted state...
            Thread.currentThread().interrupt();
        }
        LOGGER.info(executor3.toString());

        executor3.shutdown();

        LOGGER.info("\n========Printing the results======");

        for (Future<Person> future : Objects.requireNonNull(resultList)) {
            try {
                Person person = future.get();
                System.out.println(person.getName() + ": " + person.getAge() + " years old");
            } catch (InterruptedException | ExecutionException e) {
                LOGGER.error("Interrupted!", e);
                // Restore interrupted state...
                Thread.currentThread().interrupt();
            }
        }
    }
}
