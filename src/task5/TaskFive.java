package task5;

public class TaskFive {

    private static final Tunnel tunnel1 = new Tunnel();
    private static final Tunnel tunnel2 = new Tunnel();

    public static void main(String[] args) {
        Train train1 = new Train(10,"A",tunnel1);
        Train train2 = new Train(20,"B",tunnel1);
        Train train3 = new Train(30,"C",tunnel2);
        Train train4 = new Train(25,"D",tunnel2);
        Train train5 = new Train(18,"F",tunnel2);
    }
    public static Tunnel getTunnel1(){
        return tunnel1;
    }
    public static Tunnel getTunnel2(){
        return tunnel2;
    }
}

