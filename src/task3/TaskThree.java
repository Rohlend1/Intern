package task3;

import java.util.concurrent.*;

public class TaskThree {

    public static void main(String[] args) {

        MyThreadPool operators = new MyThreadPool(2,2);

        Client client1 = new Client("John");
        Client client2 = new Client("Alex");
        Client client3 = new Client("Ivan");
        Client client4 = new Client("Cole");

        client1.setOp(operators.getOperator());
        client2.setOp(operators.getOperator());
        client1.start();
        client2.start();
        client3.setOp(operators.getOperator());
        client4.setOp(operators.getOperator());
        client3.start();
        client4.start();

        operators.shutdown();
    }

}
class MyThreadPool{

    private final ArrayBlockingQueue<Runnable> tasksQueue;
    private final ArrayBlockingQueue<Operator> opeartors;

    MyThreadPool(int tasksCapacity, int poolCapacity) {
        this.tasksQueue = new ArrayBlockingQueue<>(tasksCapacity);
        opeartors = new ArrayBlockingQueue<>(poolCapacity);
        for(int i = 0; i < poolCapacity;i++){
            opeartors.add(new Operator("Bob-"+i));
        }
    }

    public void shutdown(){
        for(Operator operator : opeartors){
            operator.shutdown();
        }
    }

    public void submit(Runnable command){
        if(command == null){
            throw new NullPointerException();
        }
        try {
            tasksQueue.put(command);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public Operator getOperator(){
        try {
            return opeartors.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    final class Operator extends Thread{
        private final String opName;
        public Operator(String opName) {
            this.opName = opName;
        }
        @Override
        public void run() {
            while (true){
                if(interrupted()){
                    return;
                }
                try {
                    tasksQueue.take().run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        public void shutdown(){
            this.interrupt();
        }
        public String getOpName(){
            return opName;
        }
        public void backToPool(){
            opeartors.offer(this);
        }
    }
}

