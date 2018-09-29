package com.hr.document;

import java.util.stream.Stream;

/**
 * @author BUCHU
 * @Title: HasParts
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/2811:22
 */
public interface HasParts  extends Document{
    String PROPERTY = "parts";

    default Stream<Part> getParts() {
        return children(PROPERTY, Part::new);
    }
}
