package com.github.yck.chapter_02_03_04_08.sync;

import com.github.yck.chapter_02_03_04_08.Tickets;

/**
 * volatile 修饰，这里设计 JMM TODO。
 */
public class VolatileTicketsImpl implements Tickets {


    private volatile int ticketNum = 100;
    @Override
    public boolean sale() {
        if (ticketNum>0){
            ticketNum--;
            System.out.println(Thread.currentThread().getName()
                    +"卖出一张，剩余"+ticketNum);
            return true;
        }else {
            return false;
        }
    }
}
