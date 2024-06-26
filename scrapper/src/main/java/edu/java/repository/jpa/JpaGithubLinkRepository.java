package edu.java.repository.jpa;

import edu.java.domain.GithubLinkEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaGithubLinkRepository extends JpaRepository<GithubLinkEntity, Long> {

    Optional<GithubLinkEntity> findByLinkId(Long linkId);

    boolean existsByLinkId(Long linkId);
}
