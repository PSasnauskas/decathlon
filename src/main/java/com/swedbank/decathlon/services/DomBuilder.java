package com.swedbank.decathlon.services;

import com.swedbank.decathlon.domain.Athlete;
import org.w3c.dom.Document;

import java.util.List;

public interface DomBuilder<A extends Athlete> {

    Document constructDocumentModel(List<A> athletes);

}
