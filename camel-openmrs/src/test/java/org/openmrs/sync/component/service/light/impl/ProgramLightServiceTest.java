package org.openmrs.sync.component.service.light.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openmrs.sync.component.entity.light.ConceptLight;
import org.openmrs.sync.component.entity.light.ProgramLight;
import org.openmrs.sync.component.repository.OpenMrsRepository;
import org.openmrs.sync.component.service.light.LightService;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ProgramLightServiceTest {

    @Mock
    private OpenMrsRepository<ProgramLight> repository;

    @Mock
    private LightService<ConceptLight> conceptService;

    private ProgramLightService service;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        service = new ProgramLightService(repository, conceptService);
    }

    @Test
    public void createPlaceholderEntity() {
        // Given
        when(conceptService.getOrInitPlaceholderEntity()).thenReturn(getConcept());
        String uuid = "uuid";

        // When
        ProgramLight result = service.createPlaceholderEntity(uuid);

        // Then
        assertEquals(getExpectedProgram(), result);
    }

    private ProgramLight getExpectedProgram() {
        ProgramLight program = new ProgramLight();
        program.setDateCreated(LocalDateTime.of(1970, Month.JANUARY, 1, 0, 0));
        program.setCreator(1L);
        program.setName("[Default]");
        program.setConcept(getConcept());
        return program;
    }

    private ConceptLight getConcept() {
        ConceptLight concept = new ConceptLight();
        concept.setUuid("PLACEHOLDER_CONCEPT");
        return concept;
    }
}
