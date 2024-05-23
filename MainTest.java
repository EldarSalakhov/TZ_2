import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class MainTest {

    @Test
    public void testMin() {
        List<Integer> n = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(Main._min(n), 1);

        n = Arrays.asList(-1, -2, -3, -4, -5);
        assertEquals(Main._min(n), -5);

        n = Arrays.asList(0);
        assertEquals(Main._min(n), 0);
    }

    @Test
    public void testMax() {
        List<Integer> n = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(Main._max(n), 5);

        n = Arrays.asList(-1, -2, -3, -4, -5);
        assertEquals(Main._max(n), -1);

        n = Arrays.asList(0);
        assertEquals(Main._max(n), 0);
    }

    @Test
    public void testSum() {
        List<Integer> n = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(Main._sum(n), 15);

        n = Arrays.asList(-1, -2, -3, -4, -5);
        assertEquals(Main._sum(n), -15);

        n = Arrays.asList(0);
        assertEquals(Main._sum(n), 0);
    }

    @Test
    public void testMult() {
        List<Integer> n = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(Main._mult(n), 120);

        n = Arrays.asList(-1, -2, -3, -4, -5);
        assertEquals(Main._mult(n), -120);

        n = Arrays.asList(0);
        assertEquals(Main._mult(n), 0);
    }

    @Test
    public void testDuplicate() {
        List<Integer> n = Arrays.asList(7, 7, 7, 7, 7);
        assertEquals(Main._min(n), 7);
        assertEquals(Main._max(n), 7);
        assertEquals(Main._sum(n), 35);
        assertEquals(Main._mult(n), 16807);
    }
    private List<Integer> genNums(int size) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            nums.add(i);
        }
        return nums;
    }

    private long measureTime(Runnable func, int reps) {
        long totalTime = 0;
        for (int i = 0; i < reps; i++) {
            long start = System.currentTimeMillis();
            func.run();
            long end = System.currentTimeMillis();
            totalTime += (end - start);
        }
        return totalTime / reps;
    }

    @Test
    public void testPerfMin() {
        int[] sizes = {100, 500, 1000, 5000, 10000, 50000, 100000, 500000, 1000000};
        int reps = 1000;
        for (int size : sizes) {
            List<Integer> nums = genNums(size);
            long avgTime = measureTime(() -> Main._min(nums), reps);
            System.out.println("Min функция для " + size + " элементов работает в среднем: " + avgTime + " мс");
        }
    }

    @Test
    public void testPerfMax() {
        int[] sizes = {100, 500, 1000, 5000, 10000, 50000, 100000, 500000, 1000000};
        int reps = 1000;
        for (int size : sizes) {
            List<Integer> nums = genNums(size);
            long avgTime = measureTime(() -> Main._max(nums), reps);
            System.out.println("Max функция для " + size + " элементов работает в среднем: " + avgTime + " мс");
        }
    }

    @Test
    public void testPerfSum() {
        int[] sizes = {100, 500, 1000, 5000, 10000, 50000, 100000, 500000, 1000000};
        int reps = 1000;
        for (int size : sizes) {
            List<Integer> nums = genNums(size);
            long avgTime = measureTime(() -> Main._sum(nums), reps);
            System.out.println("Sum функция для " + size + " элементов работает в среднем: " + avgTime + " мс");
        }
    }

    @Test
    public void testPerfMult() {
        int[] sizes = {100, 500, 1000, 5000, 10000, 50000, 100000, 500000, 1000000};
        int reps = 1000;
        for (int size : sizes) {
            List<Integer> nums = genNums(size);
            long avgTime = measureTime(() -> Main._mult(nums), reps);
            System.out.println("Mult функция для " + size + " элементов работает в среднем: " + avgTime + " мс");
        }
    }

}
