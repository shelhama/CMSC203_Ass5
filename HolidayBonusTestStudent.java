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

public class HolidayBonusTestStudent {

	  @Test
	    public void testCalculateHolidayBonus() {
	        double[][] dataSet = {
	            {351, 531},   // Store 1
	            {4413, 512, 213},  // Store 2
	            {2144, 121},   // Store 3
	            {212}    // Store 4
	        };

	       
	        double[] expectedBonuses = {
	            2000 + 5000, 
	            5000 + 2000 + 5000, 
	            2000 + 1000, 
	            1000 
	        };

	        double[] actualBonuses = HolidayBonus.calculateHolidayBonus(dataSet);

	        assertArrayEquals("The bonus calculation did not match expected output.", expectedBonuses, actualBonuses, 0.001);
	    }


    @Test
    public void testCalculateTotalHolidayBonus() {
        double[][] sales = {
            {500.0, 200.0, 300.0},
            {400.0, 100.0},
            {600.0, 700.0, 800.0, 100.0}
        };
        double totalBonus = HolidayBonus.calculateTotalHolidayBonus(sales);

        assertEquals(27000.0, totalBonus, 0.001); // Total bonus for all stores
    }

    @Test
    public void testCalculateBonusWithZeroSales() {
        double[][] sales = {
            {0.0, 0.0},
            {0.0},
            {0.0, 0.0, 0.0}
        };
        double[] bonuses = HolidayBonus.calculateHolidayBonus(sales);

        assertEquals(0.0, bonuses[0], 0.001);
        assertEquals(0.0, bonuses[1], 0.001);
        assertEquals(0.0, bonuses[2], 0.001);
    }

   
}



