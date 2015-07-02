
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


/**
 * Lab4 Task 3
 * Построить систему классов для описания плоских геометрических фигур: круга, квадрата, прямоугольника.
 * Предусмотреть методы для создания объектов, перемещения на плоскости, изменения размеров и вращения на заданный угол.
 * Написать программу, демонстрирующую работу с этими классами. Программа должна содержать меню, позволяющее осуществить
 * проверку всех методов классов.
 * @author Студент
 */
public class Lab4 {
    private double x;
    private double y;
    private double angle;
    
    public void setAngle(double angle) {
        this.angle = angle;
    }
    
    public double getAngle() {
        return angle;
    }
    
    public void resize(double a, double b) {
        this.x = a;
        this.y = b;
    }
    
    public void move(double a, double b) {
        this.x += a;
        this.y += b;
    }
    
    public void rotation(double angle) {
        double x1 = (this.x * Math.cos(angle)) - (this.y * Math.sin(angle));
        double y1 = (this.x * Math.sin(angle)) + (this.y * Math.cos(angle));
    }
    
    public double calculateDistance(double a, double b, Lab4 p) {
        double distance = Math.sqrt(Math.pow((p.x - a), 2) + Math.pow((p.y - b), 2));
        return distance;
    }
    
    static class Circle extends Lab4 {
        private double radius;
        double center;
        public Circle(double a, double b) {
            this.radius = a;
            this.center = b;
        }
        
        public double getRadius() {
            return radius;
        }
        
        public double getCenter() {
            return center;
        }
        
        public void move(double a, double b, Lab4 p) {
            center += calculateDistance(a, b, p);
        }
        
        public void resize(double a, double b) {
            this.radius += a;
            this.center += b;
        }
        
        @Override
        public void rotation(double angle) {
            
        }
    }
    
    static class Square extends Lab4 {
        double a, b;
        public Square(double a, double b) {
            this.a = a;
            this.b = b;
        }       
        
        public void move(double a, double b, Lab4 p) {
            this.a += calculateDistance(a, b, p);
            this.b += calculateDistance(a, b, p);
        }
        
        public double getA() {
            return a;
        }
        
        public double getB() {
            return b;
        }
        
        @Override
        public void resize(double a, double b) {
            this.a += a;
            this.b += b;
        }
        
        @Override
        public void rotation(double angle) {
            double a1 = (this.a * Math.cos(angle)) - (this.b * Math.sin(angle));
            double b1 = (this.a * Math.sin(angle)) + (this.b * Math.cos(angle));
        }
    }
    
    static class Rectangle extends Lab4 {
        double a, b;
        public Rectangle(double a, double b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public void move(double a, double b) {
            
        }
        
        @Override
        public void resize(double a, double b) {
            this.a += a;
            this.b += b;
        }
        
        @Override
        public void rotation(double angle) {
            double a1 = (this.a * Math.cos(angle)) - (this.b * Math.sin(angle));
            double b1 = (this.a * Math.sin(angle)) + (this.b * Math.cos(angle));
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(;;) {
            for(int i = 0; i < 50; i++) {
                System.out.println("____________________");
            }
            System.out.println("Выберите действие");
            int action = Integer.parseInt(reader.readLine());
            Scanner in = new Scanner(System.in);
            int j;
            switch(action) {                
                case 1: System.out.println("Создать объект: 1 - окружность, 2 - квадрат, 3 - прямоугольник");
                    j = in.nextInt();
                    switch(j) {
                        case 1: Circle circle = new Circle(in.nextDouble(), in.nextDouble());
                            System.out.println("Создана окружность с радиусом " + circle.getRadius() + " и центром " + circle.getCenter());
                            break;
                        case 2: Square square = new Square(in.nextDouble(), in.nextDouble());
                            System.out.println("Создана окружность с радиусом " + square.getA() + " и центром " + square.getB());
                            break;
                    }
                break;
            }
        }
    }
}