package com.cognizant.claimsubmission.service;

import org.springframework.stereotype.Service;

import com.cognizant.claimsubmission.model.ClaimDbSequence;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.math.BigInteger;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@Service
public class ClaimSequenceGenerator {
	
	@Autowired
	private MongoOperations op;
	
	public BigInteger getSequenceNumber(String seqName){
		Query query = new Query(Criteria.where("id").is(seqName));
		Update update = new Update().inc("seq", 1);
		ClaimDbSequence counter = op.findAndModify(query, update, options().returnNew(true).upsert(true),ClaimDbSequence.class);
		return !Objects.isNull(counter) ? counter.getSeq(): BigInteger.valueOf(1000000001L);
	}
}
