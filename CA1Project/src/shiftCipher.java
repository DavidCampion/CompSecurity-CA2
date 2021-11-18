
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class shiftCipher {

    public static void main(String[] args) {

        System.out.println(cipher("ZHOO GRQH BRX KDYH VxFFHVVIXOOB frpSOHWHG TXHVWLRQ Rqh", 3));  //prints def
        System.out.println(cipher("JNXLmBHG MPH ptl FHKX WByYBVNEM UNM BM EhhDL EBDx RHN TvXW BM PXEE WHGX RHN", 19));  //prints abc

    }

    static String cipher(String msg, int shift){
        String s = "";
        for(int x = 0; x < msg.length(); x++){
            char c = (char)(msg.charAt(x) - shift);
            if (Character.isWhitespace(c)) {
                s += (" ");
            }else if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                    s += (char) (msg.charAt(x) - shift);
            }else {
                s += (char) (msg.charAt(x) + (26 - shift));
            }
        }
        return s;
    }

}
