package task5;

public class Train extends Thread{
    private final String name;
    private final long timeToWait;
    private Tunnel tunnel;
    private boolean isDrove = false;

    public Train(int amountOfWagons, String name,Tunnel tunnel) {
        this.name = name;
        timeToWait = 10L*amountOfWagons;
        this.start();
        this.tunnel = tunnel;
    }

    @Override
    public void run() {

        while(!isDrove){
            try{
                if(tryToDrive()){
                    isDrove = true;
                }
                else{
                    Thread.sleep(1000);
                    if(!tryToDrive()){
                        changeTunnel();
                    }
                }
            }
            catch (InterruptedException ignored){
            }
            finally {
                tunnel.getSemaphore().release();
            }
        }
    }
    private boolean tryToDrive(){
        if(tunnel.getSemaphore().tryAcquire()) {
            return tunnel.drive(timeToWait,this.name);
        }
        else return false;
    }
    private void changeTunnel(){
        System.out.println(name+" train can't drive through the tunnel "+ tunnel.getTunnelId()+", so it changed to another tunnel");
        if(tunnel.equals(TaskFive.getTunnel1()))
            tunnel = TaskFive.getTunnel2();
        else tunnel = TaskFive.getTunnel1();
    }

}

