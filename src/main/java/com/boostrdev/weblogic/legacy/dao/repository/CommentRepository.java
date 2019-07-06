package com.boostrdev.weblogic.legacy.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boostrdev.weblogic.legacy.dao.entity.CitiCntPaymentComments;

@Repository
public interface CommentRepository extends JpaRepository<CitiCntPaymentComments, Long>{
	
	
		 	 
}
