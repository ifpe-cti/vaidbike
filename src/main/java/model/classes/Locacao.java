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
public class Locacao {
    
    private int codigo;
    private Locatario locatario;
    private Cliente cliente;
    private String retirada;
    private String devolucao;
    private Pagamento pagamento;

    public Locacao() {
       
    }
    
    
    public Locacao(int codigo, Locatario locatario, Cliente cliente, String retirada, String devolucao, Pagamento pagamento) {
        this.codigo = codigo;
        this.locatario = locatario;
        this.cliente = cliente;
        this.retirada = retirada;
        this.devolucao = devolucao;
        this.pagamento = pagamento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getRetirada() {
        return retirada;
    }

    public void setRetirada(String retirada) {
        this.retirada = retirada;
    }

    public String getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(String devolucao) {
        this.devolucao = devolucao;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.codigo;
        hash = 89 * hash + Objects.hashCode(this.locatario);
        hash = 89 * hash + Objects.hashCode(this.cliente);
        hash = 89 * hash + Objects.hashCode(this.retirada);
        hash = 89 * hash + Objects.hashCode(this.devolucao);
        hash = 89 * hash + Objects.hashCode(this.pagamento);
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
        final Locacao other = (Locacao) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.retirada, other.retirada)) {
            return false;
        }
        if (!Objects.equals(this.devolucao, other.devolucao)) {
            return false;
        }
        if (!Objects.equals(this.locatario, other.locatario)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.pagamento, other.pagamento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Locacao{" + "codigo=" + codigo + ", locatario=" + locatario + ", cliente=" + cliente + ", retirada=" + retirada + ", devolucao=" + devolucao + ", pagamento=" + pagamento + '}';
    }
    
    
    

}
