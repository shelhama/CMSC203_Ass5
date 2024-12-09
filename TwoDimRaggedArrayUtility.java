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

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoDimRaggedArrayUtility {
    public static double[][] readFile(File file) throws IOException {
        List<double[]> rows = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(" ");
                double[] row = Arrays.stream(line)
                                     .mapToDouble(Double::parseDouble)
                                     .toArray();
                rows.add(row);
            }
        }
        return rows.toArray(new double[0][]);
    }

    public static void writeToFile(double[][] array, File file) throws IOException {
        try (PrintWriter writer = new PrintWriter(file)) {
            for (double[] row : array) {
                writer.println(Arrays.stream(row)
                                     .mapToObj(Double::toString)
                                     .collect(Collectors.joining(" ")));
            }
        }
    }

    public static double getTotal(double[][] array) {
        return Arrays.stream(array)
                     .flatMapToDouble(Arrays::stream)
                     .sum();
    }

    public static double getAverage(double[][] array) {
        return getTotal(array) / Arrays.stream(array)
                                       .mapToInt(row -> row.length)
                                       .sum();
    }

    public static double getRowTotal(double[][] array, int rowIndex) {
        return Arrays.stream(array[rowIndex]).sum();
    }

    public static double getColumnTotal(double[][] array, int colIndex) {
        return Arrays.stream(array)
                     .filter(row -> row.length > colIndex)
                     .mapToDouble(row -> row[colIndex])
                     .sum();
    }

    public static double getHighestInRow(double[][] array, int rowIndex) {
        return Arrays.stream(array[rowIndex]).max().orElse(Double.NaN);
    }

    public static int getHighestInRowIndex(double[][] array, int rowIndex) {
        return IntStream.range(0, array[rowIndex].length)
                        .reduce((i, j) -> array[rowIndex][i] > array[rowIndex][j] ? i : j)
                        .orElse(-1);
    }

    public static double getLowestInRow(double[][] array, int rowIndex) {
        return Arrays.stream(array[rowIndex]).min().orElse(Double.NaN);
    }

    public static int getLowestInRowIndex(double[][] array, int rowIndex) {
        return IntStream.range(0, array[rowIndex].length)
                        .reduce((i, j) -> array[rowIndex][i] < array[rowIndex][j] ? i : j)
                        .orElse(-1);
    }

    public static double getHighestInColumn(double[][] array, int colIndex) {
        return Arrays.stream(array)
                     .filter(row -> row.length > colIndex)
                     .mapToDouble(row -> row[colIndex])
                     .max()
                     .orElse(Double.NaN);
    }

    public static int getHighestInColumnIndex(double[][] array, int colIndex) {
        return IntStream.range(0, array.length)
                        .filter(i -> array[i].length > colIndex)
                        .reduce((i, j) -> array[i][colIndex] > array[j][colIndex] ? i : j)
                        .orElse(-1);
    }

    public static double getLowestInColumn(double[][] array, int colIndex) {
        return Arrays.stream(array)
                     .filter(row -> row.length > colIndex)
                     .mapToDouble(row -> row[colIndex])
                     .min()
                     .orElse(Double.NaN);
    }

    public static int getLowestInColumnIndex(double[][] array, int colIndex) {
        return IntStream.range(0, array.length)
                        .filter(i -> array[i].length > colIndex)
                        .reduce((i, j) -> array[i][colIndex] < array[j][colIndex] ? i : j)
                        .orElse(-1);
    }

    public static double getHighestInArray(double[][] array) {
        return Arrays.stream(array)
                     .flatMapToDouble(Arrays::stream)
                     .max()
                     .orElse(Double.NaN);
    }

    public static double getLowestInArray(double[][] array) {
        return Arrays.stream(array)
                     .flatMapToDouble(Arrays::stream)
                     .min()
                     .orElse(Double.NaN);
    }

	public static int getLargestNumberOfColumns(double[][] sales) {
		// TODO Auto-generated method stub
		return 0;
	}
}
