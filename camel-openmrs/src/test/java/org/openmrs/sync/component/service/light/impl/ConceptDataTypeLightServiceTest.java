package org.openmrs.sync.component.service.light.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openmrs.sync.component.entity.light.ConceptDatatypeLight;
import org.openmrs.sync.component.repository.OpenMrsRepository;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class ConceptDataTypeLightServiceTest {

    @Mock
    private OpenMrsRepository<ConceptDatatypeLight> repository;

    private ConceptDatatypeLightService service;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        service = new ConceptDatatypeLightService(repository);
    }

    @Test
    public void createPlaceholderEntity() {
        // Given
        String uuid = "uuid";

        // When
        ConceptDatatypeLight result = service.createPlaceholderEntity(uuid);

        // Then
        assertEquals(getExpectedConceptDatatype(), result);
    }

    private ConceptDatatypeLight getExpectedConceptDatatype() {
        ConceptDatatypeLight conceptDatatype = new ConceptDatatypeLight();
        conceptDatatype.setDateCreated(LocalDateTime.of(1970, Month.JANUARY, 1, 0, 0));
        conceptDatatype.setCreator(1L);
        conceptDatatype.setName("[Default]");
        return conceptDatatype;
    }
}
