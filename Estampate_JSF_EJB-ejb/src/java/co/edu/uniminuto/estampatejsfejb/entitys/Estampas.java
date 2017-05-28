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
@Table(name = "ESTAMPAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estampas.findAll", query = "SELECT e FROM Estampas e"),
    @NamedQuery(name = "Estampas.findByIdestampa", query = "SELECT e FROM Estampas e WHERE e.idestampa = :idestampa"),
    @NamedQuery(name = "Estampas.findByNombre", query = "SELECT e FROM Estampas e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Estampas.findByTamano", query = "SELECT e FROM Estampas e WHERE e.tamano = :tamano"),
    @NamedQuery(name = "Estampas.findByEstilo", query = "SELECT e FROM Estampas e WHERE e.estilo = :estilo"),
    @NamedQuery(name = "Estampas.findByPrecio", query = "SELECT e FROM Estampas e WHERE e.precio = :precio"),
    @NamedQuery(name = "Estampas.findByUrlimagen", query = "SELECT e FROM Estampas e WHERE e.urlimagen = :urlimagen"),
    @NamedQuery(name = "Estampas.findByRanking", query = "SELECT e FROM Estampas e WHERE e.ranking = :ranking")})
public class Estampas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDESTAMPA")
    private Integer idestampa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TAMANO")
    private String tamano;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ESTILO")
    private String estilo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO")
    private int precio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "URLIMAGEN")
    private String urlimagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RANKING")
    private int ranking;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estampasIdestampa")
    private Collection<Producto> productoCollection;
    @JoinColumn(name = "ARTISTAS_IDARTISTA", referencedColumnName = "IDARTISTA")
    @ManyToOne(optional = false)
    private Artistas artistasIdartista;

    public Estampas() {
    }

    public Estampas(Integer idestampa) {
        this.idestampa = idestampa;
    }

    public Estampas(Integer idestampa, String nombre, String tamano, String estilo, int precio, String urlimagen, int ranking) {
        this.idestampa = idestampa;
        this.nombre = nombre;
        this.tamano = tamano;
        this.estilo = estilo;
        this.precio = precio;
        this.urlimagen = urlimagen;
        this.ranking = ranking;
    }

    public Integer getIdestampa() {
        return idestampa;
    }

    public void setIdestampa(Integer idestampa) {
        this.idestampa = idestampa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getUrlimagen() {
        return urlimagen;
    }

    public void setUrlimagen(String urlimagen) {
        this.urlimagen = urlimagen;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    public Artistas getArtistasIdartista() {
        return artistasIdartista;
    }

    public void setArtistasIdartista(Artistas artistasIdartista) {
        this.artistasIdartista = artistasIdartista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestampa != null ? idestampa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estampas)) {
            return false;
        }
        Estampas other = (Estampas) object;
        if ((this.idestampa == null && other.idestampa != null) || (this.idestampa != null && !this.idestampa.equals(other.idestampa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniminuto.estampatejsfejb.entities.Estampas[ idestampa=" + idestampa + " ]";
    }
    
}
