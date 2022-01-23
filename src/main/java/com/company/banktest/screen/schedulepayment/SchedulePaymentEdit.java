package com.company.banktest.screen.schedulepayment;


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
    private DateField<LocalDateTime> dateField;

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        dateField.setValue(LocalDateTime.now());
    }
}