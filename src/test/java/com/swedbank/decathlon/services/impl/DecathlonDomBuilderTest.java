package com.swedbank.decathlon.services.impl;

import com.swedbank.decathlon.TestBase;
import com.swedbank.decathlon.domain.DecathlonAthlete;
import com.swedbank.decathlon.services.DomBuilder;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class DecathlonDomBuilderTest extends TestBase {

    @Test
    public void constructDocumentModel() throws Exception {

        List<DecathlonAthlete> athletes = Arrays.asList(createAthlete("Dennis", 8000),
                createAthlete("Steve", 3000));

        DomBuilder<DecathlonAthlete> domBuilder = new DecathlonDomBuilder();

        Document dom = domBuilder.constructDocumentModel(athletes);
        Element rootEl = dom.getDocumentElement();
        Node athletesNode = rootEl.getFirstChild();
        Node firstAthlete = athletesNode.getFirstChild();
        String name1 = firstAthlete.getAttributes().getNamedItem("name").getNodeValue();
        String totalScore1 = firstAthlete.getChildNodes().item(11).getTextContent();
        Node lastAthlete = athletesNode.getLastChild();
        String name2 = lastAthlete.getAttributes().getNamedItem("name").getNodeValue();
        String totalScore2 = lastAthlete.getChildNodes().item(11).getTextContent();

        assertThat(rootEl.getTagName(), equalTo("Decathlon"));
        assertThat(athletesNode.getNodeName(), equalTo("DecathlonAthletes"));
        assertThat(firstAthlete.getNodeName(), equalTo("Athlete"));
        assertThat(lastAthlete.getNodeName(), equalTo("Athlete"));
        assertThat(name1, equalTo("Dennis"));
        assertThat(name2, equalTo("Steve"));
        assertThat(totalScore1, equalTo("8000"));
        assertThat(totalScore2, equalTo("3000"));
    }

}