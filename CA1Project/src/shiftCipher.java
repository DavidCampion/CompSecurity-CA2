
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class shiftCipher {

    public static void main(String[] args) throws IOException {

        File file = new File("CA1Project/cipher.txt");
        Scanner fin = new Scanner(file);
        Scanner kb = new Scanner(System.in);

        String cipherOne = fin.nextLine().toUpperCase();
        String cipherTwo = fin.nextLine().toUpperCase();


        int choice = 0;
        boolean isNumber;
        while (choice != 3) {
            System.out.println("====== Cipher Decrypter 9000 ======");
            System.out.println();
            System.out.println("1. Decrypt The first Cipher from file");
            System.out.println("2. Decrypt The Second Cipher from file (Using)");
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
                            System.out.println("Cracking First Cipher....");
                            cipherOnePrint(cipherOne);
                            break;
                        case 2:
                            System.out.println("Cracking Second Cipher....");
                            cipherTwoPrint(cipherTwo);
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

    public static void cipherOnePrint(String s) {
        System.out.println();
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Original Cipher = " + s);
        System.out.println("Cipher Shift Key = 3");
        System.out.println("Uncoded Cipher = " + cipher(s, 3));
        System.out.println("-------------------------------------------------------------------------");
    }

    public static void cipherTwoPrint(String s) {
        System.out.println();
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Original Cipher = " + s);
        int cipherCount = 0;
        for(int i = 0; i <= 26; i++){
            String cipherCrack = cipher(s, i);
            if (!cipherCrack.contains("DONE")){
                cipherCount++;
            } else {
                System.out.println("Shift Key is " + cipherCount);
                System.out.println("Uncoded Cipher = " + cipherCrack);
                i = 26;
            }
        }
        System.out.println("-------------------------------------------------------------------------");
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
