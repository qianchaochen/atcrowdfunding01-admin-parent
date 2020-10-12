import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml", "classpath:spring-persist-tx.xml"})
public class CrowdSpringTest {

    public final Logger logger = LoggerFactory.getLogger(CrowdSpringTest.class);

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;

    @Test
    public void testTx(){
        Admin admin = new Admin(null, "test", "test123", "测试", "test@qq.com", null);
        adminService.saveAdmin(admin);
    }

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
        List<Admin> admins = adminMapper.selectByUserNameLike("");
        for (Admin admin : admins) {
            System.out.println(admin);
            logger.debug("debug: " + admin);
            logger.info("info: " + admin);
            logger.warn("warn: " + admin);
            logger.error("error: " + admin);

        }
    }

    /**
     * 测试数据库连接的获取情况
     *
     */
    @Test
    public void testConnection () throws Exception {
        System.out.println(dataSource.getConnection());
    }
}
