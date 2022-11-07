package org.dz.solution;

import org.dz.solution.task21prep.Car;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task21Test {
    @Test
    public void test1(){
       Car car1 = new Car("BMW", "Black", 10000);
       Car car2 = new Car("Mercedes", "Yellow", 12000);
       Car car3 = new Car("Mercedes", "Green", 12000);
       Car car4 = new Car("Lada", "Green", 2000);
       Car car5 = new Car("Lada", 3000);

       Car[] array = {car1, car2, car3, car4, car5};
       new Task21().sort(array);
    }
}