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
@Table(name = "ESTILOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estilos.findAll", query = "SELECT e FROM Estilos e"),
    @NamedQuery(name = "Estilos.findByIdestilo", query = "SELECT e FROM Estilos e WHERE e.idestilo = :idestilo"),
    @NamedQuery(name = "Estilos.findByNombre", query = "SELECT e FROM Estilos e WHERE e.nombre = :nombre")})
public class Estilos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDESTILO")
    private Integer idestilo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estilosIdestilo")
    private Collection<Producto> productoCollection;
    @JoinColumn(name = "ADMINISTRADORES_IDADMINISTRADOR", referencedColumnName = "IDADMINISTRADOR")
    @ManyToOne(optional = false)
    private Administradores administradoresIdadministrador;

    public Estilos() {
    }

    public Estilos(Integer idestilo) {
        this.idestilo = idestilo;
    }

    public Estilos(Integer idestilo, String nombre) {
        this.idestilo = idestilo;
        this.nombre = nombre;
    }

    public Integer getIdestilo() {
        return idestilo;
    }

    public void setIdestilo(Integer idestilo) {
        this.idestilo = idestilo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idestilo != null ? idestilo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estilos)) {
            return false;
        }
        Estilos other = (Estilos) object;
        if ((this.idestilo == null && other.idestilo != null) || (this.idestilo != null && !this.idestilo.equals(other.idestilo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.estampatejsfejb.entities.Estilos[ idestilo=" + idestilo + " ]";
    }
    
}
