package com.company.banktest.screen.credit;

import io.jmix.ui.screen.*;
import com.company.banktest.entity.Credit;

@UiController("Credit.edit")
@UiDescriptor("credit-edit.xml")
@EditedEntityContainer("creditDc")
public class CreditEdit extends StandardEditor<Credit> {
}