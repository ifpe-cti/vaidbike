/*MIT License

Copyright (c) 2018 Milena dos Santos Macedo, Carlos André Cordeiro da Silva,
Adrielly Calado Sales, Lucas Mendes Cavalcanti.

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

import java.io.Serializable;
import java.time.LocalDate;
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

/**
 *
 * @author Carlos Cordeiro <carloscordeiroconsultor@gmail.com>
 */
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer codigo;
    @Column(nullable = false)
    private String senha;
    @Column(length = 45, nullable = false)
    private String nome;
    @Column(length = 20, nullable = false, unique = true)
    private String cpf;
    @Column(length = 15, nullable = false)
    private String sexo;
    private LocalDate dataNasc;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_endereco", nullable = false)
    private Endereco endereco;
    @Column(length = 20, unique = true, nullable = true)
    private String telefone;
    @Column(length = 45, unique = true, nullable = true)
    private String email;
    @OneToMany(targetEntity = Bike.class,
            fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Bike> bikes;

    @Deprecated
    public Usuario() {

    }

    public Usuario(String senha, String nome, String cpf,
            String sexo, LocalDate dataNasc, Endereco endereco, String telefone,
            String email, List<Bike> bikes) {
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

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
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
        result = (HASH * result) + senha.hashCode();
        result = (HASH * result) + nome.hashCode();
        result = (HASH * result) + cpf.hashCode();
        result = (HASH * result) + sexo.hashCode();
        result = (HASH * result) + dataNasc.hashCode();
        result = (HASH * result) + endereco.hashCode();
        result = (HASH * result) + telefone.hashCode();
        result = (HASH * result) + email.hashCode();
        return result += (HASH * result) + bikes.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Usuario)) 
            return false;

        if (!((Usuario) obj).senha.equals(this.senha))
            return false;

        if (!((Usuario) obj).nome.equals(this.nome)) 
            return false;

        if (!((Usuario) obj).cpf.equals(this.cpf)) 
            return false;

        if (!((Usuario) obj).sexo.equals(this.sexo)) 
            return false;

        if (!((Usuario) obj).dataNasc.equals(this.dataNasc)) 
            return false;

        if (!((Usuario) obj).endereco.equals(this.endereco)) 
            return false;

        if (!((Usuario) obj).telefone.equals(this.telefone)) 
            return false;

        return (((Usuario) obj).email.equals(this.email));
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigo=" + codigo + ", senha="
                + senha + ", nome=" + nome + ", cpf=" + cpf + ", sexo=" + sexo
                + ", dataNasc=" + dataNasc + ", endereco=" + endereco
                + ", telefone=" + telefone + ", email=" + email + ", bikes="
                + bikes + '}';
    }
}
