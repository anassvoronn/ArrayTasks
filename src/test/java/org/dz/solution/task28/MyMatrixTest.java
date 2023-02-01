package org.dz.solution.task28;

import org.junit.Assert;
import org.junit.Test;

public class MyMatrixTest {
    @Test
    public void getLinesNumber() {
        Assert.assertEquals(1,
                new MyMatrix(1, 1).getLinesNumber()
        );

        Assert.assertEquals(4,
                new MyMatrix(4, 8).getLinesNumber()
        );

        Assert.assertEquals(1000000,
                new MyMatrix(1000000, 1).getLinesNumber()
        );

        Assert.assertEquals(1,
                new MyMatrix(1, 1, true).getLinesNumber()
        );

        Assert.assertEquals(4,
                new MyMatrix(4, 8, true).getLinesNumber()
        );

        Assert.assertEquals(1000000,
                new MyMatrix(1000000, 1, true).getLinesNumber()
        );

    }

    @Test
    public void getColumnsNumber() {
        Assert.assertEquals(1,
                new MyMatrix(1, 1).getColumnsNumber()
        );

        Assert.assertEquals(8,
                new MyMatrix(4, 8).getColumnsNumber()
        );

        Assert.assertEquals(1000000,
                new MyMatrix(1, 1000000).getColumnsNumber()
        );

        Assert.assertEquals(1,
                new MyMatrix(1, 1, true).getColumnsNumber()
        );

        Assert.assertEquals(8,
                new MyMatrix(4, 8, true).getColumnsNumber()
        );

        Assert.assertEquals(1000000,
                new MyMatrix(1, 1000000, true).getColumnsNumber()
        );
    }

    @Test
    public void multiplyBy() {
        MyMatrix matrix = new MyMatrix(4, 5);
        matrix.multiplyBy(4);
        Assert.assertEquals(0, matrix.get(2, 3));
        Assert.assertEquals(0, matrix.get(3, 0));
        Assert.assertEquals(0, matrix.get(0, 4));
        Assert.assertEquals(0, matrix.get(0, 0));
        Assert.assertEquals(0, matrix.get(3, 4));
        matrix.fillWith(9);
        matrix.multiplyBy(9);
        Assert.assertEquals(81, matrix.get(2, 3));
        Assert.assertEquals(81, matrix.get(3, 0));
        Assert.assertEquals(81, matrix.get(0, 4));
        Assert.assertEquals(81, matrix.get(0, 0));
        Assert.assertEquals(81, matrix.get(3, 4));
    }

    @Test
    public void get() {
        MyMatrix matrix = new MyMatrix(4, 5);
        Assert.assertEquals(0, matrix.get(2, 3));
        Assert.assertEquals(0, matrix.get(3, 0));
        Assert.assertEquals(0, matrix.get(0, 4));
        Assert.assertEquals(0, matrix.get(0, 0));
        Assert.assertEquals(0, matrix.get(3, 4));
        matrix.fillWith(-1);
        Assert.assertEquals(-1, matrix.get(2, 3));
        Assert.assertEquals(-1, matrix.get(3, 0));
        Assert.assertEquals(-1, matrix.get(0, 4));
        Assert.assertEquals(-1, matrix.get(0, 0));
        Assert.assertEquals(-1, matrix.get(3, 4));
    }

    @Test
    public void checkToString() {
        MyMatrix matrix = new MyMatrix(3, 2);
        matrix.fillWith(100);
        String result = matrix.toString();
        Assert.assertEquals("100 100\n100 100\n100 100", result);
    }

    @Test
    public void transpose() {
        MyMatrix matrix = new MyMatrix(new int[][]{{1, 4}, {8, -1}, {0, 5}});
        matrix.transpose();
        Assert.assertEquals(2, matrix.getLinesNumber());
        Assert.assertEquals(3, matrix.getColumnsNumber());
        Assert.assertEquals("1 8 0\n4 -1 5", matrix.toString());
    }

    @Test
    public void addMatrix(){
        MyMatrix matrix = new MyMatrix(5, 3, true);
        matrix.addMatrix();
    }
}