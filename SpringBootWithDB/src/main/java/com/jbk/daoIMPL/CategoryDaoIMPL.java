package com.jbk.daoIMPL;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.CategoryDao;
import com.jbk.entity.Category;

@Repository
public class CategoryDaoIMPL implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Boolean addCategoryt(Category category) {
		Session session=null;
		Boolean isAdded=false;
		try {
			session=sessionFactory.openSession();
			session.save(category);
			session.beginTransaction().commit();
			isAdded=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return isAdded;
	}

	@Override
	public Category getCategoryById(Long categoryId) {
		Session session=null;
		Category category=null;
	
		try {
			session=sessionFactory.openSession();
			category = session.get(Category.class, categoryId);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return category;
	}

	@Override
	public List<Category> getAllCategory() {
		Session session=null;
		Category category=null;
		List<Category> list=null;
		try {
			session=sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Category.class);
		    list = criteria.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
			return list;
		}
		
	}

	@Override
	public Boolean deleteCategoryById(Long categoryId) {
		Session session=null;
		Boolean isDeleted=false;
		try {
			session=sessionFactory.openSession();
			Category category = session.get(Category.class, categoryId);
			session.delete(category);
			session.beginTransaction().commit();
			isDeleted=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return isDeleted;
	}

	@Override
	public Boolean updateCategory(Category category) {
		Session session=null;
		Boolean isUpdated=false;
		
		try {
			session=sessionFactory.openSession();
			session.update(category);
			session.beginTransaction().commit();
			isUpdated=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return isUpdated;
	}

	@Override
	public List<Category> sortCategory(String sortBy, String fieldName) {
		
		Session session=null;
		List<Category> list=null;

		try {
			session=sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Category.class);
			if(sortBy.equalsIgnoreCase("asc")) {
				criteria.addOrder(Order.asc(fieldName));
			}else {
				criteria.addOrder(Order.desc(fieldName));
			}
			list=criteria.list();
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		return list;
	}
	
	public Double getMaxGst() {
		Double MaxGst=0d;
		Session session=null;
		
		
			session=sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Category.class);
			criteria.setProjection(Projections.max("categoryGst"));
			List list=criteria.list();
			if(!list.isEmpty()) {
			MaxGst=(Double) list.get(0);
			}
			
			return MaxGst;
	}

	@Override
	public List<Category> getMaxCategoryGst() {
		Session session=null;
		List<Category> maxGstOfcategory=null;
		
		try {
			
			Double maxGst = getMaxGst();
			if(maxGst>0) {
				session=sessionFactory.openSession();
				Criteria criteria = session.createCriteria(Category.class);
				criteria.add(Restrictions.eq("categoryGst", maxGst));
				maxGstOfcategory=criteria.list();
			}				
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return maxGstOfcategory;
	}

	@Override
	public Double countSumOfCategoryPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getTotalCountOfCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getCategoryByName(String getCategoryByName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteCategoryByName(Category CategorytName) {
		// TODO Auto-generated method stub
		return null;
	}

}
