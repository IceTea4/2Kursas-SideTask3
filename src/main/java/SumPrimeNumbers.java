import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class SumPrimeNumbers {
    public static void main(String[] args) {
        String fileName = "test2.txt";

        try (InputStream stream = SumPrimeNumbers.class.getClassLoader().getResourceAsStream(fileName);
             InputStreamReader reader = new InputStreamReader(stream);
             BufferedReader br = new BufferedReader(reader)) {

            int result = br.lines()
                    .map(Integer::parseInt)
                    .filter(SumPrimeNumbers::isPrime)
                    .reduce(0, Integer::sum);

            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        } else {
            return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                    .noneMatch(divisor -> number % divisor == 0);
        }
    }
}
