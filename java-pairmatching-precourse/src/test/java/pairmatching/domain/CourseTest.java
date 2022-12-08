package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Course Enum")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CourseTest {

    @Test
    void names_메서드는_Course명을_반환한다() {
        List<String> courseNames = Course.names();

        assertThat(courseNames).containsExactly("백엔드", "프론트엔드");
    }

    @Test
    void from_메서드는_올바른_Course명을_입력받지_못하면_IllegalArgumentException을_던진다() {
        assertThatThrownBy(() -> Course.from("백"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void from_메서드는_올바른_Course명을_입력받으면_인스턴스를_반환한다() {
        Course course = Course.from("백엔드");

        assertThat(course).isEqualTo(Course.BACKEND);
    }
}
