package com.hr.桥接模式;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author BUCHU
 * @Title: Hammer
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/918:03
 */
public class Hammer implements Weapon {
    private static final Logger LOGGER = LoggerFactory.getLogger(Hammer.class);

    private final Enchantment enchantment;

    public Hammer(Enchantment enchantment) {
        this.enchantment = enchantment;
    }

    @Override
    public void wield() {
        LOGGER.info("The hammer is wielded.");
        enchantment.onActive();
    }

    @Override
    public void swing() {
        LOGGER.info("The hammer is swinged.");
        enchantment.apply();
    }

    @Override
    public void unwield() {
        LOGGER.info("The hammer is unwielded.");
        enchantment.onDeactivate();
    }

    @Override
    public Enchantment getEnchantment() {
        return enchantment;
    }
}
