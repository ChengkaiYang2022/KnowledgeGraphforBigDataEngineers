package com.github.yck.chapter_02_lock.sync.resource.deadlock;

import com.github.yck.chapter_02_lock.sync.resource.TicketTestBase;

/**
 * https://www.baeldung.com/java-deadlock-livelock
 * @see ReentrantDeadLock
 * @see SyncDeadLock
 *
 */
public class Client extends TicketTestBase {
    public static void main(String[] args) {

        test2ThreadOf2Method(new SyncDeadLock());
//        test2ThreadOf2Method(new ReentrantDeadLock());
    }





}
