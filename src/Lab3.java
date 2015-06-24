
import java.io.*;

/**
 * Lab3 Task 7 Задан файл целых чисел. Если его элементы упорядочены, вывести
 * вторую половину.
 *
 * @author Kostya Nirchenko
 */
public class Lab3 {

    final static String fileName = "C:\\nums.txt";
    private static BufferedReader reader;
    private static StringBuilder sb;
    private static int[] nums;

    /**
     * Считывание данных из файла в строку и запись в целочисленный массив,
     * путем разбиения по пробелу
     *
     * @param fileName String - имя файла
     * @return int[]
     */
    public static int[] readFile(String fileName) {
        try {
            reader = new BufferedReader(new FileReader(new File(fileName)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        sb = new StringBuilder();
        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] forNums = sb.toString().split(" ");
        nums = new int[forNums.length];
        try {
            for (int i = 0; i < forNums.length; i++) {
            nums[i] = Integer.parseInt(forNums[i]);
        }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка чтения файла. Убедитесь что числа в нем целого типа!");
            System.exit(-1);
        }
        
        sb = null;
        forNums = null;
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nums;
    }

    /**
     * Проверка на упорядоченность файла. Если файл упорядочен - возвращает true
     * иначе - возвращает false
     *
     * @return boolean
     */
    public static boolean isSequencedAscending() {
        readFile(fileName);
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }
    
    public static boolean isSequencedDescending() {
        readFile(fileName);
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i + 1] < nums[i]) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        if (isSequencedAscending() || isSequencedDescending()) {
            for (int i = nums.length / 2; i < nums.length; i++) {
                System.out.print(nums[i] + " ");
            }            
        } else {
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i] + " ");
            }
        }
    }

}
