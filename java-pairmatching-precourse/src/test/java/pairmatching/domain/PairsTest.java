package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Pairs 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PairsTest {

    @Test
    void isAlreadyPairing_메서드는_입력받은_크루들이_페어를_한_적이_있는_경우_true를_반환한다() {
        Pair pair = new Pair(List.of(new Crew(Course.BACKEND, "김밥"), new Crew(Course.BACKEND, "떡볶이")));
        Pairs pairs = new Pairs(List.of(pair));

        boolean result = pairs.isAlreadyPairing(pair);

        assertThat(result).isTrue();
    }

    @Test
    void isAlreadyPairing_메서드는_입력받은_크루들이_페어를_한_적이_없는_경우_false를_반환한다() {
        Pair pair1 = new Pair(List.of(new Crew(Course.BACKEND, "김밥"), new Crew(Course.BACKEND, "떡볶이")));
        Pair pair2 = new Pair(List.of(new Crew(Course.BACKEND, "김밥"), new Crew(Course.BACKEND, "라면")));
        Pairs pairs = new Pairs(List.of(pair1));

        boolean result = pairs.isAlreadyPairing(pair2);

        assertThat(result).isFalse();
    }
}
