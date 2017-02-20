package com.swedbank.decathlon;

import org.junit.Test;
import org.w3c.dom.Document;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;


/**
 * Integration testing with file input and output.
 * Covers complete flow of file processing.
 */
public class AppTest {

    private static final String INPUT_FILE_NAME = "src/test/resources/decathlon.csv";
    private static final String OUTPUT_FILE_NAME = "test_out.xml";

    @Test
    public void main() throws Exception {
        App.main(new String[]{INPUT_FILE_NAME, OUTPUT_FILE_NAME});

        Document dom = readXml(OUTPUT_FILE_NAME);

        Element targetAthlete = findAthlete("Siim Susi", dom);
        assertThat(targetAthlete, notNullValue());

        String rank = findNestedValue("rank", targetAthlete);
        assertThat(rank, equalTo("2-3"));

        String totalScore = findNestedValue("TotalScore", targetAthlete);
        assertThat(totalScore, equalTo("4200"));
    }

    private Document readXml(String xmlFile) {
        File file = new File(xmlFile);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        Document document = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        try {
            document = db.parse(file);
            document.getDocumentElement().normalize();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return document;
    }

    private String findNestedValue(String nodeName, Element parentElement) {
        NodeList nodes = parentElement.getElementsByTagName(nodeName);
        String result = null;
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (Node.ELEMENT_NODE == node.getNodeType()) {
                Element element = (Element) node;

                result = element.getTextContent();
            }
        }

        return result;
    }

    private Element findAthlete(String name, Document dom) {
        Element result = null;
        NodeList nodes = dom.getElementsByTagName("Athlete");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (Node.ELEMENT_NODE == node.getNodeType()) {
                Element element = (Element) node;

                if (name.equals(element.getAttribute("name"))) {
                    result = element;
                    break;
                }
            }
        }
        return result;
    }
}