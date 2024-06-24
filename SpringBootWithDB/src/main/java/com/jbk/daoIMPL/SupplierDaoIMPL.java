package com.jbk.daoIMPL;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.SupplierDao;
import com.jbk.entity.Supplier;

@Repository
public class SupplierDaoIMPL implements SupplierDao {
@Autowired
private SessionFactory sessionFactory;
	
	@Override
	public Boolean addSupplier(Supplier supplier) {
		Session session=null;
		Boolean isAdded=false;
		try {
			session=sessionFactory.openSession();
			session.save(supplier);
			session.beginTransaction().commit();
			isAdded=true;
		} catch (Exception e) {
			isAdded=false;
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
	public Supplier getSupplierById(Long supplierId) {
		
		Session session=null;
		Supplier supplier =null;
		try {
			session=sessionFactory.openSession();
			supplier = session.get(Supplier.class, supplierId);
						
		} catch (Exception e) {
		 e.printStackTrace();
		
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return supplier;
	}

	
	
	@Override
	public List<Supplier> getAllSupplier() {
	
		Session session=null;
		List<Supplier> list =null;
		try {
			session=sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Supplier.class);
			list=criteria.list();	
		} catch (Exception e) {
		 e.printStackTrace();
		
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
		
	}

	
	
	@Override
	public Boolean deleteSupplierById(Long supplierId) {
		
		Session session=null;
		Boolean isDeleted =false;
		try {
			session=sessionFactory.openSession();
			Supplier supplier=session.get(Supplier.class, supplierId);
			session.delete(supplier);
			session.beginTransaction().commit();
		    isDeleted =true;	
		} catch (Exception e) {
			isDeleted =false;
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
	public Boolean updateSupplier(Supplier supplier) {
	
		Session session=null;
		Boolean isUpdated =false;
		try {
			session=sessionFactory.openSession();
			session.update(supplier);
			session.beginTransaction().commit();
			isUpdated =true;	
		} catch (Exception e) {
			isUpdated =false;
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
	public List<Supplier> sortSupplier(String sortBy, String fieldName) {
		Session session=null;
		List<Supplier> list =null;
		
		try {
			session=sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Supplier.class);
			
			if(sortBy.equalsIgnoreCase("asc")) {
				criteria.addOrder(Order.asc(fieldName));
			}else {
				criteria.addOrder(Order.desc(fieldName));
			}
			list=criteria.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
	return list;
	}

	
	
	@Override
	public List<Supplier> getMaxPriceSupplier() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public Double countSumOfSupplierPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public Long getTotalCountOfSupplier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Supplier getSupplieryByName(String getSupplierByName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteSupplierByName(Supplier SuppliertName) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
