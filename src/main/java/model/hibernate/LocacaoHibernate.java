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
package model.hibernate;

import java.util.List;
import model.classes.Locacao;
import model.classes.Usuario;
import model.interfacesDao.LocacaoDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Milena Macedo - milenasantosmcd@gmail.com
 */
public class LocacaoHibernate implements LocacaoDao {

    private SessionFactory sessions;
    private static LocacaoHibernate instance;

    public static LocacaoHibernate getInstance() {
        if (instance != null) {
            instance = new LocacaoHibernate();
        }
        return instance;
    }

    public LocacaoHibernate() {
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public Usuario retornarCliente(Usuario cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario retornarLocatario(Usuario locatario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Locacao> retornarListaLocacao(Usuario usuario) {
        Session session = this.sessions.openSession();
        Transaction transaction = session.beginTransaction();
        try {

            return session.createQuery("from Locacao where codigo="
                    + usuario.getCodigo()).list();

        } catch (Exception e) {
            System.out.println("Erro ao inserir a Locação no banco de dados.");
            transaction.rollback();
        } finally {

            session.close();
        }
        return null;
    }

    @Override
    public void inserir(Locacao locacao) {
        Session session = this.sessions.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(locacao);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao inserir a Locação no banco de dados.");
            transaction.rollback();
        } finally {
            session.close();
        }

    }

    @Override
    public void alterar(Locacao locacao) {

        Session session = this.sessions.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.update(locacao);
            transaction.commit();

        } catch (Exception e) {
            System.out.println("Erro ao alterar a Locação no banco de dados. \n" + e);
            transaction.rollback();

        } finally {
            session.close();
        }

    }

    @Override
    public Locacao recuperar(int codigo) {

        Session session = this.sessions.openSession();

        try {

            return (Locacao) session.createQuery("From Locacao where codigo=" + codigo).list().get(0);

        } catch (Exception e) {
            System.out.println("Erro ao recuperar o código da Locação no banco de dados. \n" + e);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void deletar(Locacao locação) {
        Session session = this.sessions.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(locação);

        } catch (Exception e) {

            System.out.println("Erro ao deletar a Locação no banco de dados. \n" + e);
            transaction.rollback();

        } finally {
            session.close();
        }
    }

    @Override
    public List<Locacao> listarTodos() {
        Session session = this.sessions.openSession();
        try {
            return (List) session.createQuery("from Locacao").list();
        } catch (Exception e) {
            System.out.println("Erro ao listar todoos as Locações no banco de dados. \n" + e);

        } finally {
            session.close();
        }
        return null;

    }

}
