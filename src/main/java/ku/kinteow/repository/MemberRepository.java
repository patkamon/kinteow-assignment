package ku.kinteow.repository;

import ku.kinteow.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {

    // SELECT * FROM User WHERE username = ‘username in parameter’
    Member findByUsername(String username);

}
