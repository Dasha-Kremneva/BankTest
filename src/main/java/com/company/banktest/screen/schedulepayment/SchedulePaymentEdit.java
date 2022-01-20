package com.company.banktest.screen.schedulepayment;

import io.jmix.ui.screen.*;
import com.company.banktest.entity.SchedulePayment;

@UiController("SchedulePayment.edit")
@UiDescriptor("schedulePayment-edit.xml")
@EditedEntityContainer("schedulePaymentDc")
public class SchedulePaymentEdit extends StandardEditor<SchedulePayment> {
}