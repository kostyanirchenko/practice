
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Написать программу, демонстрирующую работу с объектами двух типов: T1 и T2,
 * для чего создать систему соответствующих классов. Каждый объект должен иметь
 * идентификатор (в виде произвольной строки символов) и одно или несколько
 * полей для хранения состояния объекта (один класс является потомком другого).
 * Клиенту (функции main) должны быть доступны следующие основные операции
 * (методы): создать объект, удалить объект, показать значение объекта и прочие
 * дополнительные операции (зависят от варианта). Операции по созданию и
 * удалению объектов инкапсулировать в классе Factory. Предусмотреть меню,
 * позволяющее продемонстрировать заданные операции. При необходимости в
 * разрабатываемые классы добавляются дополнительные методы (например,
 * конструктор копирования, операция присваивания и т.п.) для обеспечения
 * надлежащего функционирования этих классов.
 * T1 - SymbString - Символьная строка (произвольная строка символов)
 * T2 - BinString - Двоичцая строка (изображение двоичного числа)
 * @author Студент
 */
public class Lab5 {
    String s;
    
    public Lab5(String s1) {
        s = s1;
    }
    
    static class SymbolString extends Lab5 {
        String s;
        public SymbolString(String s1) {
            super(s1);
        }
        
        public String add(String s1, String s2) {
            return s1 + s2;
        }
        
        public void show() {
            System.out.print(s + "\n");
        }
    }
    
    static class BinaryString extends Lab5 {
        String s;
        public BinaryString(String s1) {
            super(s1);
        }
        
        public String add(String s1, String s2) {
            return s1 + s2;
        }
        
        public void show() {
            System.out.print(s + "\n");
        }
    }
    
    public static void main(String[] args) throws IOException {
        Lab5 lab5 = new Lab5("");
        SymbolString symbolString = new SymbolString("");
        BinaryString binaryString = new BinaryString("0");
        int j;
        String s;
        String s1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (;;) {
            for (int i = 0; i < 50; i++) {
                System.out.print("_");
            }
            System.out.println("_");
            System.out.print("1 - Создание объекта \n"
                    + "2 - Конкатенация объектов \n"
                    + "3 - Вывести информацию об объекте \n"
                    + "4 - Удалить объект \n"
                    + "5 - Завершить программу \n");
            int action = Integer.parseInt(reader.readLine());
            switch (action) {
                case 1:
                    System.out.print("1 - Символьная строка \n"
                            + "2 - Бинарная строка \n");
                    j = Integer.parseInt(reader.readLine());
                    switch(j) {
                        case 1:
                            System.out.print("Введите вашу строку ");
                            s = reader.readLine();
                            symbolString = new SymbolString(s);
                            break;
                        case 2:
                            System.out.print("Введите вашу строку ");
                            s = reader.readLine();
                            binaryString = new BinaryString(s);
                            break;
                    }
                    break;
                case 2:
                    System.out.print("1 - Символьная строка \n"
                            + "2 - Бинарная строка \n");
                    j = Integer.parseInt(reader.readLine());
                    switch(j) {
                        case 1:
                            System.out.print("Укажите вторую строку ");
                            s1 = reader.readLine();
                            System.out.print(symbolString.add(symbolString.toString(), s1) + "\n");
                            break;
                        case 2:
                            System.out.print("Укажите вторую строку ");
                            s1 = reader.readLine();
                            System.out.println(binaryString.add(binaryString.toString(), s1));
                            break;
                    }
                    break;
                case 3:
                    System.out.print("1 - Символьная строка \n"
                            + "2 - Бинарная строка \n");
                    j = Integer.parseInt(reader.readLine());
                    switch(j) {
                        case 1:
                            symbolString.show();
                            break;
                        case 2:
                            binaryString.show();
                            break;
                    }
                    break;
                case 4:
                    System.out.print("1 - Символьная строка \n"
                            + "2 - Бинарная строка \n");
                    j = Integer.parseInt(reader.readLine());
                    switch(j) {
                        case 1:
                            symbolString = null;
                            break;
                        case 2:
                            binaryString = null;
                            break;
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}