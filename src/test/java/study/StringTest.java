package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");

        String[] test1 = "1,2".split(",");
        assertThat(test1).contains("1", "2");

        String[] test1_2 = "1".split(",");
        assertThat(test1_2).containsExactly("1");

        String test2 = "(1,2)".substring(1,4);
        assertThat(test2).isEqualTo("1,2");

    }

    @Test
    @DisplayName("OOB Exception")
    void OOBTest() {
        String test3 = "abc";
        assertThat(test3).contains("a");
        assertThatThrownBy(() -> {
           char val = test3.charAt(4);
           throw new Exception("Out of Bounds");
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 2, Size: 2");
    }

    @Test
    @DisplayName("OOB2")
    void OOBTest2() {
        String test4 = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char val = test4.charAt(2);
                    throw new IndexOutOfBoundsException("Out of Bounds!!");
                }).withMessageMatching("Index: 2, size: 2");
    }
}
