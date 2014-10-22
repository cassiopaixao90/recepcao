package br.com.recepcao.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "visitante")
public class Visitante implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "IdVisitante", nullable = false)
    private Integer idVisitante;

    @Column(name = "Name", nullable = false, length = 80)
    private String nome;

    @Column(name = "CPF")
    private String CPF;

    @Column(name = "RG")
    private String RG;

    @Column(name = "Telefone", nullable = false, length = 17)//(034)-8888-8888
    private String telefone;

    @Column(name = "DataAtendimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAtendimento;

    @Column(name = "horaEntrada")
    @Temporal(javax.persistence.TemporalType.TIME)
    private Time horaEntrada;

    @Column(name = "horaSaida")
    @Temporal(javax.persistence.TemporalType.TIME)
    private Time horaSaida;

    @Column(name = "statu")
    private String statu;
    
    @Column(name="descricao")
    @Type(type = "text")
    private String descricao;
    

    @OneToOne(mappedBy = "visitante", fetch = FetchType.LAZY)
    @ForeignKey(name = "EnderecoVisitante")
    private Endereco endereco;

    @ManyToOne(optional = false)
    @ForeignKey(name = "VisitanteSexo")
    @JoinColumn(name = "IdSexo", referencedColumnName = "IdSexo")
    private Sexo sexo;

    public Visitante() {
        this.sexo = new Sexo();
    }

    public Integer getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(Integer idVisitante) {
        this.idVisitante = idVisitante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public Time getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Time horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Time getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Time horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.idVisitante != null ? this.idVisitante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Visitante other = (Visitante) obj;
        if (this.idVisitante != other.idVisitante && (this.idVisitante == null || !this.idVisitante.equals(other.idVisitante))) {
            return false;
        }
        return true;
    }
 
}
