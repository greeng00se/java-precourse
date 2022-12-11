package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("PairMatchingMachine 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PairMatchingMachineTest {

    private static Pair generatePair() {
        Crew crew1 = new Crew(Course.BACKEND, "Crew1");
        Crew crew2 = new Crew(Course.BACKEND, "Crew2");
        return new Pair(List.of(crew1, crew2));
    }

    @Test
    void generate_메서드는_페어_진행_이력이_존재하는_페어를_생성했을_때_예외를_던진다() {
        List<String> crewName = List.of("Crew1", "Crew2");
        Pair pair = generatePair();
        Pairs pairs = new Pairs(List.of(pair));

        assertThatThrownBy(() -> PairMatchingMachine.generate(crewName, Course.BACKEND, pairs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("페어 매칭에 실패하였습니다.");
    }

    @Test
    void generate_메서드는_크루명_코스_해당_레벨에_존재하는_페어들을_입력받아_페어매칭을_진행하고_동일한_페어가_있는지_검사한다() {
        List<String> crewName = List.of("Crew1", "Crew2", "Crew3", "Crew4", "Crew5");
        Pairs pairs = new Pairs(List.of());

        List<Pair> result = PairMatchingMachine.generate(crewName, Course.BACKEND, pairs);

        assertThat(result).hasSize(2);
    }
}
