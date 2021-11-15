package com.cognizant.claimsubmission;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.claimsubmission.model.Claim;
import com.cognizant.claimsubmission.repository.ClaimRepository;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ClaimSubmissionApplicationTests {

	@Autowired
	private ClaimRepository repo;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void getClaim(){
		Claim c = repo.findByClaimId(1234567890L);
		if(c != null)
			System.out.println("Claim Object Details: "+c);
		else
			System.out.println("No Claim Found with the Claim ID entered");
	}
	
	@Test
	public void getClaims(){
		List<Claim> claims = repo.findAll();
		if(claims.size() > 0) {
			System.out.println("At lease one claim is present. Details are: ");
			for(Claim c: claims){
				System.out.println(c);
			}
		}
		else
			System.out.println("Claim table doesn't have any data");
	}
	
	@Test
	public void submitClaim() throws ParseException{
		String dt1="11-04-2000"; 
		DateFormat df = new SimpleDateFormat("dd-MM-yyy");
		Date bDate = df.parse(dt1);
		
		String dt2="05-11-2021"; 
		Date aDate = df.parse(dt2);
		
		String dt3="07-11-2021"; 
		Date dDate = df.parse(dt3);
		
		Claim c = new Claim();
		c.setClaimId(BigInteger.valueOf(5040987225L));
		c.setMemberId("R-127");
		c.setfName("Sai");
		c.setlName("Pawan");
		c.setDob(bDate);
		c.setDoa(aDate);
		c.setDod(dDate);
		c.setProviderName("Apollo Hospital");
		c.setBillAmt(100000L);
		
		repo.save(c);
	}

}
