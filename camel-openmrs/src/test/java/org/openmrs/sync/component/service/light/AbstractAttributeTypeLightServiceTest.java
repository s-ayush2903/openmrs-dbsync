package org.openmrs.sync.component.service.light;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openmrs.sync.component.entity.light.MockedAttributeTypeLight;
import org.openmrs.sync.component.repository.OpenMrsRepository;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class AbstractAttributeTypeLightServiceTest {

    @Mock
    private OpenMrsRepository<MockedAttributeTypeLight> repository;

    private MockedAttributeTypeLightService service;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        service = new MockedAttributeTypeLightService(repository);
    }

    @Test
    public void createPlaceholderEntity_should_return_entity() {
        // Given
        String uuid = "uuid";

        // When
        MockedAttributeTypeLight result = service.createPlaceholderEntity(uuid);

        // Then
        assertEquals(getExpectedAttributeType(), result);
    }

    private MockedAttributeTypeLight getExpectedAttributeType() {
        MockedAttributeTypeLight attributeType = new MockedAttributeTypeLight(null, null);
        attributeType.setName("[Default]");
        attributeType.setMinOccurs(0);
        attributeType.setCreator(1L);
        attributeType.setDateCreated(LocalDateTime.of(1970, Month.JANUARY, 1, 0, 0));
        return attributeType;
    }
}
