package org.dz.solution;

import org.dz.solution.task21prep.*;
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
        BMWCarFactory bmwCarFactory = new BMWCarFactory(colorGenerator);
        LadaCarFactory ladaCarFactory = new LadaCarFactory(colorGenerator);
        Car car1 = bmwCarFactory.getCar();
        Car car2 = mercedesCarFactory.getCar();
        Car car3 = ladaCarFactory.getCar();
        Car car4 = mercedesCarFactory.getCar();
        Car car5 = bmwCarFactory.getCar();

        Car[] array = {car1, car2, car3, car4, car5};
        new Task21().sort(array);
    }
}