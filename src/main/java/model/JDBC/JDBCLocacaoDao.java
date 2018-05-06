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
package model.JDBC;

import java.util.List;
import model.classes.Locacao;
import model.interfacesDao.LocacaoDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author User
 */
public class JDBCLocacaoDao implements LocacaoDao{

    private SessionFactory factory;
    
    @Override
    public void inserir(Locacao d) {
        Session s = factory.openSession();
        s.getTransaction().begin();
        s.save(d);
        s.getTransaction().commit();
        s.close();}

    @Override
    public void alterar(Locacao d) {
        Session s = factory.openSession();
        s.getTransaction().begin();
        s.update(d);
        s.getTransaction().commit();
        s.close();}

    @Override
    public Locacao recuperar(Locacao d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Locacao d) {
        Session s = factory.openSession();
        s.getTransaction().begin();
        s.delete(d);
        s.getTransaction().commit();
        s.close();}

    @Override
    public List<Locacao> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
