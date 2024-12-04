package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * UtilityFunctions provides methods for generating random integers,
 * counting occurrences of integers in a list, and sorting lists in ascending order.
 */
public class UtilityFunctions {

    /**
     * Generates a list of random integers.
     * Each integer is generated using Java's Random class and ranges from 0 to 99.
     *
     * @param size The size of the list to generate.
     * @return A list of random integers of the specified size.
     * @throws IllegalArgumentException if the size is negative.
     */
    public static List<Integer> generateRandomList(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size cannot be negative.");
        }
        Random random = new Random();
        List<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randomList.add(random.nextInt(100)); // Numbers between 0 and 99
        }
        return randomList;
    }

    /**
     * Counts the occurrences of each integer in a list.
     * The result is a map where the keys are the integers from the list,
     * and the values are the number of times they appear in the list.
     *
     * @param list The input list of integers.
     * @return A map where each key is an integer from the list,
     *         and the value is the frequency of that integer.
     * @throws NullPointerException if the input list is null.
     */
    public static Map<Integer, Integer> countOccurrences(List<Integer> list) {
        if (list == null) {
            throw new NullPointerException("List cannot be null.");
        }
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : list) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }
        return occurrences;
    }

    /**
     * Sorts a list of integers in ascending order.
     * The sorting is done using Java's Stream API.
     *
     * @param list The list of integers to sort.
     * @return A new list containing the integers from the input list, sorted in ascending order.
     * @throws NullPointerException if the input list is null.
     */
    public static List<Integer> sortListAscending(List<Integer> list) {
        if (list == null) {
            throw new NullPointerException("List cannot be null.");
        }
        return list.stream().sorted().collect(Collectors.toList());
    }
}

