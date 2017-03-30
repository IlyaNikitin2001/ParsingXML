import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by USER on 06.03.2017.
 */
public class ParserXMLExample {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
//        создаем фабрику производителя документов
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        создаем производителя документов
        DocumentBuilder builder = factory.newDocumentBuilder();
//        обеспечивает доступ к содержимому документа
        Document document = builder.parse("catShop.xml");
//        получили корневой элемент
        Node root = document.getDocumentElement();

        System.out.println(root.getNodeName());
//        просматриваем все дочерние элементы корневого узла
        NodeList cats = root.getChildNodes();
        for(int i = 0; i<cats.getLength(); i++){
//            получение узла из спика узлов
            Node cat= cats.item(i);

            System.out.println(cat.getNodeName());
            if (cat.getNodeType()!=Node.TEXT_NODE) {

//      список дочерних узлов гаждого кота
                NodeList catValue = cat.getChildNodes();
//проходим по всему списку
                for (int f = 0; f < catValue.getLength(); f++) {
//список всех узлов кота
                    Node catValue1 = catValue.item(f);
                    if (cat.getNodeType()!=Node.TEXT_NODE) {

//                        System.out.println(catValue1.getNodeName());
                        System.out.println(catValue1.getChildNodes().item(0));

                    }
                }
            }
        }

    }
}
