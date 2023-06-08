package task3;

import java.util.concurrent.*;

//попробуй теперь переделать задачу, чтобы клиент брал операторов из пула потоков (реализуй сам кастомный пул потоков),
// какая то логика звонка, после окончания звонка оператор возвращается обратно в пул потоков
public class TaskThree {

    public static void main(String[] args) {
//        Operator operator1 = new Operator("Tom");
//        Operator operator2 = new Operator("Bob");

        MyThreadPool operators = new MyThreadPool(2,2);

        Client client1 = new Client("John");
        Client client2 = new Client("Alex");
        Client client3 = new Client("Ivan");
        Client client4 = new Client("Cole");
        Client client5 = new Client("Miley");
        Client client6 = new Client("Rihanna");
        Client client7 = new Client("Adele");
        Client client8 = new Client("Lana");
        Client client9 = new Client("Rick");



        client1.setOp(operators.getOperator());
        client2.setOp(operators.getOperator());
        client1.start();
        client2.start();
        client3.setOp(operators.getOperator());
        client4.setOp(operators.getOperator());
        client3.start();
        client4.start();
//        client5.setOp(operators.get(0));
//        client6.setOp(operators.get(1));
//        client7.setOp(operators.get(1));
//        client8.setOp(operators.get(1));
//        client9.setOp(operators.get(1));
//

//        client4.start();
//        client5.start();
//        client6.start();
//        client7.start();
//        client8.start();
//        client9.start();
        operators.shutdown();
    }

}
class MyThreadPool{

    private final ArrayBlockingQueue<Runnable> tasksQueue;
    private int poolCapacity;
    private final ArrayBlockingQueue<Operator> opeartors;

    MyThreadPool(int tasksCapacity, int poolCapacity) {
        this.tasksQueue = new ArrayBlockingQueue<>(tasksCapacity);
        this.poolCapacity = poolCapacity;
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
    }
}

