package task3;

import java.util.ArrayList;
import java.util.List;

public class TaskThree {

    private static final List<Operator> operators = new ArrayList<>();

    public static void main(String[] args) {

        Operator operator1 = new Operator("Tom");
        Operator operator2 = new Operator("Bob");

        operators.add(operator1);
        operators.add(operator2);

        Client client1 = new Client("John");
        Client client2 = new Client("Alex");
        Client client3 = new Client("Ivan");
        Client client4 = new Client("Cole");
        Client client5 = new Client("Miley");
        Client client6 = new Client("Rihanna");
        Client client7 = new Client("Adele");
        Client client8 = new Client("Lana");
        Client client9 = new Client("Rick");

        client1.setOp(operators.get(0));
        client2.setOp(operators.get(0));
        client3.setOp(operators.get(0));
        client4.setOp(operators.get(0));
        client5.setOp(operators.get(0));
        client6.setOp(operators.get(1));
        client7.setOp(operators.get(1));
        client8.setOp(operators.get(1));
        client9.setOp(operators.get(1));

        client1.start();
        client2.start();
        client3.start();
        client4.start();
        client5.start();
        client6.start();
        client7.start();
        client8.start();
        client9.start();
    }

}

