package com.cognizant.claimsubmission.model;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ClaimDbSequence {

	@Id
	private String id;
	private BigInteger seq;
	
	public ClaimDbSequence() {
		super();
	}
	
	public ClaimDbSequence(String id, BigInteger seq) {
		this.id = id;
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigInteger getSeq() {
		return seq;
	}

	public void setSeq(BigInteger seq) {
		this.seq = seq;
	}
	
}
