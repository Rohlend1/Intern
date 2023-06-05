package test;

import entities.Mechanic;
import entities.Order;
import general.CarService;

import java.time.temporal.ChronoUnit;
import java.util.Date;

//Первое задание: 1. Написать программу:
//Электронный администратор автосервиса
//Программа должна предоставлять возможность:
//▪ Добавить/удалить мастера
//▪ Добавить/удалить место в гараже
//▪ Добавить/удалить/закрыть/отменить/ заказ
//▪ Сместить время выполнения заказов (из-за задержек в выполнении текущего)
//
//требование к выполнению:
//1) К программе НЕ реализовывать консольный пользовательский интерфейс.
//Работоспособность программы проверять из тестового класса с методом main
//2) К программе должна быть создана диаграмма классов
//3) Программа должна соответствовать принципам ООП и паттернам «Сильное
//сцепление» и «Слабая связанность»
//4) Для вывода результатов работы использовать System.out.println(message)
public class CarServiceTest {
    public static void main(String[] args) {

        testAddSpace();

        testRemoveSpace();

        testAddMechanic();

        testRemoveMechanic();


        testAddOrder();

        testCancelOrder();

        testCloseOrder();

        testRemoveOrder();

        testShiftExecutionTime();


    }

    private static void testAddSpace(){
        System.out.println("Test add space");
        System.out.println("---------------------------------");
        prepareTestEnvironment();
        System.out.println(CarService.getGarage());
        System.out.println("---------------------------------");
    }

    private static void testRemoveSpace(){
        System.out.println("Test remove space");
        prepareTestEnvironment();
        System.out.println("-------------BEFORE:------------");
        System.out.println(CarService.getGarage());
        CarService.removeGarageSpace(CarService.getGarage().get(1).getId());
        System.out.println("-------------AFTER:------------");
        System.out.println(CarService.getGarage());
        System.out.println("---------------------------------");
    }

    private static void testAddMechanic(){
        System.out.println("Test add mechanic");
        System.out.println("---------------------------------");
        prepareTestEnvironment();
        System.out.println(CarService.getMechanics());
        System.out.println("---------------------------------");
    }

    private static void testRemoveMechanic(){
        System.out.println("Test remove mechanic");
        prepareTestEnvironment();
        Mechanic mechanic = new Mechanic(40,"Rick",new Date());
        CarService.addMechanic(mechanic);
        System.out.println("-------------BEFORE:------------");
        System.out.println(CarService.getMechanics());
        CarService.removeMechanic(mechanic);
        CarService.removeMechanic(CarService.getMechanics().get(0).getId());
        System.out.println("-------------AFTER:------------");
        System.out.println(CarService.getMechanics());
        System.out.println("---------------------------------");
    }

    private static void testAddOrder(){
        System.out.println("Test add order");
        prepareTestEnvironment();
        System.out.println(CarService.getOpenOrders());
        System.out.println("---------------------------------");
    }
    private static void testShiftExecutionTime(){
        System.out.println("Test shift execution time");
        System.out.println("---------------------------------");
        prepareTestEnvironment();
        System.out.println(CarService.getOpenOrders());
        CarService.shiftExecutionTime(CarService.getOpenOrders().get(1).getId(),3, ChronoUnit.DAYS);
        System.out.println(CarService.getOpenOrders());
        System.out.println("---------------------------------");
    }
    private static void testCloseOrder(){
        System.out.println("Test close order");
        System.out.println("---------------------------------");
        prepareTestEnvironment();
        CarService.closeOrder(CarService.getOpenOrders().get(0).getId());
        System.out.println(CarService.getOpenOrders());
        System.out.println(CarService.getClosedOrders());
        System.out.println("---------------------------------");
    }

    private static void testCancelOrder(){
        System.out.println("Test cancel order");
        System.out.println("---------------------------------");
        prepareTestEnvironment();
        CarService.cancelOrder(CarService.getOpenOrders().get(0).getId());
        System.out.println(CarService.getCancelledOrders());
        System.out.println(CarService.getOpenOrders());
        System.out.println("---------------------------------");
    }
    private static void testRemoveOrder(){
        System.out.println("Test remove order");
        prepareTestEnvironment();
        Order order = new Order("bbbb");
        CarService.addOrder(order);
        System.out.println("-------------BEFORE:------------");
        System.out.println(CarService.getCancelledOrders());
        System.out.println(CarService.getOpenOrders());
        System.out.println(CarService.getClosedOrders());
        CarService.removeOrder(CarService.getOpenOrders().get(0).getId());
        CarService.removeOrder(order);
        System.out.println("-------------AFTER:------------");
        System.out.println(CarService.getCancelledOrders());
        System.out.println(CarService.getOpenOrders());
        System.out.println(CarService.getClosedOrders());
        System.out.println("---------------------------------");
    }
    private static void prepareTestEnvironment(){
        CarService.getCancelledOrders().clear();
        CarService.getClosedOrders().clear();
        CarService.getGarage().clear();
        CarService.getMechanics().clear();
        CarService.getOpenOrders().clear();

        CarService.addNewGarageSpace();
        CarService.addNewGarageSpace();
        CarService.addNewGarageSpace();
        CarService.addOrder(new Order("456"));
        CarService.addOrder(new Order("789"));
        CarService.addOrder(new Order("qwe"));
        CarService.addOrder(new Order("rty"));
        CarService.addMechanic(new Mechanic(25,"Alex", new Date()));
        CarService.addMechanic(new Mechanic(18,"Bob", new Date()));
        CarService.addMechanic(new Mechanic(50,"John", new Date()));
    }
}