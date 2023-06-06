package general;

import entities.Mechanic;
import entities.Order;
import entities.Space;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;


public class CarService {
    private final ServiceOperation serviceOperation;

    public CarService() {
        serviceOperation = new ServiceOperation();
    }

    public boolean addNewGarageSpace(){
        return serviceOperation.addNewGarageSpace();
    }
    public boolean addMechanic(Mechanic mechanic){
        return serviceOperation.addMechanic(mechanic);
    }
    public boolean removeMechanic(Mechanic mechanic){
        return serviceOperation.removeMechanic(mechanic);
    }
    public boolean removeMechanic(int mechanicId){
        return serviceOperation.removeMechanic(mechanicId);
    }
    public boolean addOrder(Order order){
        return serviceOperation.addOrder(order);
    }
    public boolean removeOrder(int orderId){
        return serviceOperation.removeOrder(orderId);
    }
    public boolean removeOrder(Order order){
        return serviceOperation.removeOrder(order);
    }
    public boolean closeOrder(int orderId){
        return serviceOperation.closeOrder(orderId);
    }
    public boolean cancelOrder(int orderId){
        return serviceOperation.cancelOrder(orderId);
    }
    public boolean removeGarageSpace(int spaceId){
        return serviceOperation.removeGarageSpace(spaceId);
    }
    public List<Mechanic> getMechanics(){
        return serviceOperation.getMechanics();
    }
    public void shiftExecutionTime(int orderId, int value, ChronoUnit unit){
        serviceOperation.shiftExecutionTime(orderId,value,unit);
    }
    public List<Order> getOpenOrders(){
        return serviceOperation.getOpenOrders();
    }
    public List<Order> getCancelledOrders(){
        return serviceOperation.getCancelledOrders();
    }
    public List<Space> getGarage(){
        return serviceOperation.getGarage();
    }
    public List<Order> getClosedOrders(){
        return serviceOperation.getClosedOrders();
    }
    public void testAddSpace(){
        System.out.println("Test add space");
        System.out.println("---------------------------------");
        prepareTestEnvironment();
        System.out.println(this.getGarage());
        System.out.println("---------------------------------");
    }

    public void testRemoveSpace(){
        System.out.println("Test remove space");
        prepareTestEnvironment();
        System.out.println("-------------BEFORE:------------");
        System.out.println(this.getGarage());
        this.removeGarageSpace(this.getGarage().get(1).getId());
        System.out.println("-------------AFTER:------------");
        System.out.println(this.getGarage());
        System.out.println("---------------------------------");
    }

    public void testAddMechanic(){
        System.out.println("Test add mechanic");
        System.out.println("---------------------------------");
        prepareTestEnvironment();
        System.out.println(this.getMechanics());
        System.out.println("---------------------------------");
    }

    public void testRemoveMechanic(){
        System.out.println("Test remove mechanic");
        prepareTestEnvironment();
        Mechanic mechanic = new Mechanic(40,"Rick", LocalDate.now());
        this.addMechanic(mechanic);
        System.out.println("-------------BEFORE:------------");
        System.out.println(this.getMechanics());
        this.removeMechanic(mechanic);
        this.removeMechanic(this.getMechanics().get(0).getId());
        System.out.println("-------------AFTER:------------");
        System.out.println(this.getMechanics());
        System.out.println("---------------------------------");
    }

    public void testAddOrder(){
        System.out.println("Test add order");
        prepareTestEnvironment();
        System.out.println(this.getOpenOrders());
        System.out.println("---------------------------------");
    }
    public void testShiftExecutionTime(){
        System.out.println("Test shift execution time");
        System.out.println("---------------------------------");
        prepareTestEnvironment();
        System.out.println(this.getOpenOrders());
        this.shiftExecutionTime(this.getOpenOrders().get(1).getId(),3, ChronoUnit.DAYS);
        System.out.println(this.getOpenOrders());
        System.out.println("---------------------------------");
    }
    public void testCloseOrder(){
        System.out.println("Test close order");
        System.out.println("---------------------------------");
        prepareTestEnvironment();
        this.closeOrder(this.getOpenOrders().get(0).getId());
        System.out.println(this.getOpenOrders());
        System.out.println(this.getClosedOrders());
        System.out.println("---------------------------------");
    }

    public void testCancelOrder(){
        System.out.println("Test cancel order");
        System.out.println("---------------------------------");
        prepareTestEnvironment();
        this.cancelOrder(this.getOpenOrders().get(0).getId());
        System.out.println(this.getCancelledOrders());
        System.out.println(this.getOpenOrders());
        System.out.println("---------------------------------");
    }
    public void testRemoveOrder(){
        System.out.println("Test remove order");
        prepareTestEnvironment();
        Order order = new Order("bbbb");
        this.addOrder(order);
        System.out.println("-------------BEFORE:------------");
        System.out.println(this.getCancelledOrders());
        System.out.println(this.getOpenOrders());
        System.out.println(this.getClosedOrders());
        this.removeOrder(this.getOpenOrders().get(0).getId());
        this.removeOrder(order);
        System.out.println("-------------AFTER:------------");
        System.out.println(this.getCancelledOrders());
        System.out.println(this.getOpenOrders());
        System.out.println(this.getClosedOrders());
        System.out.println("---------------------------------");
    }
    private void prepareTestEnvironment(){
        this.getCancelledOrders().clear();
        this.getClosedOrders().clear();
        this.getGarage().clear();
        this.getMechanics().clear();
        this.getOpenOrders().clear();

        this.addNewGarageSpace();
        this.addNewGarageSpace();
        this.addNewGarageSpace();
        this.addOrder(new Order("456"));
        this.addOrder(new Order("789"));
        this.addOrder(new Order("qwe"));
        this.addOrder(new Order("rty"));
        this.addMechanic(new Mechanic(25,"Alex", LocalDate.now()));
        this.addMechanic(new Mechanic(18,"Bob", LocalDate.now()));
        this.addMechanic(new Mechanic(50,"John", LocalDate.now()));
    }
}
