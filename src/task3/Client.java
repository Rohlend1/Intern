package task3;

public class Client extends Thread{

    private final String name;
    private MyThreadPool.Operator op;
    Client(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        while(true){
            try{
                System.out.println(name+" waiting to operator "+op.getOpName());
                Thread.sleep(500);
                System.out.println(name+" speaking with operator "+op.getOpName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                op.backToPool();
            }
        }
    }

    public void setOp(MyThreadPool.Operator op) {
        this.op = op;
    }
}
