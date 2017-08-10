package cn.meijunjie.quartz;



import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;


public class SimpleExample {

    public void run() throws Exception
    {


        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();



        Date runTime = evenMinuteDate(new Date());



        JobDetail job = newJob(SimpleJob.class).withIdentity("job1","group1").build();

        Trigger trigger = newTrigger().withIdentity("trigger1","group1").startAt(runTime).build();

        scheduler.scheduleJob(job,trigger);

        scheduler.start();


//        scheduler.shutdown(true);

    }

    public static void main(String[] args) throws Exception {
        SimpleExample example = new SimpleExample();
        example.run();
    }
}
