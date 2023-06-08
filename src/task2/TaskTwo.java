package task2;

import java.io.*;
import java.util.concurrent.*;

public class TaskTwo {

    public static final String PATH_TO_FILE1 = "src\\task2\\text.txt";
    public static final String PATH_TO_FILE2 = "src\\task2\\text1.txt";
    private static final ArrayBlockingQueue<String> map = new ArrayBlockingQueue<>(20);


    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();
        ExecutorService threadPoolExecutorService = Executors.newFixedThreadPool(10);

        Thread daemonThread = new Thread(() -> {
            try {
                while (true) {
                    System.out.println(map.take());
                }
            }
            catch (InterruptedException ignored){

            }
        });
        daemonThread.setDaemon(true);
        daemonThread.start();

        singleExecutorService.execute(new RunnableImpl(PATH_TO_FILE1));
        threadPoolExecutorService.submit(new RunnableImpl(PATH_TO_FILE2));

        singleExecutorService.shutdown();
        threadPoolExecutorService.shutdown();

        System.out.println(System.currentTimeMillis()-startTime);
    }
    static class RunnableImpl implements Runnable{
        private final String path;
        public RunnableImpl(String path) {
            this.path = path;
        }

        @Override
        public void run() {
            try(BufferedReader br = new BufferedReader(new FileReader(path))){
                String line;
                while((line = br.readLine())!=null){
                    map.offer(line);
                }
            }
            catch (IOException ignored){
            }
        }
    }

}

