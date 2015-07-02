
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Lab4 Task 3 Построить систему классов для описания плоских геометрических
 * фигур: круга, квадрата, прямоугольника. Предусмотреть методы для создания
 * объектов, перемещения на плоскости, изменения размеров и вращения на заданный
 * угол. Написать программу, демонстрирующую работу с этими классами. Программа
 * должна содержать меню, позволяющее осуществить проверку всех методов классов.
 *
 * @author Kostya Nirchenko
 */
public class Lab4 {

    private double x;
    private double y;
    private double angle;

    public Lab4() {
//        this.x = x;
//        this.y = y;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getAngle() {
        return angle;
    }

    /**
     * Устанавливает новые координаты объекта
     *
     * @param a - абсиса
     * @param b - ордината
     */
    public void resize(double a, double b) {
        this.x += a;
        this.y += b;
    }

    /**
     * Перемещает объект на указаные координаты
     *
     * @param a - абсиса
     * @param b - ордината
     */
    public void move(double a, double b) {
        this.x += calculateDistance(a, b, this);
        this.y += calculateDistance(a, b, this);
    }

    public void rotation(double angle) {
        double x1 = (this.x * Math.cos(angle)) - (this.y * Math.sin(angle));
        double y1 = (this.x * Math.sin(angle)) + (this.y * Math.cos(angle));
    }

    /**
     * Расчитывает дистанцию, на которую необходимо переместить объект
     *
     * @param a - абсиса
     * @param b - ордината
     * @param p - экземпляр класса {@link Lab4}
     * @return double
     */
    public double calculateDistance(double a, double b, Lab4 p) {
        double distance = Math.sqrt(Math.pow((p.x - a), 2) + Math.pow((p.y - b), 2));
        return distance;
    }

    /**
     * Выводит информацию об объекте (его координаты)
     *
     * @return String
     */
    public String getInfo() {
        String info = "x = " + this.x + " y = " + this.y + "\n";
        return info;
    }

    static class Circle extends Lab4 {

        double radius;
        double center;

        Circle(double a, double b) {
            this.radius = a;
            this.center = b;
        }

        public double getRadius() {
            return radius;
        }

        public double getCenter() {
            return center;
        }

        /**
         * Перемещает центр окружности на указаную координату
         *
         * @param a - абсиса
         * @param b - ордината
         * @param p - экземпляр класса {@link Lab4}
         */
        public void move(double a, double b, Lab4 p) {
            center += calculateDistance(a, b, p);
        }

        /**
         * Задает новый радиус окружности
         *
         * @param a - новое значение радиуса окружности
         */
        public void resize(double a) {
            this.radius += a;
        }

        /**
         * Поворачивает окружность на заданый угол
         *
         * @param angle - угол, на который необходимо повернуть окружность
         */
        @Override
        public void rotation(double angle) {
            setAngle(angle);
            this.center = (this.center * Math.cos(angle)) - (this.center * Math.sin(angle));
        }

        /**
         * Возвращает информацию об окружности (её радиус и координаты центра)
         *
         * @return String
         */
        @Override
        public String getInfo() {
            String info = "Радиус = " + this.radius + " центр = " + this.center + "\n";
            return info;
        }
    }

    static class Square extends Lab4 {

        double a, b;

        Square(double a, double b) {
            this.a = a;
            this.b = b;
        }

        public void setA(double a) {
            this.a = a;
        }

        public void setB(double b) {
            this.b = b;
        }

        /**
         * Перемещает квадрат на заданые координаты
         *
         * @param a - абсиса
         * @param b - ордината
         * @param p - экземпляр класса {@link Lab4}
         */
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

        /**
         * Изменяет размены квадрата на указаные
         *
         * @param a - абсиса
         * @param b - ордината
         */
        @Override
        public void resize(double a, double b) {
            this.a += a;
            this.b += b;
        }

        /**
         * Поворачивает квадрат на указаный угол
         *
         * @param angle - угол
         */
        @Override
        public void rotation(double angle) {
            setAngle(angle);
            this.a = (this.a * Math.cos(angle)) - (this.b * Math.sin(angle));
            this.b = (this.a * Math.sin(angle)) + (this.b * Math.cos(angle));
        }

        /**
         * Возвращает информацию о квадрате (координаты его сторон)
         *
         * @return String
         */
        @Override
        public String getInfo() {
            String info = "a = " + getA() + " b = " + getB() + "\n";
            return info;
        }
    }

    static class Rectangle extends Lab4 {

        double a, b;

        Rectangle(double a, double b) {
            this.a = a;
            this.b = b;
        }

        /**
         * Перемещает прямоугольник на указаные координаты
         *
         * @param a - абсиса
         * @param b - ордината
         * @param p - экземпляр класса {@link Lab4}
         */
        public void move(double a, double b, Lab4 p) {
            a += calculateDistance(a, b, p);
            b += calculateDistance(a, b, p);
        }

        /**
         * Изменяет стороны прямоугольника на указаные
         *
         * @param a - сторона а
         * @param b - сторона b
         */
        @Override
        public void resize(double a, double b) {
            this.a += a;
            this.b += b;
        }

        /**
         * Поворачивает прямоугольник на заданый угол
         *
         * @param angle - угол
         */
        @Override
        public void rotation(double angle) {
            setAngle(angle);
            this.a = (this.a * Math.cos(angle)) - (this.b * Math.sin(angle));
            this.b = (this.a * Math.sin(angle)) + (this.b * Math.cos(angle));
        }

        @Override
        public String getInfo() {
            String info = "a = " + this.a + " b = " + this.b + "\n";
            return info;
        }
    }

    public static void main(String[] args) throws IOException {
        Circle circle = new Circle(0.0, 0.0);
        Square square = new Square(0.0, 0.0);
        Rectangle rectangle = new Rectangle(0.0, 0.0);
        Lab4 lab4 = new Lab4();
        int j;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (;;) {
            for (int i = 0; i < 50; i++) {
                System.out.print("_");
            }
            System.out.println("_");
            System.out.print("1 - Создание объекта \n"
                    + "2 - Перемещение на плоскости \n"
                    + "3 - Изменение размера объекта \n"
                    + "4 - Вращение объекта на определенный угол \n"
                    + "5 - Вывести информацию по объекту \n"
                    + "6 - Удалить объект \n"
                    + "7 - Завершить программу \n");
            int action = Integer.parseInt(reader.readLine());
            switch (action) {
                case 1:
                    System.out.print("Выберите объект \n"
                            + "1 - Окружность \n"
                            + "2 - Квадрат \n"
                            + "3 - Прямоугольник \n");
                    j = Integer.parseInt(reader.readLine());
                    switch (j) {
                        case 1:
                            System.out.print("Введите радиус: ");
                            double radius = Double.parseDouble(reader.readLine());
                            System.out.print("Введите координату центра: ");
                            double centre = Double.parseDouble(reader.readLine());
                            circle = new Circle(radius, centre);
                            System.out.print(circle.getInfo());
                            break;
                        case 2:
                            System.out.print("Введите сторону а: ");
                            double a = Double.parseDouble(reader.readLine());
                            System.out.print("Введите сторону b: ");
                            double b = Double.parseDouble(reader.readLine());
                            square = new Square(a, b);
                            System.out.print(square.getInfo());
                            break;
                        case 3:
                            System.out.print("Введите радиус: ");
                            a = Double.parseDouble(reader.readLine());
                            System.out.print("Введите координату центра: ");
                            b = Double.parseDouble(reader.readLine());
                            rectangle = new Rectangle(a, b);
                            System.out.print(rectangle.getInfo());
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Выберите объект \n"
                            + "1 - Окружность \n"
                            + "2 - Квадрат \n"
                            + "3 - Прямоугольник \n");
                    j = Integer.parseInt(reader.readLine());
                    switch (j) {
                        case 1:
                            System.out.print("Укажите координаты, на которые нужно переместить объект: ");
                            double a = Double.parseDouble(reader.readLine());
                            double b = Double.parseDouble(reader.readLine());
                            lab4 = new Lab4();
                            circle.move(a, b, lab4);
                            System.out.print(circle.getInfo());
                            break;
                        case 2:
                            System.out.print("Укажите координаты, на которые нужно переместить объект: ");
                            a = Double.parseDouble(reader.readLine());
                            b = Double.parseDouble(reader.readLine());
                            lab4 = new Lab4();
                            square.move(a, b, lab4);
                            System.out.print(square.getInfo());
                            break;
                        case 3:
                            System.out.print("Укажите координаты, на которые нужно переместить объект: ");
                            a = Double.parseDouble(reader.readLine());
                            b = Double.parseDouble(reader.readLine());
                            lab4 = new Lab4();
                            rectangle.move(a, b, lab4);
                            System.out.print(rectangle.getInfo());
                            break;
                    }
                    break;
                case 3:
                    System.out.print("Выберите объект \n"
                            + "1 - Окружность \n"
                            + "2 - Квадрат \n"
                            + "3 - Прямоугольник \n");
                    j = Integer.parseInt(reader.readLine());
                    switch (j) {
                        case 1:
                            System.out.print("Укажите координату, на которые вы хотите изменить радиус объекта: ");
                            double a = Double.parseDouble(reader.readLine());
                            circle.resize(a);
                            System.out.print(circle.getInfo());
                            break;
                        case 2:
                            System.out.print("Укажите координаты, на которые вы хотите изменить размер объекта: ");
                            a = Double.parseDouble(reader.readLine());
                            double b = Double.parseDouble(reader.readLine());
                            square.resize(a, b);
                            System.out.print(square.getInfo());
                            break;
                        case 3:
                            System.out.print("Укажите координаты, на которые вы хотите изменить размер объекта: ");
                            a = Double.parseDouble(reader.readLine());
                            b = Double.parseDouble(reader.readLine());
                            rectangle.resize(a, b);
                            System.out.print(rectangle.getInfo());
                            break;
                    }
                    break;
                case 4:
                    System.out.print("Выберите объект \n"
                            + "1 - Окружность \n"
                            + "2 - Квадрат \n"
                            + "3 - Прямоугольник \n");
                    j = Integer.parseInt(reader.readLine());
                    switch (j) {
                        case 1:
                            System.out.print("Введите угол: ");
                            double angle = Double.parseDouble(reader.readLine());
                            circle.rotation(angle);
                            System.out.print(circle.getInfo());
                            break;
                        case 2:
                            System.out.print("Введите угол: ");
                            angle = Double.parseDouble(reader.readLine());
                            square.rotation(angle);
                            System.out.print(square.getInfo());
                            break;
                        case 3:
                            System.out.print("Введите угол: ");
                            angle = Double.parseDouble(reader.readLine());
                            rectangle.rotation(angle);
                            System.out.print(rectangle.getInfo());
                            break;
                    }
                    break;
                case 5:
                    System.out.print("Выберите объект \n"
                            + "1 - Окружность \n"
                            + "2 - Квадрат \n"
                            + "3 - Прямоугольник \n");
                    j = Integer.parseInt(reader.readLine());
                    switch (j) {
                        case 1:
                            System.out.print(circle.getInfo());
                            break;
                        case 2:
                            System.out.print(square.getInfo());
                            break;
                        case 3:
                            System.out.print(rectangle.getInfo());
                            break;
                    }
                    break;
                case 6:
                    System.out.print("Выберите объект \n"
                            + "1 - Окружность \n"
                            + "2 - Квадрат \n"
                            + "3 - Прямоугольник \n");
                    j = Integer.parseInt(reader.readLine());
                    switch (j) {
                        case 1:
                            circle = null;
                            System.out.println("Объект удален");
                            break;
                        case 2:
                            square = null;
                            System.out.println("Объект удален");
                            break;
                        case 3:
                            rectangle = null;
                            System.out.println("Объект удален");
                            break;
                    }
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }
    }
}
