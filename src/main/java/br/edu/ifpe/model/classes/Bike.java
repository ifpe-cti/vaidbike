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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Milena Macedo <milenasantosmcd@gmail.com>
 */
@Entity
public class Bike implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bike")
    private Integer codigo;
    @Column
    private BigDecimal valor;
    @Column(length = 18)
    private String modelo;
    @Column(length = 20)
    private String tipo;
    @Column(length = 10)
    private String cor;
    @ManyToOne
    @JoinColumn(name = "cod_usuario")
    private Usuario usuario;
    @Column
    private boolean disponivel;

    @Deprecated
    public Bike() {
    }

    public Bike(BigDecimal valor, String modelo, String tipo, String cor,
                Usuario usuario, boolean disponivel) {
        
        
        this.valor = valor;
        this.modelo = modelo;
        this.tipo = tipo;
        this.cor = cor;
        this.usuario = usuario;
        this.disponivel = disponivel;
    }

    public Integer getCodigo() {
        return codigo;
    }

  
    
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public int hashCode() {
        final int HASH = 13;
        int result = 1;
        result += (HASH * result) + codigo.hashCode();
        result += (HASH * result) + valor.hashCode();
        result += (HASH * result) + modelo.hashCode();
        result += (HASH * result) + tipo.hashCode();
        result += (HASH * result) + usuario.hashCode();
        result += (HASH * result) + disponivel.hashCode();
        return result += (HASH * result) + cor.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!((obj) instanceof Bike)) {
            return false;
        }
        
        if (!((Bike) obj).valor.equals(this.valor))
            return false;
        
        if (!((Bike) obj).modelo.equals(this.modelo))
            return false;
        
        if (!((Bike) obj).tipo.equals(this.tipo))
            return false;
        
        if (!((Bike) obj).usuario.equals(this.usuario))
            return false;
        
        return ((Bike) obj).cor.equals(this.cor);
    }

    @Override
    public String toString() {
        return "Bike{" + "codigo=" + codigo + ", valor=" + valor + ", 
            modelo=" + modelo + ", tipo=" + tipo + ", cor=" + cor + ", usuario="
                + usuario + ", disponivel=" + disponivel + '}';
    }

    
}
