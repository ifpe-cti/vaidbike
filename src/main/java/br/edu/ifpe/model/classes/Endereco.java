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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Milena Macedo <milenasantosmcd@gmail.com>
 */
@Entity
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Integer codigo;
    @Column(length = 45, nullable = false)
    private String estado;
    @Column(length = 45, nullable = false)
    private String cidade;
    @Column(length = 12)
    private String cep;
    @Column(length = 20, nullable = false)
    private String bairro;
    @Column(length = 45, nullable = false)
    private String logradouro;

    @Deprecated
    public Endereco() {
    }

    public Endereco(String estado, String cidade,
            String cep, String bairro, String logradouro) {
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.bairro = bairro;
        this.logradouro = logradouro;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    @Override
    public int hashCode() {
        final int HASH = 7;
        int result = 1;
        result = (HASH * result) + codigo.hashCode();
        result = (HASH * result) + estado.hashCode();
        result = (HASH * result) + cidade.hashCode();
        result = (HASH * result) + ((cep == null) ? 0 : cep.hashCode());
        result = (HASH * result) + bairro.hashCode();
        return result += logradouro.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!((obj) instanceof Endereco)) {
            return false;
        }

        if (!((Endereco) obj).estado.equals(this.estado)) {
            return false;
        }

        if (!((Endereco) obj).cidade.equals(this.cidade)) {
            return false;
        }

        if (!((Endereco) obj).cep.equals(this.cep)) {
            return false;
        }

        if (!((Endereco) obj).bairro.equals(this.bairro)) {
            return false;
        }

        return ((Endereco) obj).logradouro.equals(this.logradouro);
    }

    @Override
    public String toString() {
        return "Endereco{" + "codigo=" + codigo + ", estado="
                + estado + ", cidade=" + cidade + ", cep=" + cep
                + ", bairro=" + bairro + ", logradouro=" + logradouro + '}';
    }
}
