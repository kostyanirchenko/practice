
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


abstract class Shapes {
    abstract Shapes create();
    abstract void move();
    abstract void delete() throws Throwable;
}

class Circle extends Shapes {

    @Override
    Circle create() {
        Circle circle = new Circle();
        System.out.println("Объект " + Circle.class.getName() + " был создан");
        return circle;
    }

    @Override
    void move() {
        System.out.println("Объект " + Circle.class.getName() + " был перемещен");
    }

    @Override
    void delete() throws Throwable {
        finalize();
        System.out.println("Объект " + Circle.class.getName() + " был удалён");
    }
    
}

class Square extends Shapes {

    @Override
    Square create() {
        Square square = new Square();
        System.out.println("Объект " + Square.class.getName() + " был создан");
        return square;
    }

    @Override
    void move() {
        System.out.println("Объект " + Square.class.getName() + " был перемещен");
    }

    @Override
    void delete() throws Throwable {
        finalize();
        System.out.println("Объект " + Square.class.getName() + " был удалён");
    }
    
}

class Rectangle extends Shapes {

    @Override
    Rectangle create() {
        Rectangle rectangle = new Rectangle();
        System.out.println("Объект " + Rectangle.class.getName() + " был создан");
        return rectangle;
    }

    @Override
    void move() {
        System.out.println("Объект " + Rectangle.class.getName() + " был перемещен");
    }

    @Override
    void delete() throws Throwable {
        finalize();
        System.out.println("Объект " + Rectangle.class.getName() + " был удалён");
    }
    
}

public class Lab6 {
    public static void main(String[] args) throws IOException {
        Circle circle = new Circle();
        Square square = new Square();
        Rectangle rectangle = new Rectangle();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int j;
        for(;;) {
            for(int i = 0; i < 50; i++) {
                System.out.print("_");
            }
            System.out.println("_");
            System.out.print("Выберите действие \n" +
                    "1 - Создание объекта \n" +
                    "2 - Перемещение объекта \n" +
                    "3 - Удаление объекта \n");
            j = Integer.parseInt(reader.readLine());
            switch(j) {
                case 1:
                    System.out.print("Выберите объект \n" +
                    "1 - Окружность \n" +
                    "2 - Квадрат \n" +
                    "3 - Прямоугольник \n");
                    j = Integer.parseInt(reader.readLine());
                    switch(j) {
                        case 1:
                            circle.create();
                            break;
                        case 2:
                            square.create();
                            break;
                        case 3:
                            rectangle.create();
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Выберите объект \n" +
                    "1 - Окружность \n" +
                    "2 - Квадрат \n" +
                    "3 - Прямоугольник \n");
                    j = Integer.parseInt(reader.readLine());
                    switch(j) {
                        case 1:
                            circle.move();
                            break;
                        case 2:
                            square.move();
                            break;
                        case 3:
                            rectangle.move();
                            break;
                    }
                    break;
                case 3:
                    System.out.print("Выберите объект \n" +
                    "1 - Окружность \n" +
                    "2 - Квадрат \n" +
                    "3 - Прямоугольник \n");
                    j = Integer.parseInt(reader.readLine());
                    switch(j) {
                        case 1:
                            try {
                                circle.delete();
                            } catch(Throwable e) {
                                
                            }                            
                            break;
                        case 2:
                            try {
                                square.delete();
                            } catch(Throwable e) {
                                
                            } 
                            break;
                        case 3:
                            try {
                                rectangle.delete();
                            } catch(Throwable e) {
                                
                            } 
                            break;
                    }
                    break;
            }
        }
    }
}
