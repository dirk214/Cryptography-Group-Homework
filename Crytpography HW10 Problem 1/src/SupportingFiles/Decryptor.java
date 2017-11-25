package SupportingFiles;

/**
 * The decryptor class which will decrypt the supplied input with the supplied parameters. 
 * @author Andrew Herbert
 * @version Nov 22, 2017
 */
public class Decryptor {

    public static String decrypt(String input, int rounds, SBox sbox, Permutation permutation, String key) {
        String result = Processes.hexToBin(input);
        result = String.format("%16s", result).replace(" ", "0");
        String firstRoundKey = key.substring(0,4);
        String secondRoundKey = key.substring(1,5);
        String thirdRoundKey = key.substring(2,6);
        String fourthRoundKey = key.substring(3,7);
        String fifthRoundKey = key.substring(4,8);
        String[] keys = {firstRoundKey, secondRoundKey, thirdRoundKey, fourthRoundKey, fifthRoundKey};
        
        for (int i = rounds; i >= 0; i--) {
            if (i == rounds) {
                String currentkey = keys[i];
                currentkey = Processes.hexToBin(currentkey);
                currentkey = String.format("%16s", currentkey).replace(" ", "0");
                result = Processes.XORit(result, currentkey);
                System.out.println("XOR: " + result);
                result = Processes.SBoxI(result, sbox);
                System.out.println("SBOX: " + result);
            }
            else if (i == 0) {
                String currentkey = keys[i];
                currentkey = Processes.hexToBin(currentkey);
                currentkey = String.format("%16s", currentkey).replace(" ", "0");
                result = Processes.XORit(result, currentkey);
                System.out.println("XOR: " + result);
            }
            else {
                String currentkey = keys[i];
                currentkey = Processes.hexToBin(currentkey);
                currentkey = String.format("%16s", currentkey).replace(" ", "0");
                result = Processes.XORit(result, currentkey);
                System.out.println("XOR: " + result);
                result = Processes.Permuteit(result, permutation);
                System.out.println("Perm: " + result);
                result = Processes.SBoxI(result, sbox);
                System.out.println("SBOX: " + result);
            }
        }
        
        result = Processes.binToHex(result);
        return result.toUpperCase();
    }
    
}
