package com.seth.component.viewResolver;

/**
 * @author  xunbo.xu
 * @desc    XML解析视图
 * @date 18/9/28
 */
public class XmlView {
//    public XmlView() {
//    }
//
//    @Bean(
//            name = {"marshallingView"}
//    )
//    public MarshallingView createXmlView() throws ClassNotFoundException {
//        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
//        Set<String> classNameSet = ScanAnnotationParser.findPackageAnnotationClass("com.seth", XmlRootElement.class);
//        Set<Class> classSet = new HashSet();
//        Iterator var4 = classNameSet.iterator();
//
//        while(var4.hasNext()) {
//            String className = (String)var4.next();
//            Class<?> clazz = Class.forName(className);
//            classSet.add(clazz);
//        }
//
//        Class[] classArray = new Class[classSet.size()];
//        classSet.toArray(classArray);
//        jaxb2Marshaller.setClassesToBeBound(classArray);
//        MarshallingView marshallingView = new MarshallingView(jaxb2Marshaller);
//        return marshallingView;
//    }
}