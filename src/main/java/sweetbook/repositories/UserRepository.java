package sweetbook.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import sweetbook.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
