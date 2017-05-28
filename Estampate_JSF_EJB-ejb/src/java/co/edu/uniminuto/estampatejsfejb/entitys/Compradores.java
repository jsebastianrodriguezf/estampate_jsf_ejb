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
@Table(name = "COMPRADORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compradores.findAll", query = "SELECT c FROM Compradores c"),
    @NamedQuery(name = "Compradores.findByIdcomprador", query = "SELECT c FROM Compradores c WHERE c.idcomprador = :idcomprador"),
    @NamedQuery(name = "Compradores.findByNombre", query = "SELECT c FROM Compradores c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Compradores.findByContrasena", query = "SELECT c FROM Compradores c WHERE c.contrasena = :contrasena")})
public class Compradores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCOMPRADOR")
    private Integer idcomprador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CONTRASENA")
    private String contrasena;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compradoresIdcomprador")
    private Collection<Producto> productoCollection;

    public Compradores() {
    }

    public Compradores(Integer idcomprador) {
        this.idcomprador = idcomprador;
    }

    public Compradores(Integer idcomprador, String nombre, String contrasena) {
        this.idcomprador = idcomprador;
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public Integer getIdcomprador() {
        return idcomprador;
    }

    public void setIdcomprador(Integer idcomprador) {
        this.idcomprador = idcomprador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcomprador != null ? idcomprador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compradores)) {
            return false;
        }
        Compradores other = (Compradores) object;
        if ((this.idcomprador == null && other.idcomprador != null) || (this.idcomprador != null && !this.idcomprador.equals(other.idcomprador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.estampatejsfejb.entities.Compradores[ idcomprador=" + idcomprador + " ]";
    }
    
}
