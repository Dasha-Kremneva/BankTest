package com.company.banktest;

import com.company.banktest.entity.SchedulePayment;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    //проверка первый ли будет платеж или нет
    //сделать только для платежей текущего кредитного предложения
    public Boolean findFirstPayment(SchedulePayment sh) {
        return dataManager.loadValues("select sp, sp.date from SchedulePayment sp" +
                        " where sp.creditOffer.id ='" + sh.getCreditOffer().getId() + "'")
                .properties("date").list().isEmpty();
    }

    //нахождение последнего платежа SchedulePayment по последней дате для вычисления startBalance
    public SchedulePayment findLastPayment(SchedulePayment sh) {
        return dataManager.loadValues(
                        "select sp, sp.date from SchedulePayment sp " +
                                "where sp.creditOffer.id = '" + sh.getCreditOffer().getId() +
                                "' order by sp.date desc")
                .properties("date")
                .list().stream().map(e -> e.<SchedulePayment>getValue("date"))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
}