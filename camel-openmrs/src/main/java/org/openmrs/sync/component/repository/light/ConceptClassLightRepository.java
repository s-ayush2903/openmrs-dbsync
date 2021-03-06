package org.openmrs.sync.component.repository.light;

import org.openmrs.sync.component.entity.light.ConceptClassLight;
import org.openmrs.sync.component.repository.OpenMrsRepository;
import org.springframework.cache.annotation.Cacheable;

public interface ConceptClassLightRepository extends OpenMrsRepository<ConceptClassLight> {

    @Override
    @Cacheable(cacheNames = "conceptClass", unless="#result == null")
    ConceptClassLight findByUuid(String uuid);
}
