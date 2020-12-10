package com.ncepu.cloudyilaboratory.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class TestForkJoinPool {
    static class Fibonacci extends RecursiveTask<Integer> {
        final int n;
        Fibonacci(int n) { this.n = n; }
        public Integer compute() {
            System.out.println(Thread.currentThread().getName());
            if (n <= 1)
                return n;
            Fibonacci f1 = new Fibonacci(n - 1);
            f1.fork();
            Fibonacci f2 = new Fibonacci(n - 2);
            f2.fork();
            return f1.join() + f2.join();
        }
    }

    static class FibonacciCallable implements Callable<Integer> {
        private final Integer number;
        private final ExecutorService executorService;

        public FibonacciCallable(Integer number, ExecutorService executorService) {
            this.number = number;
            this.executorService = executorService;
        }

        @Override
        public Integer call() throws Exception {
            System.out.println(Thread.currentThread().getName());
            if (number <= 1) {
                return number;
            } else {
                FibonacciCallable f1 = new FibonacciCallable(number - 1, executorService);
                Future<Integer> f1Result = executorService.submit(f1);
                FibonacciCallable f2 = new FibonacciCallable(number - 2, executorService);
                Future<Integer> f2Result = executorService.submit(f2);
                return f1Result.get() + f2Result.get();
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "3");
        Fibonacci fibonacci = new Fibonacci(1);
        fibonacci.fork();
//        Integer result = fibonacci.invoke();
        Integer result = fibonacci.join();
        System.out.println(result);
        Object.class.getTypeParameters();

        /*ExecutorService executorService = Executors.newFixedThreadPool(10);
        FibonacciCallable fibonacciCallable = new FibonacciCallable(4, executorService);
        Future<Integer> result = executorService.submit(fibonacciCallable);
        System.out.println(result.get());*/
    }


}
