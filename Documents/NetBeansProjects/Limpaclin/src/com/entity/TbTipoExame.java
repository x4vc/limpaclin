/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.math.BigDecimal;
//import javafx.beans.property.DoubleProperty;
//import javafx.beans.property.IntegerProperty;
//import javafx.beans.property.StringProperty;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Victor
 */
@Entity
@Table(name = "tb_tipo_exame")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbTipoExame.findAll", query = "SELECT t FROM TbTipoExame t"),
    @NamedQuery(name = "TbTipoExame.findByIdTipoExame", query = "SELECT t FROM TbTipoExame t WHERE t.idTipoExame = :idTipoExame"),
    @NamedQuery(name = "TbTipoExame.findByNomeTipoExame", query = "SELECT t FROM TbTipoExame t WHERE t.nomeTipoExame = :nomeTipoExame"),
    @NamedQuery(name = "TbTipoExame.findByLikeNomeTipoExame", query = "SELECT t FROM TbTipoExame t WHERE t.nomeTipoExame LIKE :nomeTipoExame"),
    @NamedQuery(name = "TbTipoExame.findByFatorTipoExame", query = "SELECT t FROM TbTipoExame t WHERE t.fatorTipoExame = :fatorTipoExame"),
    @NamedQuery(name = "TbTipoExame.findByTipoExameAtivo", query = "SELECT t FROM TbTipoExame t WHERE t.tipoExameAtivo = :tipoExameAtivo")})
public class TbTipoExame implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_exame")
    private Integer idTipoExame;
    @Basic(optional = false)
    @Column(name = "nome_tipo_exame")
    private String nomeTipoExame;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "fator_tipo_exame")
    private BigDecimal fatorTipoExame;
    @Basic(optional = false)
    @Column(name = "tipo_exame_ativo")
    private String tipoExameAtivo;
    
//    //variables a serem utilizadas no TableView
//    private IntegerProperty ip_idTipoExame;
//    private StringProperty sp_nomeTipoExame;
//    private DoubleProperty dp_fatorTipoExame;
//    private StringProperty sp_tipoExameAtivo;
//    //------------------------------------------

    public TbTipoExame() {
    }

    public TbTipoExame(Integer idTipoExame) {
        this.idTipoExame = idTipoExame;
    }

    public TbTipoExame(Integer idTipoExame, String nomeTipoExame, BigDecimal fatorTipoExame, String tipoExameAtivo) {
        this.idTipoExame = idTipoExame;
        this.nomeTipoExame = nomeTipoExame;
        this.fatorTipoExame = fatorTipoExame;
        this.tipoExameAtivo = tipoExameAtivo;
    }

    public Integer getIdTipoExame() {
        return idTipoExame;
    }

    public void setIdTipoExame(Integer idTipoExame) {
        this.idTipoExame = idTipoExame;
    }

    public String getNomeTipoExame() {
        return nomeTipoExame;
    }

    public void setNomeTipoExame(String nomeTipoExame) {
        this.nomeTipoExame = nomeTipoExame;
    }

    public BigDecimal getFatorTipoExame() {
        return fatorTipoExame;
    }

    public void setFatorTipoExame(BigDecimal fatorTipoExame) {
        this.fatorTipoExame = fatorTipoExame;
    }

    public String getTipoExameAtivo() {
        return tipoExameAtivo;
    }

    public void setTipoExameAtivo(String tipoExameAtivo) {
        this.tipoExameAtivo = tipoExameAtivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoExame != null ? idTipoExame.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTipoExame)) {
            return false;
        }
        TbTipoExame other = (TbTipoExame) object;
        if ((this.idTipoExame == null && other.idTipoExame != null) || (this.idTipoExame != null && !this.idTipoExame.equals(other.idTipoExame))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.TbTipoExame[ idTipoExame=" + idTipoExame + " ]";
    }
    
}
