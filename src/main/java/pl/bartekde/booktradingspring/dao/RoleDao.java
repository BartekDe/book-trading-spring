package pl.bartekde.booktradingspring.dao;

import pl.bartekde.booktradingspring.entity.Role;

public interface RoleDao {

    Role findRoleByName(String roleName);
}
