import org.junit.Test;
import static org.junit.Assert.*;
public class TestSort {
    @Test
    public void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expect = {"an", "egg", "have", "i"};
        Sort.sort(input);
        assertArrayEquals(expect, input);
    }
    @Test
    public void testFindSmallest() {
        String[] input = {"i", "have", "an", "egg"};
        int expect = 2;
        int actual = Sort.findSmallest(input, 0);
        assertEquals(expect, actual);
        String[] input2 = {"there", "have", "many", "zoos"};
        int expect2 = 2;
        int actual2 = Sort.findSmallest(input2, 2);
        assertEquals(expect2, actual2);
    }
    @Test
    public void testSwap() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expect = {"an", "have", "i", "egg"};
        int a = 0;
        int b = 2;
        Sort.swap(input, a, b);
        assertArrayEquals(expect, input);
    }
}