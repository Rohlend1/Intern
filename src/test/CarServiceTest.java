package test;

import service.CarService;

public class CarServiceTest {
    public static void main(String[] args) {

        CarService carService = new CarService();

        carService.testGetExecutingOrders();
        carService.testGetSortedMechanics();
        carService.testGetSortedOrders();
        carService.testGetFreeSpace();
        carService.testGetOrdersByMechanicId();
    }
}