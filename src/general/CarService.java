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


public class CarService {
    private static final List<Mechanic> mechanics = new ArrayList<>();
    private static final List<Order> openOrders = new ArrayList<>();
    private static final List<Order> cancelledOrders = new ArrayList<>();
    private static final List<Order> closedOrders = new ArrayList<>();
    private static final List<Space> garage = new ArrayList<>();
    public static boolean addMechanic(Mechanic mechanic){
        return mechanics.add(mechanic);
    }
     public static boolean removeMechanic(Mechanic mechanic){
        return mechanics.remove(mechanic);
    }
    public static boolean removeMechanic(int mechanicId){
        return mechanics.remove(findMechanicById(mechanicId));
    }

    public static boolean addNewGarageSpace(){
        return garage.add(new Space());
    }
    public static boolean removeGarageSpace(int spaceId){
        return garage.remove(findSpaceById(spaceId));
    }

    private static Space findSpaceById(int spaceId){
        for(Space space : garage){
            if(space.getId() == spaceId) {
                return space;
            }
        }
        throw new SpaceNotFoundException();
    }
    private static Mechanic findMechanicById(int mechanicId){
        for(Mechanic mechanic : mechanics){
            if(mechanic.getId() == mechanicId) {
                return mechanic;
            }
        }
        throw new MechanicNotFoundException();
    }

    public static boolean addOrder(Order order){
        order.setSpaceId(garage.get(new Random().nextInt(1,garage.size())).getId());
        return openOrders.add(order);
    }
    public static boolean removeOrder(int orderId){
        return openOrders.remove(findOrderById(orderId));
    }
    public static boolean removeOrder(Order order){
        return openOrders.remove(order);
    }
    public static boolean closeOrder(int orderId){
        Order foundOrder = findOrderById(orderId);
        foundOrder.setClosed(true);
        openOrders.remove(foundOrder);
        return closedOrders.add(foundOrder);
    }

    public static boolean cancelOrder(int orderId){
        Order foundOrder = findOrderById(orderId);
        foundOrder.setCancelled(true);
        openOrders.remove(foundOrder);
        return cancelledOrders.add(foundOrder);
    }

    private static Order findOrderById(int orderId){
        for(Order order : openOrders){
            if(order.getId() == orderId){
                return order;
            }
        }
        throw new OrderNotFoundException();
    }

    public static void shiftExecutionTime(int orderId, int value, ChronoUnit unit){
        Order foundOrder = findOrderById(orderId);
        openOrders.stream().filter(order -> foundOrder.getSpaceId() == order.getSpaceId())
                .forEach(order -> order.setWillBeReadyBy(order.getWillBeReadyBy().plus(value,unit)));
    }
    public static List<Mechanic> getMechanics(){
        return mechanics;
    }
    public static List<Order> getOpenOrders(){
        return openOrders;
    }
    public static List<Order> getCancelledOrders(){
        return cancelledOrders;
    }
    public static List<Space> getGarage(){
        return garage;
    }
    public static List<Order> getClosedOrders(){
        return closedOrders;
    }
}
