import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * description:
 * created by qianchaochen at 2020-10-7
 */

// 指定Spring 给Junit 提供的运行器类
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml"})
public class CrowdSpringTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testConnection () throws Exception {
        System.out.println(dataSource.getConnection());
    }
}
