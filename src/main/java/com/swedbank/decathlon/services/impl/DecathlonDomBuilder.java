package com.swedbank.decathlon.services.impl;

import com.swedbank.decathlon.domain.DecathlonAthlete;
import com.swedbank.decathlon.services.DomBuilder;
import com.swedbank.decathlon.utils.DurationFormatter;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ProcessingInstruction;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.time.Duration;
import java.util.List;

public class DecathlonDomBuilder implements DomBuilder<DecathlonAthlete> {
    private static final String ROOT_ELEMENT = "Decathlon";
    private static final String ATHLETES_SEQUENCE_ELEMENT = "DecathlonAthletes";
    private static final String ATHLETE_ELEMENT = "Athlete";
    private static final String NAME_ATTR = "name";
    private static final String M100_ELEMENT = "m100";
    private static final String LONG_JUMP_ELEMENT_ = "LongJump";
    private static final String SHOT_PUT_ELEMENT = "ShotPut";
    private static final String HIGH_JUMP_ELEMENT = "HighJump";
    private static final String M400_ELEMENT = "m400";
    private static final String M110_ELEMENT = "m110";
    private static final String DISCUS_THROW_ELEMENT = "DiscusThrow";
    private static final String POLE_VAULT_ELEMENT = "PoleVault";
    private static final String JAVELIN_THROW_ELEMENT = "JavelinThrow";
    private static final String M1500_ELEMENT = "m1500";
    private static final String TOTAL_SCORE_ELEMENT = "TotalScore";
    private static final String RANK_ELEMENT = "rank";

    private String xsltFileName;

    public DecathlonDomBuilder() {
        this.xsltFileName = null;
    }

    public DecathlonDomBuilder(String xsltFileName) {
        this.xsltFileName = xsltFileName;
    }

    @Override
    public Document constructDocumentModel(List<DecathlonAthlete> athletes) {
        Document dom = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder docBuilder = dbf.newDocumentBuilder();
            dom = docBuilder.newDocument();

            Element rootEl = dom.createElement(ROOT_ELEMENT);
            dom.appendChild(rootEl);
            if (xsltFileName != null) {
                ProcessingInstruction xslProcInstruction = dom.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\""
                        + xsltFileName + "\"");
                dom.insertBefore(xslProcInstruction, rootEl);
            }
            Element athletesSequenceEl = dom.createElement(ATHLETES_SEQUENCE_ELEMENT);
            rootEl.appendChild(athletesSequenceEl);

            for (DecathlonAthlete athlete : athletes) {
                Element athleteEl = dom.createElement(ATHLETE_ELEMENT);

                athleteEl.setAttributeNode(createAttribute(NAME_ATTR, athlete.getName(), dom));
                athleteEl.appendChild(createElement(RANK_ELEMENT, athlete.getRank(), dom));
                athleteEl.appendChild(createElement(M100_ELEMENT, athlete.getM100(), dom));
                athleteEl.appendChild(createElement(LONG_JUMP_ELEMENT_, athlete.getLongJump(), dom));
                athleteEl.appendChild(createElement(SHOT_PUT_ELEMENT, athlete.getShotPut(), dom));
                athleteEl.appendChild(createElement(HIGH_JUMP_ELEMENT, athlete.getHighJump(), dom));
                athleteEl.appendChild(createElement(M400_ELEMENT, athlete.getM400(), dom));
                athleteEl.appendChild(createElement(M110_ELEMENT, athlete.getM110h(), dom));
                athleteEl.appendChild(createElement(DISCUS_THROW_ELEMENT, athlete.getDiscusThrow(), dom));
                athleteEl.appendChild(createElement(POLE_VAULT_ELEMENT, athlete.getPoleVault(), dom));
                athleteEl.appendChild(createElement(JAVELIN_THROW_ELEMENT, athlete.getJavelinThrow(), dom));
                athleteEl.appendChild(createElement(M1500_ELEMENT, athlete.getM1500(), dom));
                athleteEl.appendChild(createElement(TOTAL_SCORE_ELEMENT, athlete.getTotalScore(), dom));

                athletesSequenceEl.appendChild(athleteEl);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        return dom;
    }

    private Attr createAttribute(String name, Object value, Document dom) {
        Attr attr = dom.createAttribute(name);
        attr.setValue(String.valueOf(value));

        return attr;
    }

    private Element createElement(String name, Object value, Document dom) {
        Element el = dom.createElement(name);
        el.setTextContent(value instanceof Duration ? DurationFormatter.formatDuration((Duration) value)
                : String.valueOf(value));
        return el;
    }
}
