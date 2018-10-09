package com.hr.桥接模式;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author BUCHU
 * @Title: SoulEatingEnchantment
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/917:59
 */
public class SoulEatingEnchantment implements Enchantment {
    private static final Logger LOGGER = LoggerFactory.getLogger(SoulEatingEnchantment.class);
    @Override
    public void onActive() {
        LOGGER.info("这个项目传播嗜血。");
    }

    @Override
    public void apply() {
        LOGGER.info("吃敌人的灵魂");
    }

    @Override
    public void onDeactivate() {
        LOGGER.info("嗜血慢慢消失了。");
    }
}
