package jdk.proxy;

public class ForumServiceImpl implements  ForumService {


    //横切抽取点

    public void removeTopic(int topicId) {

        System.out.println("模拟删除Topic记录..." + topicId);

        try
        {
            Thread.currentThread().sleep(20);
        }catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }


    public void removeForum(int forumId) {

        System.out.println("模拟删除Forum记录..." + forumId);

        try
        {
            Thread.currentThread().sleep(40);
        }catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}
