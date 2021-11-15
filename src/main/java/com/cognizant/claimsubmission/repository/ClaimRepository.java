package com.cognizant.claimsubmission.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.claimsubmission.model.Claim;

@Repository
public interface ClaimRepository extends MongoRepository<Claim, Long> {
	public Claim findByClaimId(Long id);
}
