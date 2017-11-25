import java.util.Scanner;
import SupportingFiles.Decryptor;
import SupportingFiles.Encryptor;
import SupportingFiles.Permutation;
import SupportingFiles.SBox;
/**
 * Launches the program.
 * @author Andrew Herbert
 * @version Nov 22, 2017
 */
public class Driver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you wish to encrypt or decrypt? Please use the full word.");
        String option = scanner.nextLine();
        option = option.toLowerCase();
        if (option.equals("encrypt")) {
            System.out.println("Please enter the data you wish to be encrypted.");
            String input = scanner.nextLine();
            System.out.println("Please enter the number of rounds used in encryption.");
            int numberOfInputs = Integer.parseInt(scanner.nextLine());
            System.out.println("Do you wish to use a different SBox than the default? Please type Yes or No.");
            String SBoxOption = scanner.nextLine();
            SBoxOption.toLowerCase();
            SBox sbox = new SBox();
            if (SBoxOption.equals("yes")) {
                System.out.println("Please input the new SBox's ciphertext equivalences in the order of the default one, seperated with commas.");
                sbox.cipherTextTable = scanner.nextLine().split(",");
            }
            System.out.println("Do you wish to use a different Permutation than the default? Please type Yes or No.");
            String PermutationOption = scanner.nextLine();
            PermutationOption.toLowerCase();
            Permutation permutation = new Permutation();
            if (PermutationOption.equals("yes")) {
                System.out.println("Please input the new Permutations ciphertext equivalences in the order of the default one, seperated with commas.");
                permutation.cipherTextTable = scanner.nextLine().split(",");
            }
            
            System.out.println("Please input the key.");
            String key = scanner.nextLine();
            
            System.out.println("Begining encryption.");
            System.out.println("Encrypted text: " + Encryptor.encrypt(input, numberOfInputs, sbox, permutation, key));
            System.out.println("End of process, terminating program.");
            
        }
        else if (option.equals("decrypt")) {
            System.out.println("Please enter the data you wish to be decrypted.");
            String input = scanner.nextLine();
            System.out.println("Please enter the number of rounds used in decryption.");
            int numberOfInputs = Integer.parseInt(scanner.nextLine());
            System.out.println("Do you wish to use a different SBox than the default? Please type Yes or No.");
            String SBoxOption = scanner.nextLine();
            SBoxOption.toLowerCase();
            SBox sbox = new SBox();
            if (SBoxOption == "yes") {
                System.out.println("Please input the new SBox's ciphertext equivalences in the order of the default one, seperated with commas.");
                sbox.cipherTextTable = scanner.nextLine().split(",");
            }
            System.out.println("Do you wish to use a different Permutation than the default? Please type Yes or No.");
            String PermutationOption = scanner.nextLine();
            PermutationOption.toLowerCase();
            Permutation permutation = new Permutation();
            if (PermutationOption == "yes") {
                System.out.println("Please input the new Permutations ciphertext equivalences in the order of the default one, seperated with commas.");
                permutation.cipherTextTable = scanner.nextLine().split(",");
            }
            
            System.out.println("Please input the key.");
            String key = scanner.nextLine();
            
            System.out.println("Begining decryption.");
            System.out.println("Decrypted text: " + Decryptor.decrypt(input, numberOfInputs, sbox, permutation, key));
            System.out.println("End of process, terminating program.");
        }
        
        else {
            System.out.println("Inproper input, terminating program.");
        }
        
        scanner.close();

    }

}
