package com.company.banktest.screen.bank;

import io.jmix.ui.screen.*;
import com.company.banktest.entity.Bank;

@UiController("Bank.browse")
@UiDescriptor("bank-browse.xml")
@LookupComponent("banksTable")
public class BankBrowse extends StandardLookup<Bank> {
}