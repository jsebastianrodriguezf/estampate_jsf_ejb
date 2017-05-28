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
@Table(name = "ARTISTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artistas.findAll", query = "SELECT a FROM Artistas a"),
    @NamedQuery(name = "Artistas.findByIdartista", query = "SELECT a FROM Artistas a WHERE a.idartista = :idartista"),
    @NamedQuery(name = "Artistas.findByNombre", query = "SELECT a FROM Artistas a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Artistas.findByContrasena", query = "SELECT a FROM Artistas a WHERE a.contrasena = :contrasena")})
public class Artistas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDARTISTA")
    private Integer idartista;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artistasIdartista")
    private Collection<Estampas> estampasCollection;

    public Artistas() {
    }

    public Artistas(Integer idartista) {
        this.idartista = idartista;
    }

    public Artistas(Integer idartista, String nombre, String contrasena) {
        this.idartista = idartista;
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public Integer getIdartista() {
        return idartista;
    }

    public void setIdartista(Integer idartista) {
        this.idartista = idartista;
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
    public Collection<Estampas> getEstampasCollection() {
        return estampasCollection;
    }

    public void setEstampasCollection(Collection<Estampas> estampasCollection) {
        this.estampasCollection = estampasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idartista != null ? idartista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artistas)) {
            return false;
        }
        Artistas other = (Artistas) object;
        if ((this.idartista == null && other.idartista != null) || (this.idartista != null && !this.idartista.equals(other.idartista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.estampatejsfejb.entities.Artistas[ idartista=" + idartista + " ]";
    }
    
}
