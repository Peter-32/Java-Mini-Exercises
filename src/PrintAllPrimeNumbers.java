import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Peter on 7/20/2016.
 */
public class PrintAllPrimeNumbers {
    public static boolean isPrime(int number) {
        // There are no primes less than 2
        if (number < 2) {return false;}

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BufferedWriter bw = null;
        try {
            File file = new File("./primeList");

            // if file doesn't exist, then create it
            if (!file.exists()) {
                // returns a Boolean
                file.createNewFile();
            }

            // set up buffered writer for small appends to file
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);

            // loop through all integers below 1 million and append to file if prime
            for (int i = 2; i < 1000000; i++) {
                if (isPrime(i)) {
                    // note write() does not automatically create a new line
                    bw.write(Integer.toString(i));
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // always close files.
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                // do nothing
            }
        }
        System.out.println("Completed");












    }
}
