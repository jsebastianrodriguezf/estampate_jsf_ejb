/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.estampatejsfejb.session;

import co.edu.uniminuto.estampatejsfejb.entitys.Carritocompras;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author José Rodríguez
 */
@Stateless
public class CarritocomprasFacade extends AbstractFacade<Carritocompras> {
    @PersistenceContext(unitName = "Estampate_JSF_EJB-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarritocomprasFacade() {
        super(Carritocompras.class);
    }
    
}
