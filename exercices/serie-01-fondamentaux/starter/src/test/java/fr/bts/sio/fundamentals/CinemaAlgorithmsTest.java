package fr.bts.sio.fundamentals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Disabled("Retirer progressivement cette annotation pendant l'atelier 4")
class CinemaAlgorithmsTest {
    @Test
    void formatsDurationWithHoursAndMinutes() {
        assertEquals("2 h 22", CinemaAlgorithms.formatDuration(142));
    }

    @Test
    void rejectsNegativeDuration() {
        assertThrows(IllegalArgumentException.class,
                () -> CinemaAlgorithms.formatDuration(-1));
    }

    @Test
    void computesFibonacciFromDefinedOrigin() {
        assertAll(
                () -> assertEquals(0, CinemaAlgorithms.fibonacci(0)),
                () -> assertEquals(1, CinemaAlgorithms.fibonacci(1)),
                () -> assertEquals(55, CinemaAlgorithms.fibonacci(10))
        );
    }

    @Test
    void producesPrimeNumbersUpToLimit() {
        assertArrayEquals(new int[]{2, 3, 5, 7}, CinemaAlgorithms.sieve(10));
    }

    @Test
    void searchesInSortedArray() {
        int[] values = {2, 4, 8, 15, 16, 23, 42};
        assertEquals(3, CinemaAlgorithms.binarySearch(values, 15));
        assertEquals(-1, CinemaAlgorithms.binarySearch(values, 7));
    }

    @Test
    void recognizesNormalizedPalindrome() {
        assertTrue(CinemaAlgorithms.isPalindrome("Ésope reste ici et se repose"));
        assertFalse(CinemaAlgorithms.isPalindrome("CinéDesk"));
    }
}
