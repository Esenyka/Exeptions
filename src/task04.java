import java.io.FileNotFoundException;
import java.util.Scanner;

public class task04 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("Input word: ");
        String word = in.nextLine();
        if (word.length() == 0){
            throw new Exception("You can not use empty lines");
        }
        System.out.println(word);
    }
}
