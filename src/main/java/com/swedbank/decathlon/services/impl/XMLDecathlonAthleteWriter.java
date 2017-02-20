package com.swedbank.decathlon.services.impl;

import com.swedbank.decathlon.domain.DecathlonAthlete;
import com.swedbank.decathlon.services.AthleteWriter;
import com.swedbank.decathlon.services.DomBuilder;
import org.w3c.dom.Document;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XMLDecathlonAthleteWriter implements AthleteWriter<DecathlonAthlete> {

    public static final String FILE_EXTENSION = "xml";

    private DomBuilder domBuilder;

    public XMLDecathlonAthleteWriter(DomBuilder domBuilder) {
        this.domBuilder = domBuilder;
    }

    @Override
    public void writeAthletes(List<DecathlonAthlete> athletes, String fileName) {
        Document dom = domBuilder.constructDocumentModel(athletes);
        writeFile(dom, fileName);
    }

    private void writeFile(Document dom, String fileName) {
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            tr.setOutputProperty(OutputKeys.STANDALONE, "yes");
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty(OutputKeys.METHOD, FILE_EXTENSION);
            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            tr.transform(new DOMSource(dom), new StreamResult(new FileOutputStream(fileName)));
        } catch (TransformerException te) {
            System.out.println(te.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    @Override
    public String getSupportedExtension() {
        return FILE_EXTENSION;
    }
}
