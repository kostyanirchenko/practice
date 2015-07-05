
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


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

class Str {
    String s;
    
    Str(String s1) {
        s = s1;
    }
}

class SymbolString extends Str {

    public SymbolString(String s1) {
        super(s1);
    }
    
    void concat(String s, String s1) {
        if(s.isEmpty() && s1.isEmpty()) {
            System.out.println("Строки пустые");
        }
        else {
            System.out.println(s + " " + s1);
        }
    }    
}

class BinaryString extends Str {
    public BinaryString(String s1) {
        super(s1);
    }
    
    void concat(String s, String s1) {
        try {
            if (s.isEmpty() && s1.isEmpty()) {
                System.out.println("Строки пустые");
            } else {
                System.out.println(Integer.toBinaryString(Integer.parseInt(s) +Integer.parseInt(s1)));
            }
        } catch(NumberFormatException e) {
            System.out.println("Необходима численная строка");
        }        
    }
}

public class Lab5 {
    public static boolean checkString(String stringToCheck) {
        if (stringToCheck == null || stringToCheck.length() == 0) {
            return false;
        }

        int i = 0;
        if (stringToCheck.charAt(0) == '-') {
            if (stringToCheck.length() == 1) {
                return false;
            }
            i = 1;
        }

        char c;
        for (; i < stringToCheck.length(); i++) {
            c = stringToCheck.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException {
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
                            symbolString.concat(symbolString.s, s1);
                            break;
                        case 2:
                            System.out.print("Укажите вторую строку ");
                            s1 = reader.readLine();
                            if (!checkString(binaryString.s) || !checkString(s1)) {
                                System.out.println("Ошибка, строки должны быть числовыми");
                            }
                            else {
                                binaryString.concat(binaryString.s, s1);
                            }                            
                            break;
                    }
                    break;
                case 3:
                    System.out.print("1 - Символьная строка \n"
                            + "2 - Бинарная строка \n");
                    j = Integer.parseInt(reader.readLine());
                    switch(j) {
                        case 1:
                            if(symbolString.s != null) {
                                System.out.println(Integer.toHexString(Integer.parseInt(symbolString.s)));
                            } else {
                                System.out.println("Объект удален либо еще не был создан");
                            }
                            break;
                        case 2:
                            if(binaryString.s != null) {
                                System.out.println(Integer.toBinaryString(Integer.parseInt(binaryString.s)));
                            } else {
                                System.out.println("Объект удален либо еще не был создан");
                            }
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