package com.hr.document;

import java.util.Map;

/**
 * @author BUCHU
 * @Title: Part
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/2811:24
 */
public class Part extends AbstractDocument implements HasType, HasModel, HasPrice {
    public Part(Map<String, Object> properties) {
        super(properties);
    }
}
