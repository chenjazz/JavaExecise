package com.chenjazz.Java并发编程的艺术.第4章;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 线程的优先级
 */
public class Priority {
    private static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;

    public static void main(String[] args) throws InterruptedException {

        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int prority = (i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY);
            Job job = new Job(prority);
            jobs.add(job);

            Thread thread = new Thread(job, "Th:" + i);
            thread.setPriority(prority);
            thread.start();
        }

        notStart = false;
        TimeUnit.SECONDS.sleep(10);

        notEnd = false;


        for (Job job : jobs) {
            System.out.println("job priority " + job.priority + " Count:" + job.jobCount);
        }

    }

    static class Job implements Runnable {
        private int priority;

        private long jobCount;

        public Job(int priority) {
            this.priority = priority;
        }

        @Override
        public void run() {

            while (notStart) {
                Thread.yield();
            }

            while (notEnd) {
                Thread.yield();
                jobCount++;
            }

        }
    }
}
