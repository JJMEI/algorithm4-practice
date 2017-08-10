package cn.meijunjie.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class SimpleJobListener implements JobListener{

    private static final String LISTENER_NAME = "dummyJobListenerName";

    public String getName() {
        return LISTENER_NAME;
    }

    public void jobToBeExecuted(JobExecutionContext context) {
            String jobName = context.getJobDetail().getKey().toString();

            System.out.println("jobToBeExcuted");

            System.out.println("Job: " + jobName + " is going to start....");
    }

    public void jobExecutionVetoed(JobExecutionContext context) {
        System.out.println("jobExcutionVetoed");
    }

    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        System.out.println("jobWasExecuted");
        String jobName = context.getJobDetail().getKey().toString();

        System.out.println("Job: " + jobName + "is finished...");

        if(!jobException.getMessage().equals(""))
        {
            System.out.println("Exception thrown by: "+jobName + " Exception: " + jobException.getMessage());
        }
    }
}
