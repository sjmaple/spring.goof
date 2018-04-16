package org.snyk.groceries.repository;

import java.util.List;

import org.snyk.groceries.domain.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ItemRepository extends CrudRepository<Item, Long> {

	@Query ("select i from Item i where i.cost > ?#{[0]}")
	List<Item> findByCost(@Param("cost") Double cost);

	List<Item> findByName(@Param("name") String name);
	List<Item> findAll();
	
}
