package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static pairmatching.domain.Course.BACKEND;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Pair 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PairTest {

    @Test
    void isAlreadyPair_메서드는_입력받은_크루들이_해당_페어에_2명이상_존재하는_경우_true를_반환한다() {
        Crew crew1 = new Crew(BACKEND, "사과");
        Crew crew2 = new Crew(BACKEND, "바나나");
        Crew crew3 = new Crew(BACKEND, "포도");
        Pair pair = new Pair(List.of(crew1, crew2, crew3));

        boolean result = pair.isAlreadyPair(List.of(crew2, crew3));

        assertThat(result).isTrue();
    }

    @Test
    void isAlreadyPair_메서드는_입력받은_크루들이_해당_페어에_2명이상_존재하지_않는_경우_false를_반환한다() {
        Crew crew1 = new Crew(BACKEND, "사과");
        Crew crew2 = new Crew(BACKEND, "바나나");
        Pair pair = new Pair(List.of(crew1, crew2));

        boolean result = pair.isAlreadyPair(List.of(crew2));

        assertThat(result).isFalse();
    }

    @Test
    void getCrewName_메서드는_크루들의_이름을_반환한다() {
        Crew crew1 = new Crew(BACKEND, "사과");
        Crew crew2 = new Crew(BACKEND, "바나나");
        Pair pair = new Pair(List.of(crew1, crew2));

        List<String> result = pair.getCrewName();

        assertThat(result).containsExactly("사과", "바나나");
    }
}
