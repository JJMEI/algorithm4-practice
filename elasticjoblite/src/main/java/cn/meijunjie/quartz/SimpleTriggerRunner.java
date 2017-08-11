package cn.meijunjie.quartz;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;
import static org.quartz.CronScheduleBuilder.*;
import static  org.quartz.DateBuilder.*;

public class SimpleTriggerRunner {
    public static void main(String[] args) throws SchedulerException {


        //创建一个具体的Job
//        JobDetail job_1 = JobBuilder.newJob(SimpleJob.class)
//                .withIdentity("dummyJobName_1","group1")
//                .build();

        //Scheduler并不接收一个job接口的实现类，它需要更多的信息，因此JobDetail来完成这一工作，JobDetail包含了很多任务相关的信息，Quartz内部
        //通过反射机制调用class对象的newInstance()方法实例化job对象，因此Job任务类中必须包含无参的构造函数
        JobDetail job_2 = newJob(SimpleJob.class)
                .withIdentity("dummyJobName_2","group1")
                .withDescription("fire the way")
                .usingJobData("sayHello","Hello, I saved in JobDataMap")
                .build();

//        JobDetail job_3 = JobBuilder.newJob(SimpleJob.class)
//                .withIdentity("dummyJobName_3","group1")
//                .build();

        //构建一个触发器
        Trigger trigger = newTrigger()
                .withIdentity("dummyTriggerName","group1")
                .withDescription("I am a trigger to decide the time about how to run this job!")
                .usingJobData("sayTrigger","我是你Trigger爹")
                .startAt(futureDate(5,IntervalUnit.MINUTE))
                .withSchedule(
                        simpleSchedule()
                        .withIntervalInSeconds(5).withRepeatCount(10))
                .build();



        //构建一个Scheduler容器
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        //启动容器
        scheduler.start();

        //注入任务和触发器
        scheduler.scheduleJob(job_2,trigger);

    }
}
