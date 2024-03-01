package com.xworkz.servletcrud.repo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.xworkz.servletcrud.dto.SportsDto;

public class OlympicRepoImpl implements OlympicRepo {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("olympics");

	@Override
	public boolean addSport(SportsDto dto) {
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		
		try {
			transaction.begin();
			em.persist(dto);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			em.close();
		}
		
		return false;
	}

	@Override
	public SportsDto findById(int id) {
		EntityManager em =  emf.createEntityManager();
		try {
			SportsDto foundDto = em.find(SportsDto.class, id);
			return foundDto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		return null;
	}

	@Override
	public SportsDto findByName(String name) {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createNamedQuery("findByName" , SportsDto.class);
			query.setParameter("nm", name);
			SportsDto dto = (SportsDto) query.getSingleResult();
			return dto;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		return null;
	}

	@Override
	public boolean updateTypeByName(String name, String type) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction =em.getTransaction();
		transaction.begin();
		Query query =em.createNamedQuery("updateTypeByName");
		query.setParameter("ty",type);
		query.setParameter("nm", name);
		int rowsAffected =query.executeUpdate();
		transaction.commit();

		if(rowsAffected>0) {
			System.out.println("query is updated");
			return true;
		}
		return false;
	}

}
