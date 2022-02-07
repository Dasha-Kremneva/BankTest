package com.company.banktest.screen.schedulepayment;

import io.jmix.ui.screen.*;
import com.company.banktest.entity.SchedulePayment;
import com.company.banktest.CreditService;
import io.jmix.ui.component.DateField;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@UiController("SchedulePayment.edit")
@UiDescriptor("schedulePayment-edit.xml")
@EditedEntityContainer("schedulePaymentDc")
public class SchedulePaymentEdit extends StandardEditor<SchedulePayment> {

    @Autowired
    private CreditService creditService;

    @Autowired
    private DateField<LocalDateTime> dateField;

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        dateField.setValue(LocalDateTime.now());
        getEditedEntity().setSumBody(creditService.findSumBodyCredit(getEditedEntity()));

        //стартовый баланс
        if (creditService.findFirstPayment(getEditedEntity()))
            getEditedEntity().setStartBalance(getEditedEntity().getCreditOffer().getSumCredit());
        else getEditedEntity().setStartBalance(creditService.findLastPayment(getEditedEntity()).getEndBalance());

        // % ставка
        getEditedEntity().setSumPercent(getEditedEntity().getStartBalance() * (getEditedEntity().getCreditOffer().getCredit().getRate() / 100));
        //сумма платежа
        getEditedEntity().setSumPay(getEditedEntity().getSumBody() + getEditedEntity().getSumPercent());
        //конечный баланс = начальный баланс - сумма платежа
        getEditedEntity().setEndBalance(getEditedEntity().getStartBalance() - getEditedEntity().getSumPay());
    }
}