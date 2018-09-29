package com.hr.document;

import java.util.Optional;

/**
 * @author BUCHU
 * @Title: HasPrice
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/2811:23
 */
public interface HasPrice  extends Document{
    String PROPERTY = "price";

    default Optional<Number> getPrice() {
        return Optional.ofNullable((Number) get(PROPERTY));
    }
}
