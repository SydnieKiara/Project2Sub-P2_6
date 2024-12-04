package tests;

import org.junit.jupiter.api.Test;
import src.UtilityFunctions;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for UtilityFunctions methods.
 */
public class UtilityFunctionsTest {

    @Test
    public void testGenerateRandomList() {
        List<Integer> randomList = UtilityFunctions.generateRandomList(10);
        assertEquals(10, randomList.size(), "List size should match the parameter.");
        assertTrue(randomList.stream().allMatch(num -> num >= 0 && num < 100),
                "All numbers should be between 0 and 99.");
    }

    @Test
    public void testGenerateRandomListNegativeSize() {
        assertThrows(IllegalArgumentException.class, () -> {
            UtilityFunctions.generateRandomList(-5);
        }, "Should throw IllegalArgumentException for negative sizes.");
    }

    @Test
    public void testCountOccurrences() {
        List<Integer> list = List.of(1, 2, 2, 3, 3, 3);
        Map<Integer, Integer> occurrences = UtilityFunctions.countOccurrences(list);
        assertEquals(1, occurrences.get(1), "Count for 1 should be 1.");
        assertEquals(2, occurrences.get(2), "Count for 2 should be 2.");
        assertEquals(3, occurrences.get(3), "Count for 3 should be 3.");
    }

    @Test
    public void testCountOccurrencesNullInput() {
        assertThrows(NullPointerException.class, () -> {
            UtilityFunctions.countOccurrences(null);
        }, "Should throw NullPointerException for null input.");
    }

    @Test
    public void testSortListAscending() {
        List<Integer> unsorted = List.of(5, 3, 8, 1, 2);
        List<Integer> sorted = UtilityFunctions.sortListAscending(unsorted);
        assertEquals(List.of(1, 2, 3, 5, 8), sorted, "List should be sorted in ascending order.");
    }

    @Test
    public void testSortListAscendingNullInput() {
        assertThrows(NullPointerException.class, () -> {
            UtilityFunctions.sortListAscending(null);
        }, "Should throw NullPointerException for null input.");
    }
}