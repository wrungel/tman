/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.frol.tman.repository;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author frol
 */
public class EntityManagerProducer {

    public static final String DEFAULT_PERSISTENCE_UNIT_NAME = "DefaultPersistenceUnit";

    @Produces
    @PersistenceContext(unitName = DEFAULT_PERSISTENCE_UNIT_NAME)
    EntityManager entityManager;
}
