package com.github.yck.pattern.creational.factory.improve.methodfactory.factory;

import com.github.yck.pattern.creational.factory.improve.methodfactory.pizzas.CheesePizza;
import com.github.yck.pattern.creational.factory.improve.methodfactory.pizzas.ChinaPizza;
import com.github.yck.pattern.creational.factory.improve.methodfactory.pizzas.Pizza;

public class MethodFactoryImplBeijing extends MethodFactory {
    /**
     *
     * 根据地区自己调整生产什么 pizza
     * 这里符合了开闭原则
     * @param type
     * @return
     */
    @Override
    public Pizza createPizza(String type) {
        Pizza p = null;
        switch (type.trim().toLowerCase()){
            case "china": p = new ChinaPizza();break;
            default:
                System.out.println("Not support " + type + " pizza in Beijing yet. ");break;
        }
        return p;
    }
}
