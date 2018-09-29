package com.hr.document;

import java.util.Optional;

/**
 * @author BUCHU
 * @Title: HasType
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/2811:22
 */
public interface HasType  extends Document{
    String PROPERTY = "type";

    default Optional<String> getType() {
        return Optional.ofNullable((String) get(PROPERTY));
    }
}
