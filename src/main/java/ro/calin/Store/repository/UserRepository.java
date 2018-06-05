package ro.calin.Store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.calin.Store.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
