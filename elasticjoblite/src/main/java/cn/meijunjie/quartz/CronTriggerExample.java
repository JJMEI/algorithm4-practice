package cn.meijunjie.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

public class CronTriggerExample {

    public static void main(String[] args) throws SchedulerException {
        JobKey jobKey = new JobKey("dummyJobName","group1");



        JobDetail job = JobBuilder.newJob(SimpleJob.class).withIdentity(jobKey).build();

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("dummyTriggerName","group1")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("0/5 * * * * ?")
                )
                .build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        scheduler.getListenerManager().addJobListener(
                new SimpleJobListener(), KeyMatcher.keyEquals(jobKey)
        );

        scheduler.start();
        scheduler.scheduleJob(job,trigger);
    }
}
