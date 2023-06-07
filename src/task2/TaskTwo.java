package task2;

import java.io.*;
import java.util.concurrent.*;

//2 задачка: Написать программу со следующим функционалом:
//Создать 2 исполнителя(ExecutorService).
// Первый - фабричная однопоточная реализация, второй - реализация ThreadPoolExecutor.
// Также необходимо создать thread safe коллекцию, в которую 2 исполнителя будут записывать данные.
//Также создать поток-демон, который будет вычитывать содержимое коллекции, если в нее что-то добавляется - выводить в консоль,
// используя system.out(при вычитке - из коллекции элемент убирать).
//2 исполнителя должны принять на выполнение задачу  типа Runnable на вычитку всего содержимого(несколько строк текста)
// из текстового фаила(путь до фаила, имя фаила передавать через конструктор, коллекцию для записи). Коллекция для записи c типом String
public class TaskTwo {

    public static final String PATH = "src\\task2\\text.txt";
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

        singleExecutorService.execute(new RunnableImpl(PATH));
        threadPoolExecutorService.submit(new RunnableImpl(PATH));

        singleExecutorService.shutdown();
        threadPoolExecutorService.shutdown();

        singleExecutorService.close();
        threadPoolExecutorService.close();
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

