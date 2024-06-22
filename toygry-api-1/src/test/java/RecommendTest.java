import com.example.toygry.dto.RecommendResponse;
import com.example.toygry.entity.Recommend;
import com.example.toygry.repository.RecommendRepository;
import com.example.toygry.service.RecommendService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RecommendTest {

    @Mock
    private RecommendRepository recommendRepository;

    @InjectMocks
    private RecommendService recommendService;


    @Test
    void myTest() {
        //given 실행할때 필요한거
        String input = "jungry";

        //when 실제로 테스트를 수행해야하는 코드 (1) 코드를 그대로 가져오거나 (2) 객체로 가져와서 실행하거나
//        String output = recommendService.getString(input);
        String output = this.getString(input);



        //then
//        assertThat(output)

    }

    private String getString(String string) {
        return string;
    }

    @Test
    void getRecommend() {

        // given
        String id = "52a1a6b0-8967-4162-845f-ec6d5085d80a";
        // when
        Recommend recommend = recommendRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("recommend not found"));


        // then
//        Assertions.assertThat(output).isNotNull();
    }

}


/*
public 안해도됨 => test 코드 안에서만 돌기 때문에 딱히 .. 필요 없멘...
자바 코드 테스트 vs 스프링 테스트
코드 : 그냥 코드 테스트 어쩍저쩍오
스프링 : 빈이 생성되고 어쩌구 ,,, 스프링 실행하는척 해가지고 테스트 함

repository ㄱ가 필요없을때 가상의 빈을 넣어줄 수 있음 어 일단 패스 ..
db 접근을 해야하는 경우에 sqllite 같은 인메모리 로 할 수 있고
아니면 ㄹㅇ 접근하는거임 ~
 */
