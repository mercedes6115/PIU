package pickitup.controller.user;

import com.example.pickitup.controller.OrderController;
import com.example.pickitup.domain.vo.product.productFile.ProductVO;
import com.example.pickitup.domain.vo.user.OrderVO;
import com.example.pickitup.domain.vo.user.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class OrderControllerTests {
    @Autowired
    private OrderController orderController;

    @Test
    public void storeTest(){
        OrderVO orderVO = new OrderVO();
        ProductVO productVO = new ProductVO();
        UserVO userVO = new UserVO();
        orderController.store(userVO,orderVO,productVO);
    }

}
