package general;

import entities.Mechanic;
import entities.Order;
import entities.Space;
import errors.MechanicNotFoundException;
import errors.OrderNotFoundException;
import errors.SpaceNotFoundException;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServiceOperation {

    private final List<Mechanic> mechanics;
    private final List<Order> openOrders;
    private final List<Order> closedOrders;
    private final List<Order> cancelledOrders;
    private final List<Space> garage;

    public ServiceOperation() {
        mechanics = new ArrayList<>();
        closedOrders = new ArrayList<>();
        openOrders = new ArrayList<>();
        cancelledOrders = new ArrayList<>();
        garage = new ArrayList<>();
    }

    public boolean addMechanic(Mechanic mechanic){
        return mechanics.add(mechanic);
    }
    public boolean removeMechanic(Mechanic mechanic){
        return mechanics.remove(mechanic);
    }
    public boolean removeMechanic(int mechanicId){
        return mechanics.remove(findMechanicById(mechanicId));
    }

    public boolean addNewGarageSpace(){
        return garage.add(new Space());
    }
    public boolean removeGarageSpace(int spaceId){
        return garage.remove(findSpaceById(spaceId));
    }

    private Space findSpaceById(int spaceId){
        for(Space space : garage){
            if(space.getId() == spaceId) {
                return space;
            }
        }
        throw new SpaceNotFoundException();
    }
    private Mechanic findMechanicById(int mechanicId){
        for(Mechanic mechanic : mechanics){
            if(mechanic.getId() == mechanicId) {
                return mechanic;
            }
        }
        throw new MechanicNotFoundException();
    }

    public boolean addOrder(Order order){
        order.setSpaceId(garage.get(new Random().nextInt(1,garage.size())).getId());
        return openOrders.add(order);
    }
    public boolean removeOrder(int orderId){
        return openOrders.remove(findOrderById(orderId));
    }
    public boolean removeOrder(Order order){
        return openOrders.remove(order);
    }
    public boolean closeOrder(int orderId){
        Order foundOrder = findOrderById(orderId);
        foundOrder.setClosed(true);
        openOrders.remove(foundOrder);
        return closedOrders.add(foundOrder);
    }

    public boolean cancelOrder(int orderId){
        Order foundOrder = findOrderById(orderId);
        foundOrder.setCancelled(true);
        openOrders.remove(foundOrder);
        return cancelledOrders.add(foundOrder);
    }

    private Order findOrderById(int orderId){
        for(Order order : openOrders){
            if(order.getId() == orderId){
                return order;
            }
        }
        throw new OrderNotFoundException();
    }

    public void shiftExecutionTime(int orderId, int value, ChronoUnit unit){
        Order foundOrder = findOrderById(orderId);
        openOrders.stream().filter(order -> foundOrder.getSpaceId() == order.getSpaceId())
                .forEach(order -> order.setWillBeReadyBy(order.getWillBeReadyBy().plus(value,unit)));
    }

    public List<Mechanic> getMechanics() {
        return mechanics;
    }

    public List<Order> getOpenOrders() {
        return openOrders;
    }

    public List<Order> getClosedOrders() {
        return closedOrders;
    }

    public List<Order> getCancelledOrders() {
        return cancelledOrders;
    }

    public List<Space> getGarage() {
        return garage;
    }
}
