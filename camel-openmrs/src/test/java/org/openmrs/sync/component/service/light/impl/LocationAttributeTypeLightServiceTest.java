package org.openmrs.sync.component.service.light.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openmrs.sync.component.entity.light.LocationAttributeTypeLight;
import org.openmrs.sync.component.repository.OpenMrsRepository;

import static org.junit.Assert.assertNotNull;

public class LocationAttributeTypeLightServiceTest {

    @Mock
    private OpenMrsRepository<LocationAttributeTypeLight> repository;

    private LocationAttributeTypeLightService service;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        service = new LocationAttributeTypeLightService(repository);
    }

    @Test
    public void createEntity() {
        assertNotNull(service.createEntity());
    }
}
