/**
 * Lab1 task 2
 * @author Kostya Nirchenko
 */
public class Lab1 {
    final static int a = 5;
    final static int b = 22;
    private static int s;
    private static int p;
    
    public static int calculateS(int a, int b) {
        s = a * b;
        return s;
    }
    
    public static int calculateP(int a, int b) {
        p = 2 * (a + b);
        return p;
    }  
        
    public static void main(String[] args) {
        System.out.println("Площадь прямоугольника: " + calculateS(a, b) + "\n" 
                + "Периметр прямоугольника: " + calculateP(a, b));
    }
    
}
