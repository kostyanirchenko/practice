
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Класс для работы с текстовыми файлами. Имеет возможность читать указаный файл, проверять на существование
 * указаного пользователем файла, записывать данные в файл и перезаписывать файл при необходимости.
 * @author Kostya Nirchenko
 */
public class FileWorker {
    
    public static File file;
    public static String filename;
    
    /**
     * Чтение указаного пользователем файла. Если файла не существует - создается новый файл, и отправляется
     * на запись. Иначе - выводит содержимое файла на экран.
     * @param filename - имя файла
     * @return String
     */
    public static String read(String filename) {
        file = new File(filename);
        StringBuilder stringBuilder = new StringBuilder();        
        if(!exsists(file)) {
            try {
                file.createNewFile();
                System.out.println("Введите текст для записи");
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "Cp1251"));
                String text = in.readLine();
                write(file, text);                
            } catch(IOException e) {
                System.out.println(e.getMessage().toString());
            }            
        } else {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = "";
                while((line = reader.readLine()) != null) {
                    stringBuilder.append(line).append(" ");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage().toString());
            }
        }
        return stringBuilder.toString();
    }
    
    /**
     * Запись указаного пользователем файла. Вызывается в случае, если указаного файла не было найдено.
     * Смотри {@link #read(java.lang.String)}
     * @param file - файл для записи
     * @param text - текст для записи
     * @throws FileNotFoundException 
     */
    public static void write(File file, String text) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(file);
        try {
            pw.write(text);
            read(filename);
        } catch (Exception ex) {
            
        } finally {
            pw.close();
        }
    }
    
    /**
     * Проверяет, существует ли указаный пользователем файл.
     * @param file - указаный пользователем файл.
     * @return boolean
     */
    public static boolean exsists(File file) {       
        return file.exists();
    }
    
    public static void main(String[] args) throws IOException {
        System.out.println("Укажите имя файла.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        filename = reader.readLine();
        System.out.println(read(filename));
    }
}