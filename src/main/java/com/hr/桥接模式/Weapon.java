package com.hr.桥接模式;

/**
 * @author BUCHU
 * @Title: Weapon
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/917:56
 */
public interface Weapon {
    void wield();

    void swing();

    void unwield();

    Enchantment getEnchantment();
}
