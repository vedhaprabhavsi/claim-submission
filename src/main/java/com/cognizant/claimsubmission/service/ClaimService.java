package com.cognizant.claimsubmission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.claimsubmission.model.Claim;
import com.cognizant.claimsubmission.repository.ClaimRepository;

@Service
public class ClaimService {
	
	@Autowired
	private ClaimRepository repo;
	
	public Claim create(Claim claim){
		return repo.save(claim);
	}
	
	public List<Claim> getAll(){
		return repo.findAll();
	}
	
	public Claim getClaim(Long claimId){
		return repo.findByClaimId(claimId);
	}
}
