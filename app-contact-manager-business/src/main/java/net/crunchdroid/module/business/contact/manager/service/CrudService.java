package net.crunchdroid.module.business.contact.manager.service;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author cdi316
 * @param <T>
 * @param <ID>
 */
public interface CrudService<T, ID extends Serializable> {

    /**
     * Saves a given entity. Use the returned instance for further operations as the save operation might have changed
     * the entity instance completely.
     *
     * @param entity
     * @return the saved entity
     */
    T save(T entity);

    /**
     * Saves all given entities.
     *
     * @param entities
     * @return the saved entities
     * @throws IllegalArgumentException in case the given entity is (@literal null}.
     */
    List<T> save(List<T> entities);

    /**
     * Saves a given entity. Use the returned instance for further operations as the save operation might have changed
     * the entity instance completely.
     *
     * @param entity
     * @return the updated entity
     */
    T update(T entity);

    /**
     * Saves all given entities.
     *
     * @param entities
     * @return the updated entities
     * @throws IllegalArgumentException in case the given entity is (@literal null}.
     */
    List<T> update(List<T> entities);

    /**
     * Retrieves an entity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the entity with the given id or {@literal null} if none found
     * @throws IllegalArgumentException if {@code id} is {@literal null}
     */
    T findOne(ID id);

    /**
     * Returns whether an entity with the given id exists.
     *
     * @param id must not be {@literal null}.
     * @return true if an entity with the given id exists, {@literal false} otherwise
     * @throws IllegalArgumentException if {@code id} is {@literal null}
     */
    boolean exists(ID id);

    /**
     * Returns all instances of the type.
     *
     * @return all entities
     */
    List<T> findAll();

    /**
     * Returns all instances of the type with the given IDs.
     *
     * @param ids
     * @return
     */
    List<T> findAll(List<ID> ids);

    /**
     * Returns the number of entities available.
     *
     * @return the number of entities
     */
    Long count();

    /**
     * Deletes the entity with the given id.
     *
     * @param id must not be {@literal null}.
     * @throws IllegalArgumentException in case the given {@code id} is {@literal null}
     */
    void delete(ID id);

    /**
     * Deletes a given entity.
     *
     * @param entity
     * @throws IllegalArgumentException in case the given entity is (@literal null}.
     */
    void delete(T entity);

    /**
     * Deletes the given entities.
     *
     * @param entities
     * @throws IllegalArgumentException in case the given {@link List} is (@literal null}.
     */
    void delete(List<T> entities);

    /**
     * Deletes all entities managed by the repository.
     */
    void deleteAll();

}
