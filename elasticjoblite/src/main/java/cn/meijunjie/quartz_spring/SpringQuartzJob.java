package cn.meijunjie.quartz_spring;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class SpringQuartzJob extends QuartzJobBean {

    private boolean isRunning = false;

    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        if(!isRunning)
        {
            System.out.println("开始进行。。。。");
            isRunning = true;

            //do something
            System.out.println("do something.....");

            isRunning = false;
        }
    }
}
