package org.dz.solution;

import org.dz.solution.task21prep.Car;
import org.dz.solution.task21prep.ColorGenerator;
import org.dz.solution.task21prep.MercedesCarFactory;
import org.junit.Test;


/*
 * 1) Дописать ColorGenerator чтобы он возвращал случайные цвета
 * 2) Создать Фабрики для других брендов
 * 3) Почитать про наследование и интерфейсы и подумать как это можно применить в этом задании
 * */
public class Task21Test {
    @Test
    public void test1() {
        ColorGenerator colorGenerator = new ColorGenerator();
        MercedesCarFactory mercedesCarFactory = new MercedesCarFactory(colorGenerator);
        Car car1 = new Car("BMW", "Black", 10000);
        Car car2 = mercedesCarFactory.getCar("Yellow");
        Car car3 = mercedesCarFactory.getCar();
        Car car4 = new Car("Lada", "Green", 2000);
        Car car5 = new Car("Lada", 3000);

        Car[] array = {car1, car2, car3, car4, car5};
        new Task21().sort(array);
    }
}