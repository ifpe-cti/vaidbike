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
package br.edu.ifpe.model.classes;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Milena Macedo - milenasantosmcd@gmail.com
 */
@Entity
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bike")
    private Integer codigo;
    @Column(length = 18)
    private String modelo;
    @Column(length = 20)
    private String tipo;
    @Column(length = 10)
    private String cor;
    @ManyToOne
    @JoinColumn(name = "cod_usuario")
    private Usuario usuario;

    @Deprecated
    public Bike() {
    }

    public Bike(String modelo, String tipo, String cor, Usuario usuario) {
        this.modelo = modelo;
        this.tipo = tipo;
        this.cor = cor;
        this.usuario = usuario;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipo() {
        return tipo;
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

    @Override
    public int hashCode() {
        final int HASH = 7;
        int result = 1;
        result = (HASH * result) + codigo.hashCode();
        result = (HASH * result) + ((modelo == null) ? 0 : modelo.hashCode());
        result = (HASH * result) + ((tipo == null) ? 0 : tipo.hashCode());
        result = (HASH * result) + ((cor == null) ? 0 : cor.hashCode());
        result = (HASH * result) + usuario.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Bike)) 
            return false;
        
        if(!((Bike)obj).codigo.equals(this.codigo))
                return false;
        
        if(!((Bike)obj).modelo.equals(this.modelo))
                return false;
        
        if(!((Bike)obj).tipo.equals(this.tipo))
                return false;
        
        if(!((Bike)obj).cor.equals(this.cor))
                return false;
        
        return (((Bike) obj).usuario.equals(this.usuario));
    }

    @Override
        public String toString() {
        return "Bike{" + "codigo=" + codigo + 
                ", modelo=" + modelo + ", tipo=" + tipo +
                    ", cor=" + cor + ", usuario=" + usuario + '}';
    }   
}
