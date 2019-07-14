package my.sweetbook.is.Repositories;


import my.sweetbook.is.Entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
