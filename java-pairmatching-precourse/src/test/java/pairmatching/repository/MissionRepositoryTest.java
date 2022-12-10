package pairmatching.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static pairmatching.domain.Level.LEVEL1;
import static pairmatching.domain.Level.LEVEL5;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import pairmatching.domain.Mission;

@DisplayName("MissionRepository 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MissionRepositoryTest {

    private MissionRepository missionRepository = new MissionRepository();

    @BeforeEach
    void setup() {
        missionRepository.clear();
    }

    @Test
    void saveAll_메서드는_입력받은_모든_미션을_저장한다() {
        Mission mission1 = new Mission(LEVEL1, "야구게임");
        Mission mission2 = new Mission(LEVEL5, "콜라 키우기");

        missionRepository.saveAll(List.of(mission1, mission2));

        assertThat(missionRepository.findAll()).hasSize(2);
    }

    @Test
    void findByLevelAndName_메서드는_입력받은_레벨과_미션명에_해당되는_미션이_없다면_예외를_던진다() {
        assertThatThrownBy(() -> missionRepository.findByLevelAndName(LEVEL1, "거위"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("미션이 존재하지 않습니다.");
    }

    @Test
    void findByLevelAndName_메서드는_입력받은_레벨과_미션명에_해당되는_미션을_반환한다() {
        Mission mission = new Mission(LEVEL1, "야구게임");
        missionRepository.saveAll(List.of(mission));

        Mission findMission = missionRepository.findByLevelAndName(LEVEL1, "야구게임");

        assertThat(findMission).isEqualTo(mission);
    }

    @Test
    void findAll_메서드는_저장된_모든_미션을_반환한다() {
        Mission mission1 = new Mission(LEVEL1, "야구게임");
        Mission mission2 = new Mission(LEVEL5, "사이다 마시기");
        missionRepository.saveAll(List.of(mission1, mission2));

        assertThat(missionRepository.findAll()).containsExactly(mission1, mission2);
    }
}
