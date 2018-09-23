package com.hr.ioc;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hruan
 * @Title: SimpleIOC
 * @ProjectName java-spring
 * @Description: 容器实现类
 * @date 2018/9/2116:25
 */
public class SimpleIOC {
    private Map<String, Object> beanMap = new HashMap<>(64);

    public SimpleIOC(String location) throws Exception {
        loadBeans(location);
    }

    public Object getBean(String name) throws IllegalAccessException {
        Object bean = beanMap.get(name);
        if (bean == null) {
            throw new IllegalAccessException("there is no bean with name" + name);
        }
        return bean;
    }

    private void loadBeans(String location) throws IOException, ParserConfigurationException, SAXException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        //加在配置文件
        InputStream inputStream = new FileInputStream(location);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.parse(inputStream);
        Element root = doc.getDocumentElement();
        NodeList nodeList = root.getChildNodes();
        // 遍历 <bean> 标签
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                String id = ele.getAttribute("id");
                String className = ele.getAttribute("class");
                Class beanClass = null;
                try {
                    beanClass = Class.forName(className);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                Object bean = beanClass.newInstance();
                // 遍历 <property> 标签
                NodeList propertyNodes = ele.getElementsByTagName("property");
                for (int j = 0; j < propertyNodes.getLength(); j++) {
                    Node propertyNode = propertyNodes.item(j);
                    if (propertyNode instanceof Element) {
                        Element element = (Element) propertyNode;
                        String name = element.getAttribute("name");
                        String value = element.getAttribute("value");
                        // 利用反射将 bean 相关字段访问权限设为可访问
                        Field field = bean.getClass().getDeclaredField(name);
                        field.setAccessible(true);
                        if (value != null && value.length() > 0) {
                            // 将属性值填充到相关字段中
                            field.set(bean, value);
                        } else {
                            String ref = element.getAttribute("ref");
                            if (ref == null || ref.length() == 0) {
                                throw new IllegalArgumentException("ref config error");
                            }
                            // 将引用填充到相关字段中
                            field.set(bean, getBean(ref));
                        }
                        // 将 bean 注册到 bean 容器中
                        registerBean(id, bean);

                    }
                }
            }
        }
    }

    private void registerBean(String id, Object bean) {
        beanMap.put(id, bean);
    }

}
