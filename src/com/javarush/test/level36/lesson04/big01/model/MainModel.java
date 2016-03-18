package com.javarush.test.level36.lesson04.big01.model;


import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.model.service.UserService;
import com.javarush.test.level36.lesson04.big01.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model
{
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();


    @Override
    public ModelData getModelData()
    {
        return modelData;
    }

    @Override
    public void loadUsers()
    {
        modelData.setDisplayDeletedUserList(false);
        List<User> listUsers = userService.getUsersBetweenLevels(1, 100);
        modelData.setUsers(getAllActiveUsers(listUsers));
    }

    @Override
    public void loadDeletedUsers()
    {
        modelData.setDisplayDeletedUserList(true);
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
    }

    @Override
    public void loadUserById(long userId)
    {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    @Override
    public void deleteUserById(long id)
    {
        userService.deleteUser(id);
        modelData.setDisplayDeletedUserList(false);
        List<User> listUsers = userService.getUsersBetweenLevels(1, 100);
        modelData.setUsers(getAllActiveUsers(listUsers));
    }

    @Override
    public void changeUserData(String name, long id, int level)
    {
        userService.createOrUpdateUser(name, id, level);
        modelData.setDisplayDeletedUserList(false);
        List<User> userList = userService.getUsersBetweenLevels(1,100);
        modelData.setUsers(getAllActiveUsers(userList));
    }

    private List<User> getAllActiveUsers(List<User> listUsers)
    {
        return userService.filterOnlyActiveUsers(listUsers);
    }
}
