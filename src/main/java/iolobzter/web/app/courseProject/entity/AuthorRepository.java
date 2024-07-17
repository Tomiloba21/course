package iolobzter.web.app.courseProject.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource
public interface AuthorRepository extends CrudRepository<Author, Long> {

    //
}
