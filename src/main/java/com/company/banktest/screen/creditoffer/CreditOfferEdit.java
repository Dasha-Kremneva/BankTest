package com.company.banktest.screen.creditoffer;

import io.jmix.ui.screen.*;
import com.company.banktest.entity.CreditOffer;

@UiController("CreditOffer.edit")
@UiDescriptor("credit-offer-edit.xml")
@EditedEntityContainer("creditOfferDc")
public class CreditOfferEdit extends StandardEditor<CreditOffer> {
}