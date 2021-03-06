package org.openmrs.utils.odoo.manager.rule;

import org.openmrs.utils.odoo.ObsActionEnum;
import org.openmrs.utils.odoo.model.WorkOrder;
import org.openmrs.utils.odoo.model.WorkOrderStateEnum;
import org.openmrs.utils.odoo.manager.WorkOrderStatusTransitionContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NoWorkOrderReadyBeforeWorkOrderInProgressOrDoneRule implements WorkOrderStatusTransitionRule {

    /**
     * Tests that a {@link WorkOrder} has the state set as READY when work orders are either
     * set as PROGRESS or DONE after it
     * @param context the Camel context
     * @return boolean
     */
    @Override
    public boolean workOrderMatchesCondition(final WorkOrderStatusTransitionContext context) {
        if (context.getWorkOrder().getState() == WorkOrderStateEnum.READY) {
            List<WorkOrder> workOrders = context.getWorkOrders();
            List<WorkOrder> workOrdersAfterCurrent = workOrders
                    .subList(context.getCurrentWorkOrderSequenceIndex() + 1, workOrders.size());
            return workOrdersAfterCurrent.stream()
                    .anyMatch(wo -> wo.getState() == WorkOrderStateEnum.DONE || wo.getState() == WorkOrderStateEnum.PROGRESS);
        }
        return false;
    }

    /**
     * Any {@link WorkOrder} that matches the above condition is closed
     * @param context the Camel context
     * @return action
     */
    @Override
    public ObsActionEnum getAction(final WorkOrderStatusTransitionContext context) {
        return ObsActionEnum.CLOSE;
    }
}
