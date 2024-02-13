package in.ashokit.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.UserForm;

public interface UserRepository extends JpaRepository<UserForm, Integer>{

}
