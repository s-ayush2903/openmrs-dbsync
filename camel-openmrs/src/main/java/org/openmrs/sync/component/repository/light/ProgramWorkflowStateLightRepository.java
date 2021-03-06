package org.openmrs.sync.component.repository.light;

import org.openmrs.sync.component.entity.light.ProgramWorkflowStateLight;
import org.openmrs.sync.component.repository.OpenMrsRepository;
import org.springframework.cache.annotation.Cacheable;

public interface ProgramWorkflowStateLightRepository extends OpenMrsRepository<ProgramWorkflowStateLight> {

    @Override
    @Cacheable(cacheNames = "programWorkflowState", unless="#result == null")
    ProgramWorkflowStateLight findByUuid(String uuid);
}
