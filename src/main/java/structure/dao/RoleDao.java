package structure.dao;

import structure.model.Role;

public interface RoleDao {
    Role getOne(Long id);
}