package com.metacube.angularwebapi.dao;

import java.io.Serializable;
import java.util.Map;
import javax.ws.rs.core.MultivaluedMap;

public interface AbstractDao<T, ID extends Serializable>
{
	<S extends T> S save(S entity);
	T findOne(ID primaryKey);
	Iterable<T> findAll();
        Iterable<T> findAll(Map<String, String> conditions);
        <S extends T>T update(S entity);
	Long count();
	T delete(ID primaryKey);
	boolean exists(ID primaryKey);
        Iterable<T> search(String query);
}
