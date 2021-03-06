package org.openmrs.sync.component.service.light.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openmrs.sync.component.entity.light.ConceptClassLight;
import org.openmrs.sync.component.repository.OpenMrsRepository;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class ConceptClassLightServiceTest {

    @Mock
    private OpenMrsRepository<ConceptClassLight> repository;

    private ConceptClassLightService service;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        service = new ConceptClassLightService(repository);
    }

    @Test
    public void createPlaceholderEntity() {
        // Given
        String uuid = "uuid";

        // When
        ConceptClassLight result = service.createPlaceholderEntity(uuid);

        // Then
        assertEquals(getExpectedConceptClass(), result);
    }

    private ConceptClassLight getExpectedConceptClass() {
        ConceptClassLight conceptClass = new ConceptClassLight();
        conceptClass.setDateCreated(LocalDateTime.of(1970, Month.JANUARY, 1, 0, 0));
        conceptClass.setCreator(1L);
        conceptClass.setName("[Default]");
        return conceptClass;
    }
}
