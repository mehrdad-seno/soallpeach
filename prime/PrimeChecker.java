import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeChecker {
    public static void main(final String[] args) throws Exception {
        final String fileName = args[0];
        final long t1 = System.currentTimeMillis();
        read(fileName);
        final long t2 = System.currentTimeMillis();
        System.out.println("Total time: " + (t2 - t1));
    }

    public static void read(final String inputFile) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(inputFile)) {
            final BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            int count = 0;
            while ((line = in.readLine()) != null) {
                System.out.println(isPrime(parseInt(line)));
                ++count;
            }
            System.out.println("Processed " + count);
        }
    }

    /**
     * Based on https://en.wikipedia.org/wiki/Primality_test 6k ± 1 optimization
     */
    public static Integer isPrime(final int num) {
        if (num <= 3)
            return (num > 1) ? 1 : 0;
        if (num % 2 == 0 || num % 3 == 0)
            return 0;

        final int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i+=6) {
            if (num % i == 0 || num % (i + 2) == 0)
                return 0;
        }

        return 1;
    }
}