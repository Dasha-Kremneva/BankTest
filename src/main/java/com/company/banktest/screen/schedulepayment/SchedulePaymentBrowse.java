package com.company.banktest.screen.schedulepayment;

import io.jmix.ui.screen.*;
import com.company.banktest.entity.SchedulePayment;

@UiController("SchedulePayment.browse")
@UiDescriptor("schedulePayment-browse.xml")
@LookupComponent("schedulePaymentsTable")
public class SchedulePaymentBrowse extends StandardLookup<SchedulePayment> {
}