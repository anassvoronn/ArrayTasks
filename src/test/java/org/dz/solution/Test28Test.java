package org.dz.solution;

import org.dz.solution.task28.MyMatrix;
import org.junit.Test;

public class Test28Test {

    @Test
    public void test(){
        MyMatrix matrix1 = new MyMatrix(6, 15);
        MyMatrix matrix2 = new MyMatrix(8, 2);

        MyMatrix matrix3 = new MyMatrix(7, 9, true);
        MyMatrix matrix4 = new MyMatrix(5, 7, false);
        MyMatrix matrix5 = new MyMatrix(5, 7, true);

        matrix5.multiplyBy(6);

        matrix3.printMatrix();
        matrix3.transpose();
        System.out.println();
        matrix3.printMatrix();

        matrix4.transpose();
        matrix4.printMatrix();
    }
}