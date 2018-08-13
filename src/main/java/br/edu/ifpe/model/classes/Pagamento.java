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
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Milena Macedo <milenasantosmcd@gmail.com>
 */
@Entity
public class Pagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private Integer codigo;
    @Column(length = 15, nullable = false)
    private String tipo;
    @Column(length = 10, scale = 2, precision = 10, nullable = false)
    private BigDecimal valor;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_locacao", nullable = false)
    private Locacao locacao;
    
    @Deprecated
    public Pagamento() {

    }

    public Pagamento(String tipo, BigDecimal valor, Locacao locacao) {
        this.tipo = tipo;
        this.valor = valor;
        this.locacao = locacao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    @Override
    public int hashCode() {
        final int HASH = 17;
        int result = 1;
        result = (HASH * result) + codigo.hashCode();
        result = (HASH * result) + tipo.hashCode();
        result = (HASH * result) + valor.hashCode();
        return result += (HASH * result) + locacao.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Pagamento))
            return false;
        
        if(!((Pagamento) obj).tipo.equals(this.tipo))
            return false;
        
        if(!((Pagamento) obj).valor.equals(this.valor))
            return false;
        
        return (((Pagamento) obj).locacao.equals(this.locacao));
    }

    @Override
    public String toString() {
        return "Pagamento{" + "codigo=" + codigo + ", tipo="
                + tipo + ", valor=" + valor + ", locacao=" + locacao + '}';
    }
}
