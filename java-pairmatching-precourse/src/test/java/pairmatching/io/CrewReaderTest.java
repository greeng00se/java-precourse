package pairmatching.io;

import java.io.IOException;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("CrewReader")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CrewReaderTest {

    @Test
    void readBackend_메서드는_백엔드_크루의_이름을_반환한다() throws IOException {
        List<String> backend = CrewReader.readBackend();

        Assertions.assertThat(backend).containsExactly(
                "백호", "태웅", "치수", "태섭", "대만",
                "준호", "대협", "덕규", "태산", "경태",
                "수겸", "현준", "준섭", "한나", "소연",
                "호열", "대남", "용팔", "구식", "달재"
        );
    }

    @Test
    void readBackend_메서드는_프론트엔드_크루의_이름을_반환한다() throws IOException {
        List<String> frontend = CrewReader.readFrontend();

        Assertions.assertThat(frontend).containsExactly(
                "보노", "시저", "쉐리", "신디", "다비",
                "덴버", "이브", "제시", "라라", "린다",
                "리사", "니콜", "로드", "윌터", "제키"
        );
    }
}
