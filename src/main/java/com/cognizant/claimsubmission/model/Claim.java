package com.cognizant.claimsubmission.model;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Claim {
	
	@Transient
	public static final String SEQUENCE_NAME = "claim-sequence";
	
	@Id
	private BigInteger claimId;
	private String memberId;
	private String fName;
	private String lName;
	private Date dob;
	private Date doa;
	private Date dod;
	private String providerName;
	private Long billAmt;	
	
	public Claim() {
		super();
	}
	
	public BigInteger getClaimId() {
		return claimId;
	}
	public void setClaimId(BigInteger claimId) {
		this.claimId = claimId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDoa() {
		return doa;
	}
	public void setDoa(Date doa) {
		this.doa = doa;
	}
	public Date getDod() {
		return dod;
	}
	public void setDod(Date dod) {
		this.dod = dod;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public Long getBillAmt() {
		return billAmt;
	}
	public void setBillAmt(Long billAmt) {
		this.billAmt = billAmt;
	}
	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", memberId=" + memberId + ", fName=" + fName + ", lName=" + lName
				+ ", dob=" + dob + ", doa=" + doa + ", dod=" + dod + ", providerName=" + providerName + ", billAmt="
				+ billAmt + "]";
	}
	
	

}
