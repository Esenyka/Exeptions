package FinalTasck;

import java.io.FileWriter;
import java.io.IOException;
import java.time.DateTimeException;
import java.util.Arrays;
import java.util.Scanner;

public class task {
    public static void main(String[] args) {

        String[] clientsSurnames = new String[10];

        String[] client = new String[6];
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Input your data like this - " +
                    "lastname, name, surname, birthday{00.00.0000}, phone number{89858971154}, gender{f/m}. Use only ','");
            String data = in.nextLine();

            String[] pars = data.split(", ");

            if (hasNumeric(pars[0])) {
                throw new NumberFormatException("Your lastname has numeric");
            } else if (hasNumeric(pars[1])) {
                throw new NumberFormatException("Your name has numeric");
            } else if (hasNumeric(pars[2])) {
                throw new NumberFormatException("Your surname has numeric");
            } else if (!checkDate(pars[3])) {
                throw new DateTimeException("You input the wrong date. Try again like this - 12.02.2020");
            } else if (!checkPhoneNumber(pars[4])) {
                throw new NumberFormatException("You input the wrong phone number. Try again like this - 89858971154");
            } else if (!checkGender(pars[5])) {
                throw new RuntimeException("You input the wrong gender. Try again like this - 'm' or 'f'");
            }
            System.out.println("Everything OK");
            for(int i = 0; i < pars.length; i++) {
                client[i] = pars[i];
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Что-то не так с колличеством введенных данных...");
        }


        try(FileWriter writer = new FileWriter(client[0] + ".txt", true)){
            writer.append(Arrays.toString(client));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static boolean hasNumeric(String word) {
        boolean result = false;
        for(int i = 0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i))){
                result = true;
            }
        }
        return result;
    }

    public static boolean checkDate(String date) {
        boolean result = true;
        String[] d = date.split("\\.");
        if (d[0].length() > 2 || d[1].length() > 2 || d[2].length() > 4) {
            return false;
        }
        return result;
    }

    public static boolean checkPhoneNumber(String phone) {
        if(phone.length() != 11) {
            return false;
        }
        for(int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean checkGender(String g) {
        return g.equals("f") || g.equals("m");
    }
}
