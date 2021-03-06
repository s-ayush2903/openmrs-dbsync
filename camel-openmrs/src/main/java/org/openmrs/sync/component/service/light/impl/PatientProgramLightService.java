package org.openmrs.sync.component.service.light.impl;

import org.openmrs.sync.component.entity.light.PatientLight;
import org.openmrs.sync.component.entity.light.PatientProgramLight;
import org.openmrs.sync.component.entity.light.ProgramLight;
import org.openmrs.sync.component.repository.OpenMrsRepository;
import org.openmrs.sync.component.service.light.AbstractLightService;
import org.openmrs.sync.component.service.light.LightService;
import org.springframework.stereotype.Service;

@Service
public class PatientProgramLightService extends AbstractLightService<PatientProgramLight> {

    private LightService<PatientLight> patientService;

    private LightService<ProgramLight> programService;

    public PatientProgramLightService(final OpenMrsRepository<PatientProgramLight> repository,
                                      final LightService<PatientLight> patientService,
                                      final LightService<ProgramLight> programService) {
        super(repository);
        this.patientService = patientService;
        this.programService = programService;
    }

    @Override
    protected PatientProgramLight createPlaceholderEntity(final String uuid) {
        PatientProgramLight patientProgram = new PatientProgramLight();
        patientProgram.setDateCreated(DEFAULT_DATE);
        patientProgram.setCreator(DEFAULT_USER_ID);
        patientProgram.setPatient(patientService.getOrInitPlaceholderEntity());
        patientProgram.setProgram(programService.getOrInitPlaceholderEntity());

        return patientProgram;
    }
}
