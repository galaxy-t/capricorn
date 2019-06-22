package com.galaxyt.capricorn.quartz.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SecondJob implements Job {


    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("222" + sdf.format(new Date()));
    }


    public static void main(String[] args) {

        try {
            //初始化任务调度器
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            JobDetail jobDetail = JobBuilder.newJob(FirstJob.class).withIdentity("myJob", "myGroup").build();

            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/2 * * * * ?");

            Trigger trigger = TriggerBuilder.newTrigger().startNow().withSchedule(scheduleBuilder).build();

            scheduler.scheduleJob(jobDetail, trigger);

        } catch (SchedulerException e) {
            e.printStackTrace();
        }


    }

}
