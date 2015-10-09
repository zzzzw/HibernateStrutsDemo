package com.zq.www.common;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

//使用泛型
public class BaseDAO<T> {

	 
	/*
	 * 得到session，所有增删改查都从session开始
	 */
    public  Session gs() throws HibernateException {
		     
	       return HibernateSessionFactory.getSession();
	    }
	
	/*
	 * 根据T得到真正的class类型，使用反射
	 */
	protected Class<T> entityClass;

	protected Class getEntityClass() {
		if (entityClass == null) {
			entityClass = (Class<T>) ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
		}
		return entityClass;
	}

	
	
	
	

	/*
	 * 添加
	 */
	public void add(T t) {
		Transaction tx = null;
		try {
			tx = gs().beginTransaction();
			gs().save(t);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			gs().close();
		}

	}
	
	/*
	 * 更新
	 */
	public void update(T t) {
		Transaction tx = null;
		try {
			tx = gs().beginTransaction();
			gs().update(t);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			gs().close();
		}

	}

	/*
	 * 删除
	 */
	public void delete(Integer id) {
		//先查询
		T  t=this.get(id);		
		
		Transaction tx = null;
		try {
			tx = gs().beginTransaction();
			gs().delete(t);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			gs().close();
		}

	}
	
	/*
	 * 删除
	 */
	public void delete(T t) {		 
		Transaction tx = null;
		try {
			tx = gs().beginTransaction();
			gs().delete(t);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			gs().close();
		}

	}

	/*
	 * 查询
	 */
	public T get(Integer id) {
		T instance = (T) gs().get(getEntityClass(), id);
		gs().close();
		return instance;
         
	}
	


	/*
	 * 自动判断添加或修改，保存
	 */
	public void save(T t) {
		Transaction tx = null;
		try {
			tx = gs().beginTransaction();
			gs().saveOrUpdate(t);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			gs().close();
		}

	}
	
	
	/*
	 * 查询全部
	 */
	public List<T> listall() {
		List<T> result=gs().createCriteria(getEntityClass()).list();
		gs().close();
		return result;
	}
	
	
	/*
	 * 通用查询
	 */
	
	public List<T> getListByHQL(final String hqlString, final List values) {
		Query query = gs().createQuery(hqlString);
		if (values != null) {
			Object[] vvs = values.toArray(new Object[values.size()]);
			for (int i = 0; i < vvs.length; i++) {
				query.setParameter(i, vvs[i]);
			}
		}
		return query.list();
	}

}
