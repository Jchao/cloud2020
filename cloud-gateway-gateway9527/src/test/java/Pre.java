import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * @author ChangJinchao
 * @create 2022-07-05 17:03
 */
public class Pre {

    @Test
    public void Test(){
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
    }
}
