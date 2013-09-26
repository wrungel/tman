package com.frol.tman.repository;

import com.frol.tman.dto.PaymentPreviewDTO;
import com.frol.tman.entity.QPayment;
import com.frol.tman.entity.QRent;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Projections;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class RentRepository {
    private final EntityManager em;

    @Inject
    public RentRepository(EntityManager em) {
        this.em = em;
    }

    public List<PaymentPreviewDTO> getPayments(Long rentId) {
        QPayment qPayment = QPayment.payment;
        QRent qRent = QRent.rent;

        return new JPAQuery(em).from(qPayment).
                leftJoin(qPayment.rent, qRent).
                where(qRent.id.eq(rentId)).
                orderBy(qPayment.date.asc()).
                list(Projections.bean(PaymentPreviewDTO.class,
                        qPayment.id,
                        qPayment.amount,
                        qPayment.date,
                        qPayment.inCash,
                        qPayment.info));


    }

}
