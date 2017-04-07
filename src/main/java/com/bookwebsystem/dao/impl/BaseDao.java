/**
 * 
 */
package com.bookwebsystem.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import com.bookwebsystem.vo.PageViewVO;


/**
 * @author 鲁永刚
 *
 */
@SuppressWarnings({ "unchecked" })
public class BaseDao implements BeanFactoryAware  {
	
	@Resource
	protected SessionFactory sessionFactory=null;
	protected BeanFactory beanFactory;
	
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory=beanFactory;
	}
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	protected <T> T getModel(Class<T> cls,Serializable id) {
		Object obj = getSession().get(cls, id);
		return (T)obj;
	}
	
	protected <T> T getSingleObject(String hql) {
		return getSingleObject(hql, null,null);
	}
	
	protected <T> T getSingleObject(String hql,Object[] objParams) {
		return getSingleObject(hql, null,objParams);
	}
	
	protected <T> T getSingleObject(String hql,Map<String, Object> mapParams) {
		return getSingleObject(hql, mapParams,null);
	}
	
	protected <T> T getSingleObject(String hql,Map<String, Object> mapParams,Object[] objParams) {
		Query query=getQuery(hql, mapParams, objParams);
		List<T> list=query.list();
		if(list.size()>0)
			return list.get(0);
		return null;
	}
	
	public <T> List<T> 	getListObjcetForSql(String Sql)
	{
		SQLQuery sqlQuery = getSQLQuery(Sql,null,null);
	    return sqlQuery.list();
	}
	
	public <T> List<T> 	getListObjcetForSql(String Sql,Map<String, Object> mapParams)
	{
		SQLQuery sqlQuery = getSQLQuery(Sql,mapParams,null);
	    return sqlQuery.list();
	}
	
	public <T> List<T> 	getListObjcetForSql(String Sql,Map<String, Object> mapParams,Class<T> t)
	{
		SQLQuery sqlQuery = getSQLQuery(Sql,mapParams,null);
	    return sqlQuery.addEntity(t).list();
	}
	
	protected <T> List<T> getListObject(String hql) {
		return getListObject(hql, null,null);
	}
	
	protected <T> List<T> getListObject(String hql,Object[] objParams) {
		return getListObject(hql, null,objParams);
	}
	protected <T> List<T> getListObject(String hql,int maxResult) {
		return getListObject(hql, null,null,maxResult);
	}
	
	protected <T> List<T> getListObject(String hql,Object[] objParams,int maxResult) {
		return getListObject(hql, null,objParams,maxResult);
	}
	
	protected <T> List<T> getListObject(String hql,Map<String, Object> mapParams) {
		return getListObject(hql, mapParams,null);
	}
	
	protected <T> List<T> getListObject(String hql,Map<String, Object> mapParams,int maxResult) {
		return getListObject(hql, mapParams,null,maxResult);
	}
	
	
	protected <T> List<T> getListObject(String hql,Map<String,Object> mapParams,Object[] objParams) {
		Query query=getQuery(hql, mapParams, objParams);
		return (List<T>)query.list();
	}
	
	protected <T> List<T> getListObject(String hql,Map<String,Object> mapParams,Object[] objParams,int maxCount) {
		Query query=getQuery(hql, mapParams, objParams);
		query.setFirstResult(0);
		query.setMaxResults(maxCount);
		return (List<T>)query.list();
	}
	
	protected <T> List<T> getListObject(String hql,int pageIndex,int pageSize) {
		Query query=getQuery(hql,null,null);
		query.setFirstResult((pageIndex-1)*pageSize);
		query.setMaxResults(pageSize);
		return (List<T>)query.list();
	}
	
	protected <T> List<T> getListObject(String hql,Object[] objParams,int pageIndex,int pageSize) {
		Query query=getQuery(hql,null,objParams);
		query.setFirstResult((pageIndex-1)*pageSize);
		query.setMaxResults(pageSize);
		return (List<T>)query.list();
	}
	
	protected <T> List<T> getListObject(String hql,Map<String,Object> mapParams,int pageIndex,int pageSize) {
		Query query=getQuery(hql,mapParams,null);
		query.setFirstResult((pageIndex-1)*pageSize);
		query.setMaxResults(pageSize);
		return (List<T>)query.list();
	}
	
	protected <T> List<T> getListObject(String hql,Object[] objParams,Map<String,Object> mapParams,int pageIndex,int pageSize) {
		Query query=getQuery(hql,mapParams,objParams);
		query.setFirstResult((pageIndex-1)*pageSize);
		query.setMaxResults(pageSize);
		return (List<T>)query.list();
	}
	
	protected <T> List<T> getListObject(Class<T> cls,String hql,int pageIndex,int pageSize) {
		Query query=getQuery(hql,null,null);
		query.setFirstResult((pageIndex-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.setResultTransformer(Transformers.aliasToBean(cls)).list();
	}
	
	protected <T> List<T> getListObject(Class<T> cls,String hql,Object[] objParams,Map<String,Object> mapParams,int pageIndex,int pageSize) {
		Query query=getQuery(hql,mapParams,objParams);
		query.setFirstResult((pageIndex-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.setResultTransformer(Transformers.aliasToBean(cls)).list();
	}
	
	protected <T> List<T> getListObject(Class<T> cls,String hql) {
		return getListObject(cls,hql, null,null);
	}
	
	protected <T> List<T> getListObject(Class<T> cls,String hql,Object[] objParams) {
		return getListObject(cls,hql, null,objParams);
	}
	
	protected <T> List<T> getListObject(Class<T> cls,String hql,Map<String, Object> mapParams) {
		return getListObject(cls,hql, mapParams,null);
	}
	
	protected <T> List<T> getListObject(Class<T> cls,String hql,Map<String,Object> mapParams,Object[] objParams) {
		Query query=getQuery(hql, mapParams, objParams);
		return query.setResultTransformer(Transformers.aliasToBean(cls)).list();
	}
	
	protected <T> T getFirstObject(String hql) {
		return getFirstObject(hql, null,null);
	}
	
	protected <T> T getFirstObject(String hql,Object[] objParams) {
		return getFirstObject(hql, null,objParams);
	}
	
	protected <T> T getFirstObject(String hql,Map<String, Object> mapParams) {
		return getFirstObject(hql, mapParams,null);
	}
	
	
	protected <T> T getFirstObject(String hql,Map<String,Object> mapParams,Object[] objParams) {
		Query query=getQuery(hql, mapParams, objParams);
		query.setFirstResult(0);
		query.setMaxResults(1);
		return (T) query.uniqueResult();
	}

	/**
	 * @param query
	 * @param mapParams
	 * @param objParams
	 */
	private Query getQuery(String hql, Map<String, Object> mapParams, Object[] objParams) {
		Session session=getSession();
		Query query=session.createQuery(hql);
		if(mapParams!=null&&mapParams.size()>0){
			for (String key : mapParams.keySet()) {
				Object obj=mapParams.get(key);
				if(obj instanceof Collection<?>){
					query.setParameterList(key, (Collection<?>)obj);
				}else if(obj instanceof Object[]){
					query.setParameterList(key, (Object[])obj);
				}else{
					query.setParameter(key, obj);
				}
			}
		}
		if(objParams!=null&&objParams.length>0){
			for (int i = 0; i < objParams.length; i++) {
				query.setParameter(i, objParams[i]);
			}
		}
		return query;
	}
	
	/**
	 * @param query
	 * @param mapParams
	 * @param objParams
	 */
	private SQLQuery getSQLQuery(String sql, Map<String, Object> mapParams, Object[] objParams) {
		Session session=getSession();
		SQLQuery query=session.createSQLQuery(sql);
		if(mapParams!=null&&mapParams.size()>0){
			for (String key : mapParams.keySet()) {
				Object obj=mapParams.get(key);
				if(obj instanceof Collection<?>){
					query.setParameterList(key, (Collection<?>)obj);
				}else if(obj instanceof Object[]){
					query.setParameterList(key, (Object[])obj);
				}else{
					query.setParameter(key, obj);
				}
			}
		}
		if(objParams!=null&&objParams.length>0){
			for (int i = 0; i < objParams.length; i++) {
				query.setParameter(i, objParams[i]);
			}
		}
		return query;
	}
	
	protected void addObj(Object obj){
		getSession().save(obj);
	}
	
	protected void mergeObj(Object obj) {
		getSession().merge(obj);
	}
	
	protected void updateObj(Object obj) {		
		getSession().update(obj);
	}
	
	protected void addOrUpdateObj(Object obj) {
		getSession().saveOrUpdate(obj);
	}
	
	protected void flush() {
		getSession().flush();
	}
	
	protected void clearCache() {
		getSession().flush();
		getSession().clear();
	}
	
	protected void deleteObj(Object obj) {
		getSession().delete(obj);
	}
	
	protected <T> PageViewVO<T> getPageViewVO(String hql,Map<String, Object> mapParams, Object[] objParams,int pageIndex,int pageSize)
	{
		Query query=getQuery(hql, mapParams, objParams);
		query.setFirstResult((pageIndex-1)*pageSize);
		query.setMaxResults(pageSize);
		List<T> list=query.list();
		int totalCount=getTotalCount(hql,mapParams,objParams);
		PageViewVO<T> pg=new PageViewVO<T>();
		pg.setCurrentPageIndex(pageIndex);
		pg.setPageRecordSize(pageSize);
		//总记录数
		pg.setTotalRecordCount(totalCount);
		//总页数
		int totalPage=(totalCount%pageSize)==0?totalCount/pageSize:totalCount/pageSize+1;
		totalPage=totalPage==0?1:totalPage;
		pg.setTotalPageCount(totalPage);
		pg.setDatas(list);
		return pg;
		
	}
	
	protected <T> PageViewVO<T> getPageViewVO(String hql,int pageIndex,int pageSize){
		return getPageViewVO(hql, null, null, pageIndex, pageSize);
	}
	
	
	protected <T> PageViewVO<T> getPageViewVO(String hql,Object[] objParams,int pageIndex,int pageSize){
		return getPageViewVO(hql, null, objParams, pageIndex, pageSize);
	}
	
	protected <T> PageViewVO<T> getPageViewVO(String hql,Map<String, Object> mapParams,int pageIndex,int pageSize)
	{
		return getPageViewVO(hql, mapParams,null, pageIndex, pageSize);
	}
	private int getTotalCount(String hql, Map<String, Object> mapParams,
			Object[] objParams) {
		int index=hql.indexOf("from");
		if(index==-1)
			throw new RuntimeException("没有from语句");
		String totalCountHql="select count(*) "+hql.substring(index, hql.length());
		long count=getSingleObject(totalCountHql,mapParams,objParams);
		return (int) count;
	}
	
	protected void executeUpdateSql(String sql) {
		SQLQuery sqlQuery=getSession().createSQLQuery(sql);
		sqlQuery.executeUpdate();
	}
	protected void executeUpdateSql(String sql, Map<String, Object> mapParams) {
		SQLQuery query=getSQLQuery(sql, mapParams, null);
		query.executeUpdate();
	}

	
}
