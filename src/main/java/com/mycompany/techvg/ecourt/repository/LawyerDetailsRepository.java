package com.mycompany.techvg.ecourt.repository;

import com.mycompany.techvg.ecourt.domain.LawyerDetails;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the LawyerDetails entity.
 */
@Repository
public interface LawyerDetailsRepository extends LawyerDetailsRepositoryWithBagRelationships, JpaRepository<LawyerDetails, Long> {
    default Optional<LawyerDetails> findOneWithEagerRelationships(Long id) {
        return this.fetchBagRelationships(this.findById(id));
    }

    default List<LawyerDetails> findAllWithEagerRelationships() {
        return this.fetchBagRelationships(this.findAll());
    }

    default Page<LawyerDetails> findAllWithEagerRelationships(Pageable pageable) {
        return this.fetchBagRelationships(this.findAll(pageable));
    }
}
