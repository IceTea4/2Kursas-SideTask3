import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SumOfSquares {
    public static void main(String[] args) {
        String fileName = "test1.txt";

        try (InputStream stream = SumOfSquares.class.getClassLoader().getResourceAsStream(fileName);
             InputStreamReader reader = new InputStreamReader(stream);
             BufferedReader br = new BufferedReader(reader)) {

            int result = br.lines()
                    .map(Integer::parseInt)
                    .filter(x -> x > 0)
                    .map(x -> x * x)
                    .reduce(0, Integer::sum);

            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
