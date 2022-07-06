import com.jchao.springcloud.PaymentMain8001;
import com.jchao.springcloud.entities.Payment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @author ChangJinchao
 * @create 2022-07-01 14:55
 */

@SpringBootTest(classes = {PaymentMain8001.class} )
public class lambdaTest {



    @Test
    public void Test(){
        String a = "";
        Map<String,Object> map = new HashMap<>();
        map.put("k1","v1");
        map.put("k2","v2");
        map.put("k3","v3");
        map.forEach(new BiConsumer<String, Object>() {

            @Override
            public void accept(String s, Object o) {
                System.out.println(s+":"+o);
            }
        });

//        map.forEach((k,v) -> { System.out.println(k+":"+v);});
//        LambdaQueryWrapper<Payment> lqw = new LambdaQueryWrapper<Payment>();
//        lqw.select(Payment::getId);
//        List<Payment> payments = paymentDao.selectList(lqw);
//        payments.forEach(System.out::println);
    }

}
