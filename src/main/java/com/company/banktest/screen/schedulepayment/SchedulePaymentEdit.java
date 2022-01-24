package com.company.banktest.screen.schedulepayment;


import com.company.banktest.CreditService;
import io.jmix.ui.component.DateField;
import io.jmix.ui.screen.*;
import com.company.banktest.entity.SchedulePayment;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@UiController("SchedulePayment.edit")
@UiDescriptor("schedulePayment-edit.xml")
@EditedEntityContainer("schedulePaymentDc")
public class SchedulePaymentEdit extends StandardEditor<SchedulePayment> {

    @Autowired
    private CreditService creditService;

    @Subscribe
    public void onInitEntity(InitEntityEvent<SchedulePayment> event) {
        event.getEntity().setSumBody(creditService.findSumBodyCredit());
    }

    @Autowired
    private DateField<LocalDateTime> dateField;

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        dateField.setValue(LocalDateTime.now());
    }
}