package master.springExtractor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import master.springExtractor.model.Role;
import master.springExtractor.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	List<User> findByRole(Role role);
	
}
