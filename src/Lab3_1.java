
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Lab3 Task 14
 * В файле задан двумерный массив. Найти сумму элементов того рядка, 
 * в котором расположен максимальный элемент. 
 * @author Nirchenko Kostya
 */
public class Lab3_1 {
    final static String fileName = "C:\\newFile.txt";
    private static Scanner fileReader;
    private static int[][] nums = new int[4][4];
    
    public static void readFile(String fileName) {
        try {
            fileReader = new Scanner(new File(fileName));
            try {
                for (int i = 0; i < nums.length; i++) {
                    for (int j = 0; j < nums.length; j++) {
                        nums[i][j] = fileReader.nextInt();
                    }
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Ошибка чтения чисел из файла.");
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        searchMax(nums);
    }
    
    public static void searchMax(int [][] arr) {
        int max = arr[0][0];
        int row = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i][j] > max) {
                    max = arr[i][j];
                    row = i + 1;
                }
            }
        }
//        System.out.println(max + " in " + row);
        calculateSum(arr, row);
    }
    
    public static void calculateSum(int [][] arr, int row) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[row - 1][i];
        }
        System.out.println(sum);
    }
    
    public static void main(String[] args) {
        readFile(fileName);
    }
    
}
