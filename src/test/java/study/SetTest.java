package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        int size = 5;
        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }
    }

    @Test
    void testSize() {
        assertThat(numbers.size()).isEqualTo(5);
    }

    @Test
    void testContains1() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void testContains2(int argument) {
        assertThat(numbers.contains(argument)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"1,2,3", "4,5,6"})
    void testResult(Integer num1, Integer num2, Integer num3) {
        assertThat(numbers.contains(num1)).isTrue();
        assertThat(numbers.contains(num2)).isTrue();
        assertThat(numbers.contains(num3)).isTrue();
    }
}
