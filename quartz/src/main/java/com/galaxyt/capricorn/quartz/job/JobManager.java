package com.galaxyt.capricorn.quartz.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class JobManager {


    private Scheduler scheduler = null;


    public JobManager() {
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }


    public void addJob(String name,String group,String classPath,String cron) throws Exception {

        Class jobClass = Class.forName(classPath);

        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(name, group).build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        Trigger trigger = TriggerBuilder.newTrigger().startNow().withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, trigger);
    }


    public void start() {
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {


        JobManager jobManager = new JobManager();

        jobManager.addJob("a","c","com.galaxyt.capricorn.quartz.job.FirstJob","0/2 * * * * ?");
        jobManager.addJob("b","c","com.galaxyt.capricorn.quartz.job.SecondJob","0/2 * * * * ?");

        jobManager.start();

    }



}
