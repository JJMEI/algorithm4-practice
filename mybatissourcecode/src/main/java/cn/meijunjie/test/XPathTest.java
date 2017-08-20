package cn.meijunjie.test;


import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.builder.xml.XMLMapperEntityResolver;
import org.apache.ibatis.io.Resources;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

@Slf4j
public class XPathTest {
    public static void main(String[] args) throws IOException, XPathExpressionException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

        builderFactory.setValidating(false);

        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        builder.setEntityResolver(new XMLMapperEntityResolver());

        InputSource inputSource = new InputSource(Resources.getResourceAsStream("mybatis-config.xml"));

        Document document = builder.parse(inputSource);

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        String value = (String) xPath.evaluate("/configuration/settings/setting[@name='defaultStatementTimeout']/@value", document, XPathConstants.STRING);

        log.info("defaultStatementTimeout {}",value);

        Node node = (Node) xPath.evaluate("/configuration/mappers/mapper[1]",document,XPathConstants.NODE);

        NamedNodeMap attributes = node.getAttributes();
        for(int i=0;i<attributes.getLength();i++)
        {
            Node node1 = attributes.item(i);
            log.info(node1.getNodeName() + " "+node1.getNodeValue());
        }



    }
}
