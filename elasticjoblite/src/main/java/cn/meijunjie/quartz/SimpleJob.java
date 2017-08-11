package cn.meijunjie.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

import java.util.Date;

public class SimpleJob implements Job {

    String sayHello;
    String sayTrigger;

    public void setSayHello(String sayHello) {
        this.sayHello = sayHello;
    }

    public void setSayTrigger(String sayTrigger) {
        this.sayTrigger = sayTrigger;
    }


    public void execute(JobExecutionContext context) throws JobExecutionException {
//        System.out.println(context.getTrigger().getCalendarName() + "triggered. time is:"+ new Date());

        JobKey jobKey = context.getJobDetail().getKey();

        System.out.println("SimpleJob says: " + jobKey + " executing at  " + new Date());

        throw new JobExecutionException("Testing Exception......");

//        System.out.println(context.getJobDetail().getDescription().toString()+"\n");
//        System.out.println(context.getJobDetail().getJobDataMap().get("sayHello"));

        //使用JobFactory实现数据的自动“注入”,JobFactory能够实现，主要是注入JobDataMap中的数据，在Job类中设置JobDataMap中的key作为
//        //字段并设置Setter方法
//        System.out.println(sayHello + "\n");
//
//        System.out.println(sayTrigger + "\n");
    }
}
