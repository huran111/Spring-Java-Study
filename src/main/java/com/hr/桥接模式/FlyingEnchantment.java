package com.hr.桥接模式;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author BUCHU
 * @Title: FlyingEnchantment
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/917:57
 */
public class FlyingEnchantment implements Enchantment {
    private static final Logger LOGGER = LoggerFactory.getLogger(FlyingEnchantment.class);

    @Override
    public void onActive() {
        LOGGER.info("物品开始微微发光");
    }


    @Override
    public void apply() {
        LOGGER.info("该项目飞和打击敌人最终回到业主手中。");

    }

    @Override
    public void onDeactivate() {
        LOGGER.info("物品的光芒会褪色");

    }
}
