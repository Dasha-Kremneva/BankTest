package com.company.banktest.screen.creditoffer;

import io.jmix.ui.screen.*;
import com.company.banktest.entity.CreditOffer;

@UiController("CreditOffer.browse")
@UiDescriptor("credit-offer-browse.xml")
@LookupComponent("creditOffersTable")
public class CreditOfferBrowse extends StandardLookup<CreditOffer> {
}