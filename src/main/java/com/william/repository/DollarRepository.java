package com.william.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.william.bean.Dollar;

@Repository
public class DollarRepository {

	@Autowired
	EntityManager entityManager;
	
	public Dollar updateData(Dollar dollar) {
		
		try {
			return entityManager.merge(dollar);
		}
		catch(Exception e) {
			return null;
		}
		
	}
	
	public List<Dollar> readAllData() {
		
		List<Dollar> dollarDetailList = entityManager.createNativeQuery("Select * from dollar").getResultList();
		System.out.println(dollarDetailList);
		return dollarDetailList;
		
	}

	public Dollar searchByCode(String code) {
		
		Dollar dollar = (Dollar) entityManager.createQuery("from dollar where code = :code", Dollar.class).setParameter("code", code).getSingleResult();
		
		return dollar;
	}
}
