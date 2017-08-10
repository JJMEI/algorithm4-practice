package cn.meijunjie.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class HelloJob implements Job{


    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("Hello World! - " + new Date());
    }
}
