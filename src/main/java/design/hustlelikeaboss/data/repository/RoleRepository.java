package design.hustlelikeaboss.data.repository;


import design.hustlelikeaboss.data.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("roleRepository")
@Transactional
public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findByRole(String roleName);
}
