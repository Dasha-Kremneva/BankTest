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
        Integer term = getCreditTerm(schedulePayment.getId());
        Double creditSum = getCreditSum(schedulePayment.getId());
        return creditSum / term;
    }

    //обращение к атрибуту "term" из SchedulePayment
    public Integer getCreditTerm(UUID id) {
        SchedulePayment schedulePayment = dataManager.load(SchedulePayment.class).id(id).one();
        return schedulePayment.getCreditOffer().getTermCredit();
    }

    //обращение к атрибуту "sumCredit" из SchedulePayment
    public Double getCreditSum(UUID id) {
        SchedulePayment schedulePayment = dataManager.load(SchedulePayment.class).id(id).one();
        return schedulePayment.getCreditOffer().getSumCredit();
    }
}