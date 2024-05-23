import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String f = "C://Users//Eldar//Downloads//numbers.txt";
        List<Integer> nums = r(f);

        System.out.println("Минимальное: " + _min(nums));
        System.out.println("Максимальное: " + _max(nums));
        System.out.println("Сумма: " + _sum(nums));
        System.out.println("Произведение: " + _mult(nums));
    }

    public static List<Integer> r(String f) {
        List<Integer> n = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String l = br.readLine();
            if (l != null) {
                for (String s : l.split(" ")) {
                    n.add(Integer.parseInt(s));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return n;
    }

    public static int _min(List<Integer> n) {
        int m = Integer.MAX_VALUE;
        for (int x : n) {
            if (x < m) {
                m = x;
            }
        }
        return m;
    }

    public static int _max(List<Integer> n) {
        int m = Integer.MIN_VALUE;
        for (int x : n) {
            if (x > m) {
                m = x;
            }
        }
        return m;
    }

    public static long _sum(List<Integer> n) {
        long s = 0;
        for (int x : n) {
            s += x;
        }
        return s;
    }

    public static long _mult(List<Integer> n) {
        long m = 1;
        for (int x : n) {
            m *= x;
        }
        return m;
    }
}
