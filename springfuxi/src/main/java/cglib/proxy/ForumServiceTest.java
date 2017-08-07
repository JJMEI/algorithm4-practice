package cglib.proxy;

import jdk.proxy.ForumService;
import jdk.proxy.ForumServiceImpl;
import org.junit.Test;

public class ForumServiceTest {

    @Test
    public void proxy()
    {
        CglibProxy proxy = new CglibProxy();

        ForumServiceImpl forumServicev = (ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);

        forumServicev.removeForum(10);
        forumServicev.removeTopic(332);

    }
}
