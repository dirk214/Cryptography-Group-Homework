package SupportingFiles;

/**
 * The encryptor class will encrypt the supplied input with the given parameters. 
 * @author Andrew Herbert
 * @version Nov 22, 2017
 */
public class Encryptor {

    public static String encrypt(String input, int rounds, SBox sbox, Permutation permutation, String key) {
        String result = Processes.hexToBin(input);
        result = String.format("%16s", result).replace(" ", "0");
        String firstRoundKey = key.substring(0,4);
        String secondRoundKey = key.substring(1,5);
        String thirdRoundKey = key.substring(2,6);
        String fourthRoundKey = key.substring(3,7);
        String fifthRoundKey = key.substring(4,8);
        String[] keys = {firstRoundKey, secondRoundKey, thirdRoundKey, fourthRoundKey, fifthRoundKey};
        
        if (rounds == 0) {
            String sLastKey = Processes.hexToBin(keys[rounds]);
            sLastKey = String.format("%16s", sLastKey).replace(" ", "0");
            result = Processes.XORit(result, sLastKey);
            result = Processes.binToHex(result);
        }
        
        else {
            for (int i = 0; i < rounds - 1; i++) {
                String currentkey = keys[i];
                currentkey = Processes.hexToBin(currentkey);
                currentkey = String.format("%16s", currentkey).replace(" ", "0");
                result = Processes.XORit(result, currentkey);
                result = Processes.SBoxit(result, sbox);
                result = Processes.Permuteit(result, permutation);
            }
            
            String lastKey = keys[rounds - 1];
            lastKey = Processes.hexToBin(lastKey);
            lastKey = String.format("%16s", lastKey).replace(" ", "0");
            result = Processes.XORit(result, lastKey);
            result = Processes.SBoxit(result, sbox);
            String sLastKey = Processes.hexToBin(keys[rounds]);
            sLastKey = String.format("%16s", sLastKey).replace(" ", "0");
            result = Processes.XORit(result, sLastKey);
            result = Processes.binToHex(result);
        }
        
        return result.toUpperCase();
    }
    
}
