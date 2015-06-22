/**
 * Lab1 task 2
 * @author Kostya Nirchenko
 */
public class Lab1 {
    private static int a = 5;
    private static int b = 22;
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
        System.out.println("Площадь прямоугольника: " + calculateS(getA(), getB()) + "\n" 
                + "Периметр прямоугольника: " + calculateP(getA(), getB()));
    }

    /**
     * @return the a
     */
    public static int getA() {
        return a;
    }

    /**
     * @param aA the a to set
     */
    public static void setA(int aA) {
        a = aA;
    }

    /**
     * @return the b
     */
    public static int getB() {
        return b;
    }

    /**
     * @param aB the b to set
     */
    public static void setB(int aB) {
        b = aB;
    }
    
}
