package com.hr.document;

import java.util.Optional;

/**
 * @author BUCHU
 * @Title: HasModel
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/2811:21
 */
public interface HasModel  extends Document{
    String PROPERTY = "model";

    default Optional<String> getModel() {
        return Optional.ofNullable((String) get(PROPERTY));
    }

}
