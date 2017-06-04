/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.estampatejsfejb.entitys;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author José Rodríguez
 */
@Entity
@Table(name = "PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIdproducto", query = "SELECT p FROM Producto p WHERE p.idproducto = :idproducto"),
    @NamedQuery(name = "Producto.findByCantidad", query = "SELECT p FROM Producto p WHERE p.cantidad = :cantidad")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPRODUCTO")
    private Integer idproducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private int cantidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoIdproducto")
    private Collection<Carritocompras> carritocomprasCollection;
    @JoinColumn(name = "COLORES_IDCOLOR", referencedColumnName = "IDCOLOR")
    @ManyToOne(optional = false)
    private Colores coloresIdcolor;
    @JoinColumn(name = "COMPRADORES_IDCOMPRADOR", referencedColumnName = "IDCOMPRADOR")
    @ManyToOne(optional = false)
    private Compradores compradoresIdcomprador;
    @JoinColumn(name = "ESTAMPAS_IDESTAMPA", referencedColumnName = "IDESTAMPA")
    @ManyToOne(optional = false)
    private Estampas estampasIdestampa;
    @JoinColumn(name = "ESTILOS_IDESTILO", referencedColumnName = "IDESTILO")
    @ManyToOne(optional = false)
    private Estilos estilosIdestilo;
    @JoinColumn(name = "TALLAS_IDTALLA", referencedColumnName = "IDTALLA")
    @ManyToOne(optional = false)
    private Tallas tallasIdtalla;

    public Producto() {
    }

    public Producto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Producto(Integer idproducto, int cantidad) {
        this.idproducto = idproducto;
        this.cantidad = cantidad;
    }

     public Producto(Collection<Carritocompras> carritocomprasCollection, int cantidad, Colores coloresIdcolor, Compradores compradoresIdcomprador, Estampas estampasIdestampa, Estilos estilosIdestilo, Tallas tallasIdtalla) {
        this.carritocomprasCollection = carritocomprasCollection;
        this.cantidad = cantidad;
        this.coloresIdcolor = coloresIdcolor;
        this.compradoresIdcomprador = compradoresIdcomprador;
        this.estampasIdestampa = estampasIdestampa;
        this.estilosIdestilo = estilosIdestilo;
        this.tallasIdtalla = tallasIdtalla;
    }
    
    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @XmlTransient
    public Collection<Carritocompras> getCarritocomprasCollection() {
        return carritocomprasCollection;
    }

    public void setCarritocomprasCollection(Collection<Carritocompras> carritocomprasCollection) {
        this.carritocomprasCollection = carritocomprasCollection;
    }

    public Colores getColoresIdcolor() {
        return coloresIdcolor;
    }

    public void setColoresIdcolor(Colores coloresIdcolor) {
        this.coloresIdcolor = coloresIdcolor;
    }

    public Compradores getCompradoresIdcomprador() {
        return compradoresIdcomprador;
    }

    public void setCompradoresIdcomprador(Compradores compradoresIdcomprador) {
        this.compradoresIdcomprador = compradoresIdcomprador;
    }

    public Estampas getEstampasIdestampa() {
        return estampasIdestampa;
    }

    public void setEstampasIdestampa(Estampas estampasIdestampa) {
        this.estampasIdestampa = estampasIdestampa;
    }

    public Estilos getEstilosIdestilo() {
        return estilosIdestilo;
    }

    public void setEstilosIdestilo(Estilos estilosIdestilo) {
        this.estilosIdestilo = estilosIdestilo;
    }

    public Tallas getTallasIdtalla() {
        return tallasIdtalla;
    }

    public void setTallasIdtalla(Tallas tallasIdtalla) {
        this.tallasIdtalla = tallasIdtalla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.estampatejsfejb.entities.Producto[ idproducto=" + idproducto + " ]";
    }
    
}
