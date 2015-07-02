import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author Vitos
 */
public class Lab3_9 {    
    private static final String fileName = "C:\\Lab3_9.txt";//обьявили статичсекую константу с именем файла приватную
    private static BufferedReader fileReader; //Статический екземпляр сканера
    private static StringBuilder stringBuilder;
    private static String [] words; // Создаем строковый масив
    
    public static void readFile(String fileName) {    
        try {        
            fileReader = new BufferedReader(new FileReader(fileName));
        }
        catch(FileNotFoundException e) {            
            e.printStackTrace();            
        }
        stringBuilder = new StringBuilder();
        String line = "";
        try {
            while((line = fileReader.readLine()) != null) {
                stringBuilder.append(line).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] tmp = stringBuilder.toString().split(" ");
        words = new String[tmp.length];        
        for (int i = 0; i < tmp.length; i++) {
            words[i] = tmp[i];
        }       
        tmp = null;
        stringBuilder = null;
        try {
            fileReader.close();
        } catch (Exception e) {
        }
        arraySort(words);
    }
    
    public static void arraySort(String[] array) {
        String st = null;
        //Сравниваем значения массива и сортируем их по функции isGreaterThen
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (isGreaterThen(array[j], array[i])) {
                    st = array[i];
                    array[i] = array[j];
                    array[j] = st;
                }
            }
        }
        for (String lines : array) {
            System.out.println(lines + " ");
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b) {
        return a.compareTo(b) > 0;
    }
    
    public static void main (String [] args) {   
        readFile(fileName);
    }
}
