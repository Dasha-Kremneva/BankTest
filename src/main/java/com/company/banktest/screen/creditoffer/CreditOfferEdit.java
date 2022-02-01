package com.company.banktest.screen.creditoffer;


import com.company.banktest.CreditService;
import com.company.banktest.entity.SchedulePayment;
import io.jmix.core.DataManager;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.component.Button;
import io.jmix.ui.screen.*;
import com.company.banktest.entity.CreditOffer;
import org.springframework.beans.factory.annotation.Autowired;
import javax.inject.Inject;

@UiController("CreditOffer.edit")
@UiDescriptor("credit-offer-edit.xml")
@EditedEntityContainer("creditOfferDc")
public class CreditOfferEdit extends StandardEditor<CreditOffer> {

    @Autowired
    private CreditService creditService;

    @Autowired
    private DataManager dataManager;

    @Inject
    private ScreenBuilders screenBuilders;

    @Subscribe("myButton")
    public void onMyButtonClick(Button.ClickEvent event) {
        SchedulePayment schedulePayment = dataManager.create(SchedulePayment.class);
        schedulePayment.setCreditOffer(getEditedEntity());
//        schedulePayment.setSumBody(creditService.findSumBodyCredit(schedulePayment));
        editSelectedEntity(schedulePayment);
    }

    //открытие редактора по умолчанию для сущности SchedulePayment
    public void editSelectedEntity(SchedulePayment schedulePayment) {
        screenBuilders.editor(SchedulePayment.class, this)
                .editEntity(schedulePayment)
                .build()
                .show();
    }
}