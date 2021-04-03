package com.agri.repository;

import com.agri.domain.Former;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mperumalsamy
 */

@SuppressWarnings("InterfaceNeverImplemented")
@Repository
public interface FormerRepository extends JpaRepository<Former, Integer> {
}
