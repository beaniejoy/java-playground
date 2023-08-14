package io.beaniejoy.collection;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ArrayListTest {

    @DisplayName("ArrayList의 equals는 순서포함해서 원소들이 동일한지 비교한다.")
    @Test
    void returnEqualsTrueWhenSameOrderElements() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4);

        assertThat(list1.equals(list2)).isTrue();
        assertThat(list1).isEqualTo(list2);
    }
}
