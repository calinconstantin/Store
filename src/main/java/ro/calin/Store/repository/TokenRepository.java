package ro.calin.Store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.calin.Store.models.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token,Long> {
}
