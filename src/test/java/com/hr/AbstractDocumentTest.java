package com.hr;

import com.hr.document.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * @author BUCHU
 * @Title: AbstractDocumentTest
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/9/2811:25
 */
public class AbstractDocumentTest {
    private static final String KEY = "key";
    private static final String VALUE = "value";

    private class DocumentImplementation extends AbstractDocument {

        DocumentImplementation(Map<String, Object> properties) {
            super(properties);
        }
    }

    private DocumentImplementation document = new DocumentImplementation(new HashMap<>());

    @Test
    public void shouldPutAndGetValue() {
        document.put(KEY, VALUE);
        System.out.println(document.toString());
        assertEquals(VALUE, document.get(KEY));
    }

    @Test
    public void shouldRetrieveChildren() {
        Map<String, Object> child1 = new HashMap<>();
        Map<String, Object> child2 = new HashMap<>();
        List<Map<String, Object>> children = Arrays.asList(child1, child2);

        document.put(KEY, children);

        Stream<DocumentImplementation> childrenStream = document.children(KEY, DocumentImplementation::new);
        assertNotNull(children);

        assertEquals(2, childrenStream.count());
    }

    @Test
    public void shouldConstructPart() {
        Map<String, Object> partProperties = new HashMap<>();
        partProperties.put(HasType.PROPERTY, "TEST_PART_TYPE");
        partProperties.put(HasModel.PROPERTY, "TEST_PART_MODEL");
        partProperties.put(HasPrice.PROPERTY, 11111);
        Part part = new Part(partProperties);
        System.out.println(part.getType().get());
        System.out.println(part.getModel().get());
        System.out.println(part.getPrice().get());

    }

}
