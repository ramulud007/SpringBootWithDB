package com.jbk.daoIMPL;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.ProductDao;
import com.jbk.entity.Product;
import com.jbk.model.FinalProductPrice;

@Repository
public class ProductDaoIMPL implements ProductDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Boolean addProduct(Product product) {
		Session session = null;
		Boolean isAdded = false;

		try {

			session = sf.openSession();
			session.save(product);
			session.beginTransaction().commit();
			isAdded = true;

		} catch (Exception e) {
			e.printStackTrace();
			isAdded = false;
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return isAdded;
	}

	@Override
	public List<Product> getAllProducts() {
		Session session = null;
		List<Product> list = null;
		Criteria criteria = null;
		try {

			session = sf.openSession();
			criteria = session.createCriteria(Product.class);
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
			list = null;
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	@Override
	public Boolean updateProduct(Product product) {
		Session session = null;
		Boolean isUpdated = false;

		try {

			session = sf.openSession();
			session.update(product);
			session.beginTransaction().commit();
			isUpdated = true;

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}

		return isUpdated;
	}

	@Override
	public Boolean deleteProductById(Long productId) {
		Session session = null;
		Boolean isDeleted = false;

		try {
			session = sf.openSession();
			Product product = session.get(Product.class, productId);
			session.delete(product);
			session.beginTransaction().commit();
			isDeleted = true;

		} catch (Exception e) {
			e.printStackTrace();
			isDeleted = false;
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return isDeleted;
	}

	@Override
	public Product getProductById(Long productId) {

		Session session = null;
		Product product = null;
		try {
			session = sf.openSession();
			product = session.get(Product.class, productId);

		} catch (Exception e) {
			e.printStackTrace();
			product = null;
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return product;
	}

	@Override
	public Boolean deleteProductByName(Product productName) {
		Session session=null;
		Boolean isDeleted=false;
		
		try {
			session=sf.openSession();
			
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.eq("productName", productName));
			List list = criteria.list();
			if(!list.isEmpty()) {
				isDeleted=(boolean)list.get(0);
				isDeleted=false;
			}else {
				
				session.delete(productName);
				isDeleted=true;
			}
			
			
			
		} catch (Exception e) {
			isDeleted=false;
			e.printStackTrace();
		}
		
		return isDeleted;
	}

	@Override
	public List<Product> sortProducts(String sortBy, String fieldName) {
		Session session=null;
		List<Product> listOfProducts=null;
		
		try {
			session=sf.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			if(sortBy.equalsIgnoreCase("asc")) {
				criteria.addOrder(Order.asc(fieldName));
			}else {
				criteria.addOrder(Order.desc(fieldName));
			}
			listOfProducts=criteria.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return listOfProducts;
	}

	public Double getMaxPrice() {
		Double maxPrice=0d;
		Session session=null;
		
		
			session =sf.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setProjection(Projections.max("productPrice"));
			List list = criteria.list();
			if(!list.isEmpty()) {
			maxPrice=(Double) list.get(0);	
			}
		return maxPrice;
		
	}
	
	@Override
	public List<Product> getMaxPriceProducts() {
		Session session=null;
		List<Product> maxPriceProduct=null;
		
		try {
		session=sf.openSession();
		Double maxPrice = getMaxPrice();
		
		if(maxPrice>0) {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.eq("productPrice", maxPrice));
			maxPriceProduct = criteria.list();
		}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return maxPriceProduct;
	}

	@Override
	public Double countSumOfProductPrice() {
		Session session=null;
		Double countSumOfProductPrice=0d;
		try {
			session=sf.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setProjection(Projections.sum("productPrice"));
			List list = criteria.list();
			
			if(!list.isEmpty()) {
			countSumOfProductPrice=(Double)list.get(0);	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return countSumOfProductPrice;
	}

	@Override
	public Long getTotalCountOfProducts() {
		Session session=null;
		Long TotalCountOfProducts=0l;
		
		try {
			session=sf.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setProjection(Projections.count("productName"));
			List list = criteria.list();
			if(!list.isEmpty()) {
				TotalCountOfProducts=(Long)	list.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return TotalCountOfProducts;
	}

	@Override
	public Product getProductByName(String producName) {
		Session session=null;
		Product product=null;
		
		try {
			session=sf.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.like("productName", producName));
			product = (Product) criteria.uniqueResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return product;
	}

	
	  @Override 
	  
	  public String productUploadFile(List<Product> list) {
	  
	  int addedCount = 0; 
	  int alreadExixtsCount = 0; 
	  for (Product product : list) {
	  Boolean isAdded = addProduct(product);
	  
	  if (isAdded){ 
		  addedCount = addedCount + 1; 
	  } 
	  else { 
		  alreadExixtsCount =alreadExixtsCount + 1; 
		  } 
	  }
	  
	  return "addedCount: " + addedCount + " alreadExixtsCount: " +
	  alreadExixtsCount; 
	  }

	  
	@Override
	public FinalProductPrice getFinalProductPriceById(Long productId) {
		Session session=null;
		FinalProductPrice FproructPrice=null;
		
		try {
			
			session=sf.openSession();
			FproructPrice = session.get(FinalProductPrice.class, productId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return FproructPrice;
	}
	 
}
