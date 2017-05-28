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
@Table(name = "ADMINISTRADORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administradores.findAll", query = "SELECT a FROM Administradores a"),
    @NamedQuery(name = "Administradores.findByIdadministrador", query = "SELECT a FROM Administradores a WHERE a.idadministrador = :idadministrador"),
    @NamedQuery(name = "Administradores.findByNombre", query = "SELECT a FROM Administradores a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Administradores.findByContrasena", query = "SELECT a FROM Administradores a WHERE a.contrasena = :contrasena")})
public class Administradores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDADMINISTRADOR")
    private Integer idadministrador;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "administradoresIdadministrador")
    private Collection<Tallas> tallasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "administradoresIdadministrador")
    private Collection<Colores> coloresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "administradoresIdadministrador")
    private Collection<Estilos> estilosCollection;

    public Administradores() {
    }

    public Administradores(Integer idadministrador) {
        this.idadministrador = idadministrador;
    }

    public Administradores(Integer idadministrador, String nombre, String contrasena) {
        this.idadministrador = idadministrador;
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public Integer getIdadministrador() {
        return idadministrador;
    }

    public void setIdadministrador(Integer idadministrador) {
        this.idadministrador = idadministrador;
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
    public Collection<Tallas> getTallasCollection() {
        return tallasCollection;
    }

    public void setTallasCollection(Collection<Tallas> tallasCollection) {
        this.tallasCollection = tallasCollection;
    }

    @XmlTransient
    public Collection<Colores> getColoresCollection() {
        return coloresCollection;
    }

    public void setColoresCollection(Collection<Colores> coloresCollection) {
        this.coloresCollection = coloresCollection;
    }

    @XmlTransient
    public Collection<Estilos> getEstilosCollection() {
        return estilosCollection;
    }

    public void setEstilosCollection(Collection<Estilos> estilosCollection) {
        this.estilosCollection = estilosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadministrador != null ? idadministrador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administradores)) {
            return false;
        }
        Administradores other = (Administradores) object;
        if ((this.idadministrador == null && other.idadministrador != null) || (this.idadministrador != null && !this.idadministrador.equals(other.idadministrador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.estampatejsfejb.entities.Administradores[ idadministrador=" + idadministrador + " ]";
    }
    
}
