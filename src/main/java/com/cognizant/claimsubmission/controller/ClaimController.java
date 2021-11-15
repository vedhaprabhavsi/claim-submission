package com.cognizant.claimsubmission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.claimsubmission.model.Claim;
import com.cognizant.claimsubmission.service.ClaimSequenceGenerator;
import com.cognizant.claimsubmission.service.ClaimService;

import io.swagger.annotations.ApiOperation;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("/claims")
public class ClaimController {
	
	@Autowired
	private ClaimService service;
	
	@Autowired
	private ClaimSequenceGenerator seqService;
	
	@RequestMapping("/submit")
	@ApiOperation(value = "Submit Claim", notes = "Header is not required", response = List.class)
	public Claim submit(@RequestBody Claim claim) {
		claim.setClaimId(seqService.getSequenceNumber(Claim.SEQUENCE_NAME));
		return service.create(claim);
	}
	
	@RequestMapping("/getClaim/{id}")
	@ApiOperation(value = "Get Claim", notes = "Header is not required", response = List.class)
	public Claim getClaim(@PathVariable("id") Long id){
		return service.getClaim(id);
	}
	
	@RequestMapping("/getClaims")
	@ApiOperation(value = "Find all claims", notes = "Header is not required", response = List.class)
	public List<Claim> getClaims(){
		return service.getAll();
	}

}
