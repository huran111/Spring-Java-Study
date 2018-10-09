package com.hr.桥接模式;

/**
 * @author BUCHU
 * @Title: Enchantment
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/917:46
 */
public interface Enchantment {
    void onActive();
    void apply();
    void onDeactivate();
}
