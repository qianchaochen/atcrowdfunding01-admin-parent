import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.mapper.AdminMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;

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

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 测试根据id来进行查找
     */
    @Test
    public void testSelectById(){
        Admin admin = adminMapper.selectByPrimaryKey(1);
        System.out.println(admin);
    }

    /**
     * 测试插入功能
     */
    @Test
    public void testInsertAdmin(){
        Admin admin = new Admin(null, "qkx", "20160429", "钱可馨", "qiankexin@126.com", null);
        int insertCount = adminMapper.insert(admin);
        System.out.println("插入的记录条数为：" + insertCount);
    }

    /**
     * 测试根据昵称来进行模糊匹配
     */
    @Test
    public void testSelectByUserNameLike(){
        List<Admin> admins = adminMapper.selectByUserNameLike("钱");
        for (Admin admin : admins) {
            System.out.println(admin);
        }
    }

    /**
     * 测试数据库连接的获取情况
     * @throws Exception
     */
    @Test
    public void testConnection () throws Exception {
        System.out.println(dataSource.getConnection());
    }
}
