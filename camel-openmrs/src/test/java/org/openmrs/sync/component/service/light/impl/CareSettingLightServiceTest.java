package org.openmrs.sync.component.service.light.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openmrs.sync.component.entity.light.CareSettingLight;
import org.openmrs.sync.component.repository.OpenMrsRepository;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class CareSettingLightServiceTest {

    @Mock
    private OpenMrsRepository<CareSettingLight> repository;

    private CareSettingLightService service;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        service = new CareSettingLightService(repository);
    }

    @Test
    public void createPlaceholderEntity() {
        // Given
        String uuid = "uuid";

        // When
        CareSettingLight result = service.createPlaceholderEntity(uuid);

        // Then
        assertEquals(getExpectedCareSetting(), result);
    }

    private CareSettingLight getExpectedCareSetting() {
        CareSettingLight careSetting = new CareSettingLight();
        careSetting.setDateCreated(LocalDateTime.of(1970, Month.JANUARY, 1, 0, 0));
        careSetting.setCreator(1L);
        careSetting.setCareSettingType("[Default]");
        careSetting.setName("[Default]");
        return careSetting;
    }
}
