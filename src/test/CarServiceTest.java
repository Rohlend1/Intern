package test;

import general.CarService;

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

        CarService carService = new CarService();

        carService.testAddSpace();

        carService.testRemoveSpace();

        carService.testAddMechanic();

        carService.testRemoveMechanic();


        carService.testAddOrder();

        carService.testCancelOrder();

        carService.testCloseOrder();

        carService.testRemoveOrder();

        carService.testShiftExecutionTime();

    }

}