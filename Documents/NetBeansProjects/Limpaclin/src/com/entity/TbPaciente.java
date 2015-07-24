/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author victorcmaf
 */
@Entity
@Table(name = "tb_paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPaciente.findAll", query = "SELECT t FROM TbPaciente t"),
    @NamedQuery(name = "TbPaciente.findByIdPaciente", query = "SELECT t FROM TbPaciente t WHERE t.idPaciente = :idPaciente"),
    @NamedQuery(name = "TbPaciente.findByNomePaciente", query = "SELECT t FROM TbPaciente t WHERE t.nomePaciente = :nomePaciente"),
    @NamedQuery(name = "TbPaciente.findByLikeNomePaciente", query = "SELECT t FROM TbPaciente t WHERE t.nomePaciente LIKE :nomePaciente"),
    @NamedQuery(name = "TbPaciente.findByDtNascimentoPaciente", query = "SELECT t FROM TbPaciente t WHERE t.dtNascimentoPaciente = :dtNascimentoPaciente"),
    @NamedQuery(name = "TbPaciente.findBySexoPaciente", query = "SELECT t FROM TbPaciente t WHERE t.sexoPaciente = :sexoPaciente"),
    @NamedQuery(name = "TbPaciente.findByRgPaciente", query = "SELECT t FROM TbPaciente t WHERE t.rgPaciente = :rgPaciente"),
    @NamedQuery(name = "TbPaciente.findByCPFpaciente", query = "SELECT t FROM TbPaciente t WHERE t.cPFpaciente = :cPFpaciente")})
public class TbPaciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_paciente")
    private Integer idPaciente;
    @Basic(optional = false)
    @Column(name = "nome_paciente")
    private String nomePaciente;
    @Column(name = "dt_nascimento_paciente")
    @Temporal(TemporalType.DATE)
    private Date dtNascimentoPaciente;
    @Column(name = "sexo_paciente")
    private String sexoPaciente;
    @Column(name = "rg_paciente")
    private String rgPaciente;
    @Column(name = "CPF_paciente")
    private String cPFpaciente;

    public TbPaciente() {
    }

    public TbPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public TbPaciente(Integer idPaciente, String nomePaciente) {
        this.idPaciente = idPaciente;
        this.nomePaciente = nomePaciente;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public Date getDtNascimentoPaciente() {
        return dtNascimentoPaciente;
    }

    public void setDtNascimentoPaciente(Date dtNascimentoPaciente) {
        this.dtNascimentoPaciente = dtNascimentoPaciente;
    }

    public String getSexoPaciente() {
        return sexoPaciente;
    }

    public void setSexoPaciente(String sexoPaciente) {
        this.sexoPaciente = sexoPaciente;
    }

    public String getRgPaciente() {
        return rgPaciente;
    }

    public void setRgPaciente(String rgPaciente) {
        this.rgPaciente = rgPaciente;
    }

    public String getCPFpaciente() {
        return cPFpaciente;
    }

    public void setCPFpaciente(String cPFpaciente) {
        this.cPFpaciente = cPFpaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaciente != null ? idPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPaciente)) {
            return false;
        }
        TbPaciente other = (TbPaciente) object;
        if ((this.idPaciente == null && other.idPaciente != null) || (this.idPaciente != null && !this.idPaciente.equals(other.idPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.TbPaciente[ idPaciente=" + idPaciente + " ]";
    }
    
}
