package com.springBootWithREST.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="card_hib")
public class CardObject 
{
	@Id
	@Column(name = "cardNo")
	private long cardNo;
	private String name;
	
	@Temporal(TemporalType.DATE)
	private Date expiry;
	private int cvv;
	public CardObject() {
		// TODO Auto-generated constructor stub
	}
	public CardObject(long cardNo, String name, Date expiry, int cvv) {
		super();
		this.cardNo = cardNo;
		this.name = name;
		this.expiry = expiry;
		this.cvv = cvv;
	}
	@Override
	public String toString() {
		return "CardObject [cardNo=" + cardNo + ", name=" + name + ", expiry=" + expiry + ", cvv=" + cvv + "]";
	}
	public final long getCardNo() {
		return cardNo;
	}
	public final void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final Date getExpiry() {
		return expiry;
	}
	public final void setExpiry(Date expiry) {
		this.expiry = expiry;
	}
	public final int getCvv() {
		return cvv;
	}
	public final void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public boolean validate(long cardNo2, String name2, int cvv2) {
	
		Date today= new Date();
		int diff=today.compareTo(expiry);
		if(cardNo2==cardNo && name2.equals(name) && cvv2==cvv && diff<0)
		{
			return true;
		}
		
		
		return false;
	}

	
}
