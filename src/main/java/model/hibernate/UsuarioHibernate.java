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
package model.hibernate;

import java.util.ArrayList;
import java.util.List;
import model.classes.Usuario;
import model.interfacesDao.UsuarioDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Carlos Cordeiro - carloscordeiroconsultor@gmail.com
 */
public class UsuarioHibernate implements UsuarioDao {

    private SessionFactory sessions;
    private static UsuarioHibernate instance;

    public static UsuarioHibernate getInstance() {
        if (instance != null) {
            instance = new UsuarioHibernate();
        }
        return instance;
    }

    public UsuarioHibernate() {
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public Usuario recuperar(String cpf) {
        Session session = this.sessions.openSession();

        try {
            return (Usuario) session.createQuery("From Usuario where cpf = '" + cpf + "'").list().get(0);
        } catch (Exception e) {
            System.out.println("Erro ao recuperar o Usuário pelo cpf no banco de dados. \n" + e);
            //lembtrar de tratar essa excessao posteriormente.

        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Usuario recuperar(String login, String senha) {

        Session session = this.sessions.openSession();

        List<Usuario> usuarios = new ArrayList<>();

        try {

            usuarios = session.createQuery("From Usuario where login = '"
                    + login + "' and senha = '" + senha + "'").list();
            if (usuarios.size() > 0) {
                return usuarios.get(0);
            }

        } catch (Exception e) {
            System.out.println("Erro ao recuperar o Usuário pelo loigin e pela senha no banco de dados. \n" + e);

        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void inserir(Usuario usuario) {
        Session session = this.sessions.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(usuario);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro ao Inserir Usuário no banco de dados. \n" + e);
            transaction.rollback();
        } finally {
            session.close();
        }

    }

    @Override
    public void alterar(Usuario usuario) {
        Session session = this.sessions.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.update(usuario);
            transaction.commit();

        } catch (Exception e) {
            System.out.println("Erro ao alterar o Usuário no banco de dados. \n" + e);
            //lembtrar de tratar essa excessao posteriormente.
            transaction.rollback();

        } finally {
            session.close();
        }
    }

    @Override
    public Usuario recuperar(int codigo) {
        Session session = this.sessions.openSession();

        try {

            return (Usuario) session.createQuery("From Usuario where codigo=" + codigo).list().get(0);

        } catch (Exception e) {
            System.out.println("Erro ao recuperar o código do Usuário no banco de dados. \n" + e);
            //lembtrar de tratar essa excessao posteriormente.
        } finally {
            session.close();
        }
        return null;

    }

    @Override
    public void deletar(Usuario usuario) {
        Session session = this.sessions.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(usuario);

        } catch (Exception e) {

            System.out.println("Erro ao deletar o Usuário no banco de dados. \n" + e);
            //lembtrar de tratar essa excessao posteriormente.
            transaction.rollback();

        } finally {
            session.close();
        }

    }

    @Override
    public List<Usuario> listarTodos() {
        Session session = this.sessions.openSession();
        try {
            return (List) session.createQuery("from Usuario").list();
        } catch (Exception e) {
            System.out.println("Erro ao listar todoos os Usuários no banco de dados. \n" + e);
            //lembtrar de tratar essa excessao posteriormente.

        } finally {
            session.close();
        }
        return null;

    }

}
