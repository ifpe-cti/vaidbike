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

import java.util.ArrayList;
import java.util.List;
import br.edu.ifpe.model.classes.Usuario;
import br.edu.ifpe.model.interfacesDao.UsuarioDao;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Carlos Cordeiro - carloscordeiroconsultor@gmail.com
 */
public class UsuarioHibernate implements UsuarioDao {

    private final SessionFactory SESSIONS;
    private static UsuarioHibernate instance;
    private final Logger LOGGER;

    public static UsuarioHibernate getInstance() {
        if (instance == null) {
            instance = new UsuarioHibernate();
        }
        return instance;
    }

    private UsuarioHibernate() {
        Configuration cfg = new Configuration().configure();
        this.SESSIONS = cfg.buildSessionFactory();
        this.LOGGER = Logger.getLogger(UsuarioHibernate.class);
    }

    @Override
    public Usuario recuperar(String cpf) {
        Session session = this.SESSIONS.openSession();

        try {
            return (Usuario) session.createQuery("From Usuario where cpf = '"
                    + cpf + "'").list().get(0);
        } catch (Exception e) {
            LOGGER.error("Ocorreu um problema ao recuperar o Usuario por cpf"
                    + "\n" + e.getMessage());
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public Usuario recuperar(String login, String senha) {
        Session session = this.SESSIONS.openSession();
        Usuario usuario = null;

        try {
            usuario = (Usuario) session.createQuery(
                    "From Usuario where login = '" + login
                    + "' and senha = '" + senha + "'").list().get(0);
        } catch (Exception e) {
            LOGGER.error("Ocorreu um problema ao recuperar o Usuario por login"
                    + "\n" + e.getMessage());
        } finally {
            session.close();
            return usuario;
        }
    }

    @Override
    public void inserir(Usuario usuario) {
        Session session = this.SESSIONS.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(usuario);
            transaction.commit();
        } catch (Exception e) {
            LOGGER.error("Ocorreu um problema ao inserir um Usuario "
                    + "\n" + e.getMessage());
        } finally {
            session.close();
        }
    }

    @Override
    public void alterar(Usuario usuario) {
        Session session = this.SESSIONS.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(usuario);
            transaction.commit();

        } catch (Exception e) {
            LOGGER.error("Ocorreu um problema ao alterar um Usuario "
                    + "\n" + e.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Usuario recuperar(Integer codigo) {
        Session session = this.SESSIONS.openSession();

        try {
            return (Usuario) session.createQuery("From Usuario where id_usuario="
                    + codigo).list().get(0);
        } catch (Exception e) {
            LOGGER.error("Ocorreu um problema ao recuperar o Usuario por cpf"
                    + "\n" + e.getMessage());
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Usuario usuario) {
        Session session = this.SESSIONS.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.delete(usuario);
            transaction.commit();
        } catch (Exception e) {
            LOGGER.error("Ocorreu um problema ao deletar um Usuario "
                    + "\n" + e.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Usuario> listarTodos() {
        Session session = this.SESSIONS.openSession();
        List<Usuario> usuarios = new ArrayList();

        try {
            usuarios = session.createQuery("from Usuario").list();
        } catch (Exception e) {
            LOGGER.error("Ocorreu um problema ao recuperar todos os Usuarios "
                    + "\n" + e.getMessage());
        } finally {
            session.close();
            return usuarios;
        }
    }

}
