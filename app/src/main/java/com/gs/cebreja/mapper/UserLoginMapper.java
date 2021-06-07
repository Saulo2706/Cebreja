package com.gs.cebreja.mapper;

import com.gs.cebreja.model.UserRole;
import com.gs.cebreja.network.response.UserLoginRoles;

import java.util.ArrayList;
import java.util.List;

public class UserLoginMapper {

    public static List<UserRole> deRolesParaDominio(List<UserLoginRoles> listUserLoginRoles){
        List<UserRole> userRoles = new ArrayList<>();

        for (UserLoginRoles userLoginRoles : listUserLoginRoles) {
            final UserRole userRole = new UserRole(userLoginRoles.getId(),userLoginRoles.getName(),userLoginRoles.authority());
            userRoles.add(userRole);
        }
        return userRoles;
    }

}
