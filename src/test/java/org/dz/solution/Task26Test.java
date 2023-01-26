package org.dz.solution;

import org.dz.solution.task26.*;
import org.junit.Test;

public class Task26Test {
    @Test
    public void test1() {
        Phone phone1 = new Phone("+375290000000", "Samsung", 186);
        Phone phone2 = new Phone("+375339999999", "Xiaomi", 209);
        Phone phone3 = new Phone("+375291111111", "Apple", 190);

        System.out.println("Phone1 " + phone1.getModel());
        System.out.println("Phone2 " + phone2.getModel());
        System.out.println("Phone3 " + phone3.getModel());

        System.out.println("Phone1 " + phone1.getWeight());
        System.out.println("Phone2 " + phone2.getWeight());
        System.out.println("Phone3 " + phone3.getWeight());

        System.out.println("*Phone1 " + phone1);
        System.out.println("*Phone2 " + phone2);
        System.out.println("*Phone3 " + phone3);

        phone1.receiveCall("Саша");
        phone2.receiveCall("Дима");
        phone3.receiveCall("Оля");

        System.out.println(phone1.getNumber());
        System.out.println(phone2.getNumber());
        System.out.println(phone3.getNumber());

        phone1.receiveCall("+375290000000", "Катя");
        phone2.receiveCall("+375339999999","Вика");
        phone3.receiveCall("+375291111111" ,"Коля");

        Phone phone4 = new Phone("+375297777777", "Xia");
        System.out.println("Phone4 " + phone4);
        Phone phone5 = new Phone();
        System.out.println("Phone5 " + phone5);

        phone5.sendMessage("+375339999999", "+375293333333", "+375291111111");
    }
}