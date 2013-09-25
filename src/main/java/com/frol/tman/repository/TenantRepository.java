/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frol.tman.repository;

import com.frol.tman.entity.QTenant;
import com.frol.tman.entity.TenantDTO;
import com.frol.tman.entity.TenantPreviewDTO;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Projections;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class TenantRepository {

    private final EntityManager em;

    @Inject
    public TenantRepository(EntityManager em) {
        this.em = em;
    }

    public TenantDTO findById(String id) {

        return new JPAQuery(em).from(QTenant.tenant).
                where(QTenant.tenant.id.eq(id)).
                singleResult(
                        Projections.bean(
                                TenantDTO.class,
                                QTenant.tenant.firstName,
                                QTenant.tenant.middleName,
                                QTenant.tenant.secondName,
                                QTenant.tenant.birthDay,
                                QTenant.tenant.id));

    }
    
    public List<TenantPreviewDTO> findAll() {
        QTenant qTenant = QTenant.tenant;
        return new JPAQuery(em).from(qTenant).list(
                Projections.bean(
                        TenantPreviewDTO.class,
                        qTenant.id,
                        qTenant.firstName,
                        qTenant.middleName,
                        qTenant.secondName));
    }
}
