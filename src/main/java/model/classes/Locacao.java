/*MIT License

Copyright (c) 2018 Milena dos Santos Macedo, Carlos André Cordeiro da Silva, 
Adrielly Calado Sales, Luciano Campos de Lima Júnior.

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

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Milena Macedo - milenasantosmcd@gmail.com
 */
@Entity
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    
    @OneToOne
    @JoinColumn(name = "cod_cliente", referencedColumnName = "codigo")
    private Usuario cliente;
    
    @OneToOne
    @JoinColumn(name = "cod_locatario", referencedColumnName = "codigo")
    private Usuario locatario;
    
    @Column
    private Date retirada;
    
    @Column
    private Date devolucao;
    
    @OneToOne
    @JoinColumn(name = "cod_pagamento", referencedColumnName = "codigo")
    private Pagamento pagamento;

    public Locacao() {
    }

    public Locacao(Usuario cliente, Usuario locatario,
            Date retirada, Date devolucao, Pagamento pagamento) {
        //  this.codigo = codigo;
        this.cliente = cliente;
        this.locatario = locatario;
        this.retirada = retirada;
        this.devolucao = devolucao;
        this.pagamento = pagamento;
    }

    public int getCodigo() {
        return codigo;
    }

//    public void setCodigo(int codigo) {
//        this.codigo = codigo;
//    }
    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Usuario getLocatario() {
        return locatario;
    }

    public void setLocatario(Usuario locatario) {
        this.locatario = locatario;
    }

    public Date getRetirada() {
        return retirada;
    }

    public void setRetirada(Date retirada) {
        this.retirada = retirada;
    }

    public Date getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Date devolucao) {
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
        int hash = 7;
        hash = 89 * hash + this.codigo;
        hash = 89 * hash + Objects.hashCode(this.cliente);
        hash = 89 * hash + Objects.hashCode(this.locatario);
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
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.locatario, other.locatario)) {
            return false;
        }
        if (!Objects.equals(this.retirada, other.retirada)) {
            return false;
        }
        if (!Objects.equals(this.devolucao, other.devolucao)) {
            return false;
        }
        if (!Objects.equals(this.pagamento, other.pagamento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Locacao{" + "codigo=" + codigo + ", cliente=" + cliente
                + ", locatario=" + locatario + ", retirada=" + retirada
                + ", devolucao=" + devolucao + ", pagamento=" + pagamento + '}';
    }
}
