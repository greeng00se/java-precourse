package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Crew 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CrewTest {

    @Test
    void isSameCourse_메서드는_입력받는_코스와_동일한지_비교하여_결과를_반환한다() {
        Crew crew = new Crew(Course.BACKEND, "GG");

        assertThat(crew.isSameCourse(Course.BACKEND)).isTrue();
    }

    @Test
    void getName_메서드는_이름을_반환한다() {
        Crew crew = new Crew(Course.BACKEND, "GG");

        assertThat(crew.getName()).isEqualTo("GG");
    }
}
