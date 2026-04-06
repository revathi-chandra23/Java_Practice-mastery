package cm.practice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revathiPractice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	// Custom query method to find user by username
	Optional<User> findByUsername(String username);
}
