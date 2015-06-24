import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 *
 * @author Vitos
 */
public class Lab3_9 {
    
    private static final String fileName = "D:\\Lab3_9.txt";//обьявили статичсекую константу с именем файла приватную
    private static Scanner fileReader; //Статический екземпляр сканера
    private static String [] words; // Создаем строковый масив
    
    public static String [] readFile(String fileName){
    
        try{
        
            fileReader = new Scanner(new File(fileName));
        }
        catch(FileNotFoundException e){
            
            e.printStackTrace();
            
        }
        
    return words; // вернет масив строк
    } 
    
    public static void main (String [] args){
    
    
    
    }
}
