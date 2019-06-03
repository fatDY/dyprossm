package com.dypro.utils;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class WriteXml {
    public <T> void writeXmlDocument(T obj, List<Class> childClass, String Encode,
                                     String XMLPathAndName) {
        long lasting = System.currentTimeMillis();//效率检测,获取当前执行开始时间
        try {
            XMLWriter xmlWriter = null;//声明编写xml对象
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding(Encode);
            String filePath = XMLPathAndName;//文件地址
            File file = new File(filePath);//获取文件
            if (file.exists()) {
                throw new Exception("该xml已存在");
            }
            Document document = DocumentHelper.createDocument();
            String rootName = obj.getClass().getSimpleName().toUpperCase();
            Element root = document.addElement(rootName);//根节点
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                boolean flag = false;
                //获取对象中get方法
                Method methodObj = obj.getClass().getMethod("get" +
                        field.getName().substring(0, 1).toUpperCase() +
                        field.getName().substring(1));
                Object childObj = methodObj.invoke(obj);
                //创建二级节点
                Element secondRoot = root.addElement(childObj.getClass().getSimpleName());
                for (Class aClass : childClass) {
                    if (childObj.getClass().getTypeName() == aClass.getTypeName()) {
                        Field[] childFilds = childObj.getClass().getDeclaredFields();
                        for (Field childFild : childFilds) {
                            Method meth = childObj.getClass().getMethod(
                                    "get"
                                            + childFild.getName().substring(0, 1)
                                            .toUpperCase()
                                            + childFild.getName().substring(1));
                            Object o = meth.invoke(childObj);
                            if (o != null) {
                                secondRoot.addElement(childFild.getName()).setText(o.toString());
                            } else {
                                secondRoot.addElement(childFild.getName()).setText(" ");
                            }
                            flag = true;
                        }
                    }
                }
                if (!flag) {
                    Object o = methodObj.invoke(childObj);
                    if (o != null) {
                        secondRoot.addElement(field.getName()).setText(o.toString());
                    } else {
                        secondRoot.addElement(field.getName()).setText(" ");
                    }
                }
                xmlWriter = new XMLWriter(new FileWriter(file), format);
                xmlWriter.write(document);
                xmlWriter.close();
                long lasting2 = System.currentTimeMillis();
                System.out.println("写入XML文件结束,用时" + (lasting2 - lasting) + "ms");
            }
        } catch (Exception e) {
            System.out.println("XML文件写入失败");
            System.out.println(e);
        }
    }

   /* public static void main(String[] args) throws IOException {
        WriteXml writeXml=new WriteXml();
        UserInfo userInfo=new UserInfo();
        userInfo.setId(1);
        userInfo.setUsername("sss");
        userInfo.setPassword("sss");
        userInfo.setStatus(0);
        userInfo.setStatusStr("ssss");
        userInfo.setRoles(new ArrayList<Role>());
        List<Class> list=new ArrayList<>();
        list.add(Role.class);
        String filepath=System.getProperty("user.dir")+"\\dypro_web\\src\\main\\resources\\xml\\test.xml";
        System.out.println(filepath);
        writeXml.writeXmlDocument(userInfo,list,"GBK",filepath);
    }*/
}
