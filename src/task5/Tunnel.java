package task5;

import java.util.concurrent.Semaphore;

public class Tunnel{
    private static int counter = 0;
    private final int id = ++counter;
    private final Semaphore semaphore = new Semaphore(1);

    public boolean drive(long time,String trainName){
        try{
            System.out.println(trainName+" train is driving through the tunnel "+id);
            Thread.sleep(time);
        }
        catch (InterruptedException ignored){

        }
        return true;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tunnel tunnel = (Tunnel) o;

        if (id != tunnel.id) return false;
        return semaphore.equals(tunnel.semaphore);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + semaphore.hashCode();
        return result;
    }

    public int getTunnelId() {
        return id;
    }
}
