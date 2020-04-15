import java.time.ZonedDateTime;

/**
 * @author 王柳
 * @date 2020/4/15 16:35
 */
public class Test {

    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
        // 2020-04-15T16:42:02.866+08:00[Asia/Shanghai]
    }
}
