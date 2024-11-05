package org.acumen.training.codes.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.acumen.training.codes.model.Project;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

public class ProjectDao {
	private EntityManager em;
	public ProjectDao(String pu) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(pu);
		em = factory.createEntityManager();
	}
	
	@Transactional
	public boolean insert(Project proj){
		EntityTransaction tx= em.getTransaction();
		try {	
			tx.begin();
			em.persist(proj);
			tx.commit();
			return true;
		} catch (Exception e) {
			try {
				tx.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			e.printStackTrace();		
		}
		return false;
	}
	
	public boolean updateProjnameById(LocalDate newProjid, Integer id){
		EntityTransaction tx= em.getTransaction();
		try {	
			tx.begin();
			Project proj = em.find(Project.class, id);
			proj.setProjdate(newProjid);
			em.merge(proj);
			tx.commit();
				return true;
		} catch (Exception e) {
			try {
				tx.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			e.printStackTrace();		
		}
		return false;
	}
	
	public boolean deleteById(Integer id){
		EntityTransaction tx= em.getTransaction();
		try {	
			tx.begin();
			Project proj = em.find(Project.class, id);
			em.remove(proj);
			tx.commit();
				return true;
		} catch (Exception e) {
			try {
				tx.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			e.printStackTrace();		
		}
		return false;
	}
	
	public List<Project> selectAllProject(){
		List<Project> records = new ArrayList<>();
		try {	
			//Part 1: CQ
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Project>sql = builder.createQuery(Project.class);
			Root<Project>from = sql.from(Project.class);
			sql.select(from);
			//Part 2 : Query
			TypedQuery<Project>query = em.createQuery(sql);
			records = query.getResultList();
			
				return records;
		} catch (Exception e) {
		
			e.printStackTrace();		
		}
		return records;
	}
}
