package com.github.yck.pattern.creational.singleton.type4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Singleton4 {
    public static void main(String[] args) {
//        System.out.println(SingletonLazy3.getInstance().hashCode());
//        System.out.println(SingletonLazy3.getInstance().hashCode());

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Thread t = new Thread(new Runner());
            threads.add(t);
        }
        threads.forEach(Thread::start);
    }
}

/**
 * 这里是一个测试类，
 * 其中 HashSet 是线程安全的，调用 SingletonLazy 不是线程安全的。
 */
class Runner implements Runnable{
    private static Set<Integer> set = new HashSet<>();
    @Override
    public void run() {
        SingletonLazy4 instance = SingletonLazy4.getInstance();
        System.out.println(instance.hashCode());
            synchronized (Runner.class){
                set.add(instance.hashCode());
                System.out.println(set);
            }
    }
}

/**
 * 线程安全解决途径：synchronized（同步代码） + volatile（指令重排）
 */
class SingletonLazy4 {

    private static volatile SingletonLazy4 singletonLazy3;

    private SingletonLazy4(){}

    /**
     * @return 这里线程不安全，有 if 时候，多线程进入 if 后
     * 就不是一个实例喽
     */
    public synchronized static SingletonLazy4 getInstance(){
        if ( singletonLazy3 == null ){
            // 这一步不是原子操作，字节码有三行，容易有指令重排的可能性
            singletonLazy3 = new SingletonLazy4();
        }
        return singletonLazy3;
    }


}
