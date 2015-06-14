    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entity.UserRepositoryLocal;
import entity.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author williamPM
 */
@Stateless
@LocalBean
public class UserRepository implements UserRepositoryLocal{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Users> getUsers() {
        return em.createNamedQuery("Users.findAll").getResultList();
    }

    @Override
    public Users create(String login, String password, String name, int userType) {
        Users user = new Users(login, password, name, userType);
        em.persist(user);
        return user;
    }
    
}
