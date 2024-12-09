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

public class HolidayBonus {
    public static final double BONUS_HIGH = 5000.0; // Bonus for highest sales
    public static final double BONUS_LOW = 1000.0;  // Bonus for lowest sales
    public static final double BONUS_OTHER = 2000.0; // Bonus for all other positive sales

    public static double[] calculateHolidayBonus(double[][] sales) {
        double[] bonuses = new double[sales.length];

        int numCategories = 0;
        for (double[] store : sales) {
            numCategories = Math.max(numCategories, store.length);
        }

        for (int col = 0; col < numCategories; col++) {
            int highestIndex = -1;
            int lowestIndex = -1;
            double highestValue = Double.NEGATIVE_INFINITY;
            double lowestValue = Double.POSITIVE_INFINITY;

            // Find highest and lowest valid sales
            for (int row = 0; row < sales.length; row++) {
                if (col < sales[row].length && sales[row][col] > 0) {
                    if (sales[row][col] > highestValue) {
                        highestValue = sales[row][col];
                        highestIndex = row;
                    }
                    if (sales[row][col] < lowestValue) {
                        lowestValue = sales[row][col];
                        lowestIndex = row;
                    }
                }
            }

            // Assign bonuses only for valid sales
            for (int row = 0; row < sales.length; row++) {
                if (col < sales[row].length && sales[row][col] > 0) {
                    if (row == highestIndex) {
                        bonuses[row] += BONUS_HIGH;
                    } else if (row == lowestIndex) {
                        bonuses[row] += BONUS_LOW;
                    } else {
                        bonuses[row] += BONUS_OTHER;
                    }
                }
            }
        }

        return bonuses;
    }


    public static double calculateTotalHolidayBonus(double[][] sales) {
        double[] bonuses = calculateHolidayBonus(sales);
        double totalBonus = 0.0;

        for (double bonus : bonuses) {
            totalBonus += bonus;
        }

        return totalBonus;
    }
}
