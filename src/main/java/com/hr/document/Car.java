package com.hr.document;

import java.util.Map;

/**
 * @author huran
 * @Title: Car
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/2811:20
 */
public class Car  extends AbstractDocument implements HasModel,HasParts,HasType{

    protected Car(Map<String, Object> properties) {
        super(properties);
    }
}
