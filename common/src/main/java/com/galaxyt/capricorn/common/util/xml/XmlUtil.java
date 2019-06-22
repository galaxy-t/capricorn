package com.galaxyt.capricorn.common.util.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * XML工具类
 * @author zhouqi
 * @date 2019-04-09 00:13
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-04-09 00:13     zhouqi          v1.0.0           Created
 *
 */
public class XmlUtil {


    /**
     * 将一个XML字符串转换成Element对象
     * @param xmlStr    要转换的XML字符串
     * @return
     */
    public static Element readXMLToElement(String xmlStr) {
        Document document = null;
        Element root = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            root = document.getRootElement();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return root;
    }

}
