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

package model.classes;

import java.util.Objects;

/**
 *
 * @author Milena Macedo - milenasantosmcd@gmail.com
 */
public class Locatario {
    
    
    private int codigo;
    private String nome;
    private String cpf;
    private String sexo;
    private String dataNasc;
    private Endereco endereco;
    private String telefone;
    private String email;
    private Bike bike;
    private Usuario usuario;

    public Locatario() {
    }

    public Locatario(int codigo, String nome, String cpf, String sexo, String dataNasc, Endereco endereco, String telefone, String email, Bike bike, Usuario usuario) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.bike = bike;
        this.usuario = usuario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
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

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
       

    @Override
    public String toString() {
        return "Locatario{" + "codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", sexo=" + sexo + ", dataNasc=" + dataNasc + ", endereco=" + endereco + ", telefone=" + telefone + ", email=" + email + ", bike=" + bike + ", usuario=" + usuario + '}';
    }
 
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.codigo;
        hash = 19 * hash + Objects.hashCode(this.nome);
        hash = 19 * hash + Objects.hashCode(this.cpf);
        hash = 19 * hash + Objects.hashCode(this.sexo);
        hash = 19 * hash + Objects.hashCode(this.dataNasc);
        hash = 19 * hash + Objects.hashCode(this.endereco);
        hash = 19 * hash + Objects.hashCode(this.telefone);
        hash = 19 * hash + Objects.hashCode(this.email);
        hash = 19 * hash + Objects.hashCode(this.bike);
        hash = 19 * hash + Objects.hashCode(this.usuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Locatario other = (Locatario) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.dataNasc, other.dataNasc)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.bike, other.bike)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }
    
    
    
}