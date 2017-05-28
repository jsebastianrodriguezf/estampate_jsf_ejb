/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.estampatejsfejb.entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author José Rodríguez
 */
@Entity
@Table(name = "CARRITOCOMPRAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carritocompras.findAll", query = "SELECT c FROM Carritocompras c"),
    @NamedQuery(name = "Carritocompras.findByIdcarritocompras", query = "SELECT c FROM Carritocompras c WHERE c.idcarritocompras = :idcarritocompras"),
    @NamedQuery(name = "Carritocompras.findByPreciototal", query = "SELECT c FROM Carritocompras c WHERE c.preciototal = :preciototal"),
    @NamedQuery(name = "Carritocompras.findByTipopago", query = "SELECT c FROM Carritocompras c WHERE c.tipopago = :tipopago")})
public class Carritocompras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCARRITOCOMPRAS")
    private Integer idcarritocompras;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIOTOTAL")
    private int preciototal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TIPOPAGO")
    private String tipopago;
    @JoinColumn(name = "PRODUCTO_IDPRODUCTO", referencedColumnName = "IDPRODUCTO")
    @ManyToOne(optional = false)
    private Producto productoIdproducto;

    public Carritocompras() {
    }

    public Carritocompras(Integer idcarritocompras) {
        this.idcarritocompras = idcarritocompras;
    }

    public Carritocompras(Integer idcarritocompras, int preciototal, String tipopago) {
        this.idcarritocompras = idcarritocompras;
        this.preciototal = preciototal;
        this.tipopago = tipopago;
    }

    public Integer getIdcarritocompras() {
        return idcarritocompras;
    }

    public void setIdcarritocompras(Integer idcarritocompras) {
        this.idcarritocompras = idcarritocompras;
    }

    public int getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(int preciototal) {
        this.preciototal = preciototal;
    }

    public String getTipopago() {
        return tipopago;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;
    }

    public Producto getProductoIdproducto() {
        return productoIdproducto;
    }

    public void setProductoIdproducto(Producto productoIdproducto) {
        this.productoIdproducto = productoIdproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcarritocompras != null ? idcarritocompras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carritocompras)) {
            return false;
        }
        Carritocompras other = (Carritocompras) object;
        if ((this.idcarritocompras == null && other.idcarritocompras != null) || (this.idcarritocompras != null && !this.idcarritocompras.equals(other.idcarritocompras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.estampatejsfejb.entities.Carritocompras[ idcarritocompras=" + idcarritocompras + " ]";
    }
    
}
