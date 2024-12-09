/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Samuella Helha________
*/
package shelhama_Ass5;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;

public class TwoDimRaggedArrayUtilityTestStudent {

    @Test
    public void testGetTotal() {
        double[][] sales = {{1.0, 2.0}, {3.0}, {4.0, 5.0}};
        assertEquals(15.0, TwoDimRaggedArrayUtility.getTotal(sales), 0.001);
    }

    @Test
    public void testGetAverage() {
        double[][] sales = {{1.0, 2.0}, {3.0}, {4.0, 5.0}};
        assertEquals(3.0, TwoDimRaggedArrayUtility.getAverage(sales), 0.001);
    }

    @Test
    public void testGetRowTotal() {
        double[][] sales = {{1.0, 2.0}, {3.0}, {4.0, 5.0}};
        assertEquals(3.0, TwoDimRaggedArrayUtility.getRowTotal(sales, 0), 0.001);
        assertEquals(3.0, TwoDimRaggedArrayUtility.getRowTotal(sales, 1), 0.001);
    }

    @Test
    public void testGetColumnTotal() {
        double[][] sales = {{1.0, 2.0}, {3.0}, {4.0, 5.0}};
        assertEquals(8.0, TwoDimRaggedArrayUtility.getColumnTotal(sales, 0), 0.001);
        assertEquals(7.0, TwoDimRaggedArrayUtility.getColumnTotal(sales, 1), 0.001);
    }

    @Test
    public void testGetHighestInRow() {
        double[][] sales = {{1.0, 2.0}, {3.0}, {4.0, 5.0}};
        assertEquals(2.0, TwoDimRaggedArrayUtility.getHighestInRow(sales, 0), 0.001);
        assertEquals(5.0, TwoDimRaggedArrayUtility.getHighestInRow(sales, 2), 0.001);
    }

    @Test
    public void testGetHighestInRowIndex() {
        double[][] sales = {{1.0, 2.0}, {3.0}, {4.0, 5.0}};
        assertEquals(1, TwoDimRaggedArrayUtility.getHighestInRowIndex(sales, 0));
        assertEquals(1, TwoDimRaggedArrayUtility.getHighestInRowIndex(sales, 2));
    }

    @Test
    public void testGetLowestInRow() {
        double[][] sales = {{1.0, 2.0}, {3.0}, {4.0, 5.0}};
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInRow(sales, 0), 0.001);
        assertEquals(4.0, TwoDimRaggedArrayUtility.getLowestInRow(sales, 2), 0.001);
    }

    @Test
    public void testGetLowestInRowIndex() {
        double[][] sales = {{1.0, 2.0}, {3.0}, {4.0, 5.0}};
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(sales, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(sales, 2));
    }

    @Test
    public void testFileReadWrite() throws IOException {
        double[][] sales = {{1.0, 2.0}, {3.0}, {4.0, 5.0}};
        File file = new File("test_sales.txt");
        TwoDimRaggedArrayUtility.writeToFile(sales, file);

        double[][] readSales = TwoDimRaggedArrayUtility.readFile(file);
        assertEquals(1.0, readSales[0][0], 0.001);
        assertEquals(5.0, readSales[2][1], 0.001);

        // Clean up
        file.delete();
    }

    @Test
    public void testGetHighestInArray() {
        double[][] sales = {{1.0, 2.0}, {3.0}, {4.0, 5.0}};
        assertEquals(5.0, TwoDimRaggedArrayUtility.getHighestInArray(sales), 0.001);
    }

    @Test
    public void testGetLowestInArray() {
        double[][] sales = {{1.0, 2.0}, {3.0}, {4.0, 5.0}};
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(sales), 0.001);
    }
}

