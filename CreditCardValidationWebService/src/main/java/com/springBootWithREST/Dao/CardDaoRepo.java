package com.springBootWithREST.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springBootWithREST.model.CardObject;

public interface CardDaoRepo extends JpaRepository<CardObject, Long> 
{
	// tech is the property thats why it is working we need not to define this method, it is automatically taken care by JPA, only rule is the name of the method Start using "findBY" followed by property.
//	List<Student>findByTech(String tech);
//	List<Student>findBySidGreaterThan(int sid);
//	List<Student>findBySidLessThan(int sid);
//	
//	
//	//for Complex query /our own query
//	
//	@Query("from Student where tech=?1 order by sname")
//	List<Student>findByTechSorted(String tech);
//	
	@Query("from CardObject where cardNo=?1")
	 CardObject findByCardNo(Long cardNo); 
	

}
