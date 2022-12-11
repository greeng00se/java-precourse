package pairmatching.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static pairmatching.domain.Course.BACKEND;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import pairmatching.domain.Crew;

@DisplayName("CrewRepository 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CrewRepositoryTest {

    private CrewRepository crewRepository = new CrewRepository();

    @BeforeEach
    void setup() {
        crewRepository.clear();
    }

    @Test
    void saveAll_메서드는_입력받은_모든_크루를_저장한다() {
        Crew crew1 = new Crew(BACKEND, "홍길동");
        Crew crew2 = new Crew(BACKEND, "거위");

        crewRepository.saveAll(List.of(crew1, crew2));

        assertThat(crewRepository.findAllNameByCourse(BACKEND)).hasSize(2);
    }

    @Test
    void findAllNameByCourse_메서드는_해당_코스의_크루들을_이름을_모두_반환한다() {
        Crew crew1 = new Crew(BACKEND, "홍길동");
        Crew crew2 = new Crew(BACKEND, "거위");
        crewRepository.saveAll(List.of(crew1, crew2));

        List<String> result = crewRepository.findAllNameByCourse(BACKEND);

        assertThat(result).containsExactly("홍길동", "거위");
    }
}
