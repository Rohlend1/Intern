package task3;

public class Client extends Thread{

    private final String name;
    private Operator op;
    Client(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        while(true){
            try{
                System.out.println(name+" waiting to operator "+op.getOpName());
                op.getSemaphore().acquire();
                System.out.println(name+" speaking with operator "+op.getOpName());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                op.getSemaphore().release();
            }
        }
    }

    public void setOp(Operator op) {
        this.op = op;
    }
}
