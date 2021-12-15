
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class app {

    public static void main(String[] args) throws IOException {

        Scanner kb = new Scanner(System.in);

        int choice = 0;
        boolean isNumber;
        while (choice != 3) {
            System.out.println("====== Decrypter & Encrypter 9001 ======");
            System.out.println();
            System.out.println("1. Encrypt a File");
            System.out.println("2. Decrypt a File");
            System.out.println("3. Exit");
            System.out.println();
            System.out.println("====================================");
            System.out.println("Please enter a number from the Main Menu");

            //validation UserInput
            do {
                try {
                    choice = kb.nextInt();
                    isNumber = true;
                    switch (choice) {
                        case 1:
                            System.out.println("Encrypt File Selected... ");

                            break;
                        case 2:
                            System.out.println("Decrypt File Selected... ");

                            break;
                        case 3:
                            System.out.println("Goodbye");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Please enter a Number (1-3)");
                    isNumber = false;
                    kb.next();
                }
            } while (!(isNumber));
            kb.nextLine();
        }
    }

    static String cipher(String msg, int shift){
        String s = "";
        for(int x = 0; x < msg.length(); x++){
            char c = (char)(msg.charAt(x) - shift);
            if (Character.isWhitespace(c)) {
                s += (" ");
            }else if((c >= 'A' && c <= 'Z')) {
                    s += (char) (msg.charAt(x) - shift);
            }else {
                s += (char) (msg.charAt(x) + (26 - shift));
            }
        }
        return s;
    }

}
