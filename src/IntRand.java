
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


/**
 *
 * @author Студент
 */
public class IntRand {
    private static Random rand = new Random();    
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = rand.nextInt(10) + 1;        
        for(int i = 5; i > 0; i--) {
            try {
                System.out.println("Угадайте число! (У вас есть всего " + i + " попыток)");
                int userNum = Integer.parseInt(reader.readLine());
                if((userNum >= 1) && (userNum <= 10)) {
                    if(userNum < number) {
                        System.out.println("Ваше число меньше загаданого");
                    } else {
                        if(userNum > number) {
                            System.out.println("Ваше число больше загаданого");
                        }
                        else {
                            System.out.println("Вы угадали, это число " + number);
                            break;
                        }
                    }                    
                } else {
                    System.out.println("Неверный диапазон");
                    continue;
                }
                System.out.println("Увы, но вы не угадали число, это было число " + number);
            } catch(NumberFormatException e) {
                System.out.println("Нужно ввести число");
            }          
        }        
    }
}
