package test;

import com.kc.CmsPortalApplication;
import com.kc.portal.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.locks.ReentrantLock;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CmsPortalApplication.class)
public class TestDB {

    @Autowired
    private UserMapper userMapper;

    @Test
    public  void test(){
        //userMapper.insetUser();

        int count = userMapper.selectCount();

        System.out.println(count);
    }

    @Test
    public  void testRetreenLock(){
        ReentrantLock lock = new ReentrantLock();   // 创建ReentrantLock实例对象
    }


}
