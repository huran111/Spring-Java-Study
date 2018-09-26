package com.hr.aop2;

import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;

/**
 * @author BUCHU
 * @Title: AbstractAopProxy
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/2614:06
 */
public abstract class AbstractAopProxy implements AopProxy {
    protected AdvisedSupport advisedSupport;

    public AbstractAopProxy(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }
}
