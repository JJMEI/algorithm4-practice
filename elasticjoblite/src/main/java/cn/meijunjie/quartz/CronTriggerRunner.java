package cn.meijunjie.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class CronTriggerRunner {
    public static void main(String[] args) throws Exception
    {

        //创建一个具体的Job
        JobDetail job_1 = JobBuilder.newJob(SimpleJob.class)
                .withIdentity("dummyJobName_1","group1")
                .build();

        JobDetail job_2 = JobBuilder.newJob(SimpleJob.class)
                .withIdentity("dummyJobName_2","group1")
                .build();

        JobDetail job_3 = JobBuilder.newJob(SimpleJob.class)
                .withIdentity("dummyJobName_3","group1")
                .build();

        //构建一个触发器
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("dummyTriggerName","group1")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                .build();

        //构建一个调度器
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        //启动容器
        scheduler.start();

        //注入任务和触发器
        scheduler.scheduleJob(job_2,trigger);
    }
}
