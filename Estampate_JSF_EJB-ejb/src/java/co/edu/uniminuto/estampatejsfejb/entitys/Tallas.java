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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author José Rodríguez
 */
@Entity
@Table(name = "TALLAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tallas.findAll", query = "SELECT t FROM Tallas t"),
    @NamedQuery(name = "Tallas.findByIdtalla", query = "SELECT t FROM Tallas t WHERE t.idtalla = :idtalla"),
    @NamedQuery(name = "Tallas.findByTamano", query = "SELECT t FROM Tallas t WHERE t.tamano = :tamano"),
    @NamedQuery(name = "Tallas.findByPrecio", query = "SELECT t FROM Tallas t WHERE t.precio = :precio")})
public class Tallas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTALLA")
    private Integer idtalla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TAMANO")
    private String tamano;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO")
    private int precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tallasIdtalla")
    private Collection<Producto> productoCollection;
    @JoinColumn(name = "ADMINISTRADORES_IDADMINISTRADOR", referencedColumnName = "IDADMINISTRADOR")
    @ManyToOne(optional = false)
    private Administradores administradoresIdadministrador;

    public Tallas() {
    }

    public Tallas(Integer idtalla) {
        this.idtalla = idtalla;
    }

    public Tallas(Integer idtalla, String tamano, int precio) {
        this.idtalla = idtalla;
        this.tamano = tamano;
        this.precio = precio;
    }

    public Integer getIdtalla() {
        return idtalla;
    }

    public void setIdtalla(Integer idtalla) {
        this.idtalla = idtalla;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    public Administradores getAdministradoresIdadministrador() {
        return administradoresIdadministrador;
    }

    public void setAdministradoresIdadministrador(Administradores administradoresIdadministrador) {
        this.administradoresIdadministrador = administradoresIdadministrador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtalla != null ? idtalla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tallas)) {
            return false;
        }
        Tallas other = (Tallas) object;
        if ((this.idtalla == null && other.idtalla != null) || (this.idtalla != null && !this.idtalla.equals(other.idtalla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.estampatejsfejb.entities.Tallas[ idtalla=" + idtalla + " ]";
    }
    
}
