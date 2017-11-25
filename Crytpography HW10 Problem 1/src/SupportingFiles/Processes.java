package SupportingFiles;

import java.math.BigInteger;

/**
 * This contains processes used in both encryption and decryption.
 * @author Andrew Herbert
 * @version Nov 23, 2017
 */
public class Processes {

    public static String XORit(String text, String key) {
        String result = "";
        for (int i = 0; i < 16; i++)
            result += text.charAt(i) ^ key.charAt(i);
        return result;
    }

    public static String SBoxit(String text, SBox sbox) {
        String temp = binToHex(text);
        String[] temps = {temp.substring(0, 1), temp.substring(1, 2), temp.substring(2, 3), temp.substring(3, 4)};
        String result = "";
        for (int i = 0; i < 4; i++)
            result += sbox.cipherTextTable[Integer.parseInt(temps[i], 16)];
        
        result = hexToBin(result);
        result = String.format("%16s", result).replace(" ", "0");
        return result;
    }

    public static String Permuteit(String text, Permutation permutation) {
        String result = "";
        for (int i = 0; i < 16; i++) {
            int x = Integer.parseInt(permutation.cipherTextTable[i]) - 1;
            int y = Integer.parseInt(Character.toString(text.charAt(x)));
            result += y; 
        }
        return result;
    }
    
    public static String binToHex(String text) {
        String result = "";
        String[] temp = {text.substring(0,4), text.substring(4,8), text.substring(8,12), text.substring(12,16)};
        for (int i = 0; i < 4; i++) {
            int deci = Integer.parseInt(temp[i], 2);
            String hexi = Integer.toString(deci, 16);
            result += hexi;
        }
        return result;
    }
    
    public static String hexToBin(String text) {
        return new BigInteger(text, 16).toString(2);
    }
    
    public static String SBoxI(String text, SBox sbox) {
        String temp = binToHex(text);
        String[] temps = {temp.substring(0, 1), temp.substring(1, 2), temp.substring(2, 3), temp.substring(3, 4)};
        String result = "";
        for (int i = 0; i < 4; i++) {
            String value = "";
            switch (temps[i]) {
            case "0" : value = "e";
                break;
            case "1" : value = "3";
                break;
            case "2" : value = "4";
                break;
            case "3" : value = "8";
                break;
            case "4" : value = "1";
                break;
            case "5" : value = "c";
                break;
            case "6" : value = "a";
                break;
            case "7" : value = "f";
                break;
            case "8" : value = "7";
                break;
            case "9" : value = "d";
                break;
            case "a" : value = "9";
                break;
            case "b" : value = "6";
                break;
            case "c" : value = "b";
                break;
            case "d" : value = "2";
                break;
            case "e" : value = "0";
                break;
            case "f" : value = "5";
                break;
            }
            result += value;
        }
        
        result = hexToBin(result);
        result = String.format("%16s", result).replace(" ", "0");
        return result;
    }

}
