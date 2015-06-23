import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lab2 {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static double y;
    private static double x;
    
    public static double setY(double x) {
        y = Math.sin(Math.log(Math.abs(x)) - 1);
        return y;
    }   
       
    public static void main(String[] args) throws IOException {
        System.out.print("Введите х ");
        x = Double.parseDouble(reader.readLine());        
        System.out.printf("Результат расчета: %.2f", setY(x));
    }
}
