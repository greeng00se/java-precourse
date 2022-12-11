package pairmatching;

import static java.util.stream.Collectors.toList;
import static pairmatching.domain.Level.LEVEL1;
import static pairmatching.domain.Level.LEVEL2;
import static pairmatching.domain.Level.LEVEL4;

import java.util.List;
import pairmatching.controller.PairMatchingController;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Mission;
import pairmatching.io.CrewReader;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.MissionRepository;
import pairmatching.repository.PairMatchingRepository;
import pairmatching.service.PairMatchingCommandService;
import pairmatching.service.PairMatchingQueryService;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        PairMatchingController pairMatchingController = new PairMatchingController(
                pairMatchingCommandService(),
                pairMatchingQueryService()
        );
        pairMatchingController.run();
    }

    private static PairMatchingCommandService pairMatchingCommandService() {
        return new PairMatchingCommandService(crewRepository(), missionRepository(), pairMatchingRepository());
    }

    private static PairMatchingQueryService pairMatchingQueryService() {
        return new PairMatchingQueryService(missionRepository(), pairMatchingRepository());
    }

    private static CrewRepository crewRepository() {
        CrewRepository crewRepository = new CrewRepository();
        crewRepository.saveAll(toCrewList(CrewReader.readBackend(), Course.BACKEND));
        crewRepository.saveAll(toCrewList(CrewReader.readFrontend(), Course.FRONTEND));
        return crewRepository;
    }

    private static List<Crew> toCrewList(List<String> crews, Course course) {
        return crews.stream()
                .map(name -> new Crew(course, name))
                .collect(toList());
    }

    private static MissionRepository missionRepository() {
        MissionRepository missionRepository = new MissionRepository();
        missionRepository.saveAll(List.of(
                new Mission(LEVEL1, "자동차경주"),
                new Mission(LEVEL1, "로또"),
                new Mission(LEVEL1, "숫자야구게임"),
                new Mission(LEVEL2, "장바구니"),
                new Mission(LEVEL2, "결제"),
                new Mission(LEVEL2, "지하철노선도"),
                new Mission(LEVEL4, "성능개선"),
                new Mission(LEVEL4, "배포")
        ));
        return missionRepository;
    }

    private static PairMatchingRepository pairMatchingRepository() {
        return new PairMatchingRepository();
    }
}
