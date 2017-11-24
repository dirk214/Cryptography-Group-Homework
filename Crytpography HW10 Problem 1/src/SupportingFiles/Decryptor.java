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
        //Working on this part. 
        return result;
    }
    
}
