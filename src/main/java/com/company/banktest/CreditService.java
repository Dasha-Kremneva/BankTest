package com.company.banktest;

import com.company.banktest.entity.SchedulePayment;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreditService {

    @Autowired
    private DataManager dataManager;

    public Double findSumBodyCredit(SchedulePayment schedulePayment) {
        //сумма платежа по телу кредита = сумма кредита/срок кредита в месяцах
        Integer term = getCreditTerm(schedulePayment);
        Double creditSum = getCreditSum(schedulePayment);
        return creditSum / term;
    }

    //обращение к атрибуту "term" из SchedulePayment
    public Integer getCreditTerm(SchedulePayment schedulePayment) {
        return schedulePayment.getCreditOffer().getTermCredit();
    }

    //обращение к атрибуту "sumCredit" из SchedulePayment
    public Double getCreditSum(SchedulePayment schedulePayment) {
        return schedulePayment.getCreditOffer().getSumCredit();
    }
}