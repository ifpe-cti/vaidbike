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
package br.edu.ifpe.model.hibernate;

import java.util.List;
import br.edu.ifpe.model.classes.Pagamento;
import br.edu.ifpe.model.interfacesDao.PagamentoDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Adrielly Calado - adriellysales015@outlook.com
 */
public class PagamentoHibernate implements PagamentoDao {

    private SessionFactory sessions;
    private static PagamentoHibernate instance;

    public static PagamentoHibernate getInstance() {

        if (instance != null) {
            instance = new PagamentoHibernate();
        }
        return instance;

    }

    public PagamentoHibernate() {
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void inserir(Pagamento pagamento) {
        Session session = this.sessions.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(pagamento);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao Inserir Pagamento no banco de dados. \n" + e);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Pagamento recuperar(int codigo) {

        Session session = this.sessions.openSession();

        try {

            return (Pagamento) session.createQuery("From Pagamento where codigo=" + codigo).list().get(0);

        } catch (Exception e) {
            System.out.println("Erro ao recuperar o código do Pagamento no banco de dados. \n" + e);
            //lembtrar de tratar essa excessao posteriormente.
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Pagamento> listarTodos() {

        Session session = this.sessions.openSession();
        try {
            return (List) session.createQuery("from Pagamento").list();
        } catch (Exception e) {
            System.out.println("Erro ao listar todoos os Pagamentos no banco de dados. \n" + e);
            //lembtrar de tratar essa excessao posteriormente.

        } finally {
            session.close();
        }
        return null;

    }

    //Não serão utilizados.
    @Override
    public void alterar(Pagamento d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Pagamento d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
