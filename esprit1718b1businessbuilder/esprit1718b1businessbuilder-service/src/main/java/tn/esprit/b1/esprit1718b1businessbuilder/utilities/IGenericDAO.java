package tn.esprit.b1.esprit1718b1businessbuilder.utilities;

import java.util.List;

public interface IGenericDAO<T> {
	public void save(T entity);

	public void delete(T entity);

	public T update(T entity);

	public T find(Long entityID);

	public List<T> findAll();

}
