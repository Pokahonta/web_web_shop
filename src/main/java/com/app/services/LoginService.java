package com.app.services;

import com.app.dao.UserDao;
import com.app.model.Login;
import com.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    private UserDao userDao;

    public Integer getUserId(Login login) {
        List<User> users = userDao.getUsersByFirstName(login.getEmail());

        if (users.size() > 1){
            System.out.println("There is more then 1 user with username: " + login.getEmail());
        }

       // if (users.isEmpty()) {
       //     return null;
      //  } else {
       //     return users.get(0).getId();
      //  }
        if (!users.isEmpty() && users.get(0).getPassword().equals(login.getPassword())) {
            //
          return users.get(0).getId();
        }
        return null;

    }


}
