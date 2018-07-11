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
import br.edu.ifpe.model.classes.Pagamento;
import br.edu.ifpe.model.interfacesDao.PagamentoDao;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Adrielly Calado <adriellysales015@outlook.com>
 */
public class PagamentoHibernate implements PagamentoDao {

    private final SessionFactory SESSIONS;
    private static  PagamentoHibernate instance;
    private final Logger LOGGER;

    public static PagamentoHibernate getInstance() {
        if (instance == null) {
            instance = new PagamentoHibernate();
        }
        return instance;
    }

    private PagamentoHibernate() {
        Configuration cfg = new Configuration().configure();
        this.SESSIONS = cfg.buildSessionFactory();
        this.LOGGER = Logger.getLogger(PagamentoHibernate.class);
    }

    @Override
    public void inserir(Pagamento pagamento) {
        Session session = this.SESSIONS.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(pagamento);
            transaction.commit();
        } catch (Exception e) {
            LOGGER.error("Ocorreu um erro ao inserir um pagamento"
                    + "\n" + e.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Pagamento recuperar(Integer codigo) {
        Session session = this.SESSIONS.openSession();

        try {
            return (Pagamento) session.createQuery("From Pagamento where"
                    + " id_pagamento=" + codigo).list().get(0);
        } catch (Exception e) {
            LOGGER.error("Ocorreu um erro ao recuperar um pagamento"
                    + "\n" + e.getMessage());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Pagamento> listarTodos() {
        Session session = this.SESSIONS.openSession();
        try {
            return (List) session.createQuery("from Pagamento").list();
        } catch (Exception e) {
            LOGGER.error("Ocorreu um erro ao listar todos os pagamentos"
                    + "\n" + e.getMessage());

        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void deletar(Pagamento pagamento) {
        Session session = this.SESSIONS.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.delete(pagamento);
            transaction.commit();
        } catch (Exception e) {
            LOGGER.error("Ocorreu um problema ao deletar um Pagamento "
                    + "\n" + e.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void alterar(Pagamento pagamento) {
       Session session = this.SESSIONS.openSession();
       Transaction transaction = session.beginTransaction();
       
       try{
           session.update(pagamento);
           transaction.commit();
       }catch(Exception alterarPagamentoException){
           LOGGER.error("Ocorreu um problema ao deletar um Pagamento "
                    + "\n" + alterarPagamentoException.getMessage());
           transaction.rollback();
       }finally{
           session.close();
       }
    }
}
