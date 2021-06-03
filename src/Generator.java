import java.security.*;
import java.util.*;
public class Generator {

    private String lowercase;
    private String uppercase;
    private String digits;
    private String symbols;
    private StringBuilder allchar;
    private StringBuilder password;
    private Random random = new SecureRandom();

    private boolean containsLowerCase = false;
    private boolean containsUpperCase = false;
    private boolean containsDigits = false ;
    private boolean containsSymbols = false;

    Generator() {
        lowercase = "abcdefghijklmnopqrstuvwxyz";
        uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        digits = "0123456789";
        symbols = "!@#$%&*+-=,.?";
        allchar = new StringBuilder();
        password = new StringBuilder();
    }
    protected void parameters() {
        Scanner s = new Scanner(System.in);
        System.out.print("Include Lowercase letters? (y/n) : ");
        if(s.nextLine().equals("y")) {
            containsLowerCase = true;
            allchar.append(lowercase);
        }

        System.out.print("Include Uppercase letters? (y/n) : ");
        if(s.nextLine().equals("y")) {
            containsUpperCase = true;
            allchar.append(uppercase);
        }

        System.out.print("Include Digits? (y/n) : ");
        if(s.nextLine().equals("y")) {
            containsDigits = true;
            allchar.append(digits);
        }

        System.out.print("Include Symbols? (y/n) : ");
        if(s.nextLine().equals("y")) {
            containsSymbols = true;
            allchar.append(symbols);
        }

    }
    protected String get() {
        return password.toString();
    }

    protected void generate() {
        char[] all = allchar.toString().toCharArray();

        int length = 0;
        do {
            if(length == 6 || length == 13) {
                password.append("-");
            } else {
                password.append(all[random.nextInt(all.length)]);
            }
            length++;
        } while(length != 20);


        int[] randoms  = new int[4];
        for(int i = 0; i < 4; i++) {
            randoms[i] = random.nextInt(password.length());
            while(randoms[i] == 6 || randoms[i] == 13) {
                randoms[i] = random.nextInt(password.length());
            }
        }
        //to ensure atleast character one of the selected criteria is filled.
        
        if(containsLowerCase)
            password.replace(randoms[0],randoms[0]+1, String.valueOf(lowercase.charAt(random.nextInt(lowercase.length()))));
        if(containsUpperCase)
            password.replace(randoms[1],randoms[1]+1, String.valueOf(uppercase.charAt(random.nextInt(uppercase.length()))));
        if(containsDigits)
            password.replace(randoms[2],randoms[2]+1, String.valueOf(digits.charAt(random.nextInt(digits.length()))));
        if(containsSymbols)
            password.replace(randoms[3],randoms[3]+1, String.valueOf(symbols.charAt(random.nextInt(symbols.length()))));
    }

}
