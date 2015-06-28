/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
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
@Table(name = "tb_username")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbUsername.findAll", query = "SELECT t FROM TbUsername t"),
    @NamedQuery(name = "TbUsername.findByIdUsername", query = "SELECT t FROM TbUsername t WHERE t.idUsername = :idUsername"),
    @NamedQuery(name = "TbUsername.findByNomeUsuario", query = "SELECT t FROM TbUsername t WHERE t.nomeUsuario = :nomeUsuario"),
    @NamedQuery(name = "TbUsername.findBySenha", query = "SELECT t FROM TbUsername t WHERE t.senha = :senha")})
public class TbUsername implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_username")
    private Integer idUsername;
    @Basic(optional = false)
    @Column(name = "nome_usuario")
    private String nomeUsuario;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;

    public TbUsername() {
    }

    public TbUsername(Integer idUsername) {
        this.idUsername = idUsername;
    }

    public TbUsername(Integer idUsername, String nomeUsuario, String senha) {
        this.idUsername = idUsername;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public Integer getIdUsername() {
        return idUsername;
    }

    public void setIdUsername(Integer idUsername) {
        this.idUsername = idUsername;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsername != null ? idUsername.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbUsername)) {
            return false;
        }
        TbUsername other = (TbUsername) object;
        if ((this.idUsername == null && other.idUsername != null) || (this.idUsername != null && !this.idUsername.equals(other.idUsername))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.TbUsername[ idUsername=" + idUsername + " ]";
    }
    
}
