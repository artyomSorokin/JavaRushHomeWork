package com.javarush.test.level36.lesson04.big01.view;


import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.controller.Controller;
import com.javarush.test.level36.lesson04.big01.model.ModelData;

import java.util.List;

public class UsersView implements View
{
    private Controller controller;

    @Override
    public void refresh(ModelData modelData)
    {
        if (!modelData.isDisplayDeletedUserList()) {
            System.out.println("All users:");
        }
        if (modelData.isDisplayDeletedUserList()) {
            System.out.println("All deleted users:");
        }
        for (int i = 0; i < modelData.getUsers().size(); i++) {
            System.out.println("\t" + modelData.getUsers().get(i));
        }
        //В конце выведи визуальный разделитель данных
        System.out.println("===================================================");
    }

    public void fireEventShowAllUsers()
    {
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }

    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }

    public void setController(Controller controller)
    {
        this.controller = controller;
    }
}
