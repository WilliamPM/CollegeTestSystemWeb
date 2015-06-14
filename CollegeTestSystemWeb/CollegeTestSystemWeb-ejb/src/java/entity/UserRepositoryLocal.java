
package entity;

import java.util.List;

public interface UserRepositoryLocal {

    List<Users> getUsers();
    Users create(String login, String password, String name, int userType);
    
}
