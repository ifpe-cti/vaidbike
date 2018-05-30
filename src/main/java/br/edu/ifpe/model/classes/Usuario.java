/*MIT License

Copyright (c) 2018 Milena dos Santos Macedo, Carlos André Cordeiro da Silva, Adrielly Calado Sales, Luciano Campos de Lima Júnior.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package br.edu.ifpe.model.classes;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Carlos Cordeiro - carloscordeiroconsultor@gmail.com
 */
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer codigo;
    @Column(length = 15,nullable = false)
    private String login;
    @Column(length = 12,nullable = false)
    private String senha;
    @Column(length = 20,nullable = false)
    private String nome;
    @Column(length = 15,nullable = false,unique = true)
    private String cpf;
    @Column(length = 5,nullable = false)
    private String sexo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNasc;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_endereco",nullable = false)
    private Endereco endereco;
    @Column(length = 15,unique = true,nullable = false)
    private String telefone;
    @Column(length = 20,unique = true,nullable = false)
    private String email;
    @OneToMany(mappedBy = "usuario", targetEntity = Bike.class,
            fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Bike> bikes;

    @Deprecated
    public Usuario() {

    }

    public Usuario(String login, String senha, String nome, String cpf,
            String sexo, Date dataNasc, Endereco endereco, String telefone,
            String email, List<Bike> bikes) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.bikes = bikes;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Bike> getBikes() {
        return bikes;
    }

    public void setBikes(List<Bike> bikes) {
        this.bikes = bikes;
    }

    @Override
    public int hashCode() {
        final int HASH = 13;
        int result = 1;
        result = (HASH * result) + codigo.hashCode();
        result = (HASH * result) + login.hashCode();
        result = (HASH * result) + senha.hashCode();
        result = (HASH * result) + nome.hashCode();
        result = (HASH * result) + cpf.hashCode();
        result = (HASH * result) + sexo.hashCode();
        result = (HASH * result) + dataNasc.hashCode();
        result = (HASH * result) + endereco.hashCode();
        result = (HASH * result) + telefone.hashCode();
        result = (HASH * result) + email.hashCode();
        return result = (HASH * result) + bikes.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Usuario))
            return false;
        
        if(!((Usuario) obj).codigo.equals(this.codigo))
            return false;
        
        if(!((Usuario) obj).login.equals(this.login))
            return false;
        
        if(!((Usuario) obj).senha.equals(this.senha))
            return false;
        
        if(!((Usuario) obj).nome.equals(this.nome))
            return false;
        
        if(!((Usuario) obj).cpf.equals(this.cpf))
            return false;
        
        if(!((Usuario) obj).sexo.equals(this.sexo))
            return false;
        
        if(!((Usuario) obj).dataNasc.equals(this.dataNasc))
            return false;
        
        if(!((Usuario) obj).endereco.equals(this.endereco))
            return false;
        
        if(!((Usuario) obj).telefone.equals(this.telefone))
            return false;
        
        if(!((Usuario) obj).email.equals(this.email))
            return false;
        
        return (((Usuario) obj).equals(this.bikes));
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigo=" + codigo + ", login=" + login + ", senha="
                + senha + ", nome=" + nome + ", cpf=" + cpf + ", sexo=" + sexo
                + ", dataNasc=" + dataNasc + ", endereco=" + endereco
                + ", telefone=" + telefone + ", email=" + email + ", bikes="
                + bikes + '}';
    }
}
