package com.hr.document;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author huran
 * @Title: Document
 * @ProjectName java-spring
 * @Description:
 * @date 2018/9/2811:13
 */
public interface Document {
    void put(String key, Object value);

    Object get(String key);

    <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor);
}
