package org.cicr.sync.core.camel;

import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;
import org.cicr.sync.core.service.facade.EntityServiceFacade;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OpenMrsSyncComponent extends DefaultComponent {

    private EntityServiceFacade entityServiceFacade;

    private EntityNameEnum entityName;

    public OpenMrsSyncComponent(final EntityServiceFacade entityServiceFacade) {
        this.entityServiceFacade = entityServiceFacade;
    }

    @Override
    protected Endpoint createEndpoint(final String uri,
                                      final String remaining,
                                      final Map<String, Object> parameters) throws Exception {
        this.entityName = EntityNameEnum.getEntityNameEnum(remaining.toUpperCase());

        OpenMrsSyncEndpoint endpoint = new OpenMrsSyncEndpoint(uri, this, entityServiceFacade);

        endpoint.setConsumerProperties(parameters);
        setProperties(endpoint, parameters);

        return endpoint;
    }

    public EntityNameEnum getEntityName() {
        return entityName;
    }
}
