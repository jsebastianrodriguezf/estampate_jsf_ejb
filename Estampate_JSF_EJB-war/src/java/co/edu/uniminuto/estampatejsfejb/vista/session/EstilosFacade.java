/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.estampatejsfejb.vista.session;

import co.edu.uniminuto.estampatejsfejb.entitys.Estilos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author José Rodríguez
 */
@Stateless
public class EstilosFacade extends AbstractFacade<Estilos> {
    @PersistenceContext(unitName = "Estampate_JSF_EJB-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstilosFacade() {
        super(Estilos.class);
    }
    
}
