import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.mapper.project.projectFile.ProjectMapper;

import com.example.pickitup.mapper.project.projectReview.ProjectReviewMapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
public class ProjectMapperTests {

    @Autowired
    private ProjectMapper projectMapper;



    // 모든 목록 테스트
    @Test
    public void getListTest(){
        projectMapper.getList().stream().map(ProjectVO::toString).forEach(log::info);
    }

    @Test
    public void getDetailTest(){
        log.info("TEST"+projectMapper.getDetail(1L));
    }

    @Test
    public void getqwerqerqer(){
        log.info("======="+projectMapper.adminStatistics("2022-06-23"));
    }


}




