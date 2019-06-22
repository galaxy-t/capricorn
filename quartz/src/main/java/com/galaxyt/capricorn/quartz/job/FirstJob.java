package com.galaxyt.capricorn.quartz.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstJob implements Job {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("111" + sdf.format(new Date()));
    }


    public static void main(String[] args) {

        try {
            //初始化任务调度器
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();



            JobDetail jobDetail = JobBuilder.newJob(FirstJob.class).withIdentity("myJob", "myGroup").build();


            SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();

            Trigger trigger = TriggerBuilder.newTrigger().startNow().withSchedule(scheduleBuilder).build();

            scheduler.scheduleJob(jobDetail, trigger);

        } catch (SchedulerException e) {
            e.printStackTrace();
        }


    }


}
