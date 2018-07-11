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
package br.edu.ifpe.model.hibernate;

import java.util.List;
import br.edu.ifpe.model.classes.Locacao;
import br.edu.ifpe.model.classes.Usuario;
import br.edu.ifpe.model.interfacesDao.LocacaoDao;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Milena Macedo <milenasantosmcd@gmail.com>
 */
public class LocacaoHibernate implements LocacaoDao {

    private final SessionFactory SESSIONS;
    private static LocacaoHibernate instance;
    private final Logger LOGGER;

    public static LocacaoHibernate getInstance() {
        if (instance == null) {
            instance = new LocacaoHibernate();
        }
        return instance;
    }

    private LocacaoHibernate() {
        Configuration cfg = new Configuration().configure();
        this.SESSIONS = cfg.buildSessionFactory();
        this.LOGGER = Logger.getLogger(LocacaoHibernate.class);
    }

    @Override
    public List<Locacao> retornarListaLocacao(Usuario cliente) {
        Session session = this.SESSIONS.openSession();
        List<Locacao> locacoes = new ArrayList();

        try {
            locacoes = session.createQuery("from Locacao where cod_cliente="
                    + cliente.getCodigo()).list();
        } catch (Exception e) {
            LOGGER.error("Ocorreu um erro ao listar todas as locações"
                    + "\n" + e.getMessage());
        } finally {
            session.close();
            return locacoes;
        }
    }

    @Override
    public List<Locacao> retornarListaLocatario(Usuario locatario) {
        Session session = this.SESSIONS.openSession();
        List<Locacao> locacoes = new ArrayList();

        try {
            locacoes = session.createQuery("from Locacao where cod_locatario="
                    + locatario.getCodigo()).list();
        } catch (Exception e) {
            LOGGER.error("Ocorreu um erro ao listar todas as locações"
                    + "\n" + e.getMessage());
        } finally {
            session.close();
            return locacoes;
        }
    }

    @Override
    public void inserir(Locacao locacao) {
        Session session = this.SESSIONS.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(locacao);
            transaction.commit();
        } catch (Exception e) {
            LOGGER.error("Ocorreu um erro ao inserir uma locação"
                    + "\n" + e.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void alterar(Locacao locacao) {
        Session session = this.SESSIONS.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.update(locacao);
            transaction.commit();
        } catch (Exception e) {
            LOGGER.error("Ocorreu um erro ao alterar uma locação"
                    + "\n" + e.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Locacao recuperar(Integer codigo) {
        Session session = this.SESSIONS.openSession();

        try {
            return (Locacao) session.createQuery
                ("From Locacao where id_locacao = " +  codigo).list().get(0);
        } catch (Exception e) {
            LOGGER.error("Ocorreu um erro ao recuperar uma locação"
                    + "\n" + e.getMessage());
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Locacao locacao) {
        Session session = this.SESSIONS.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.delete(locacao);
            transaction.commit();
        } catch (Exception e) {
            LOGGER.error("Ocorreu um erro ao deletar uma locação"
                    + "\n" + e.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Locacao> listarTodos() {
        Session session = this.SESSIONS.openSession();
        List<Locacao> locacoes = new ArrayList();

        try {
            locacoes = (List) session.createQuery("from Locacao").list();
        } catch (Exception e) {
            LOGGER.error("Ocorreu um erro ao listar todas as locações"
                    + "\n" + e.getMessage());
        } finally {
            session.close();
            return locacoes;
        }
    }

}
