package com.company.banktest;

import com.company.banktest.entity.CreditOffer;
import com.company.banktest.entity.SchedulePayment;
import io.jmix.core.DataManager;
import io.jmix.core.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditService {

    @Autowired
    private DataManager dataManager;

    public Double findSumBodyCredit() {
        //сумма ежемесяного платежа по телу кредита = сумма кредита/срок кредита в месяцах
        Integer term = getCreditTerm(this);
        Double creditSum = getCreditSum(this);
        return creditSum/term;
    }

    //обращение к атрибуту "term" из SchedulePayment
    Integer getCreditTerm(Id<SchedulePayment> id) {
        SchedulePayment schedulePayment= dataManager.load(id).one();
        return schedulePayment.getCreditOffer().getTermCredit();
    }

    //обращение к атрибуту "sumCredit" из SchedulePayment
    Double getCreditSum(Id<SchedulePayment> id) {
        SchedulePayment schedulePayment= dataManager.load(id).one();
        return schedulePayment.getCreditOffer().getSumCredit();
    }
}