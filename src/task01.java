import java.util.InputMismatchException;
import java.util.Scanner;

public class task01 {

    public static void main(String[] args) {

        float n = task01();
        while (n == 0) {
            n = task01();
        }
        System.out.println(task01());
    }

    public static float task01() {
        float num = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Input float number: ");
        try {
            num = in.nextFloat();
        } catch (InputMismatchException e) {
            return num;
        }
        return num;
    }

}
