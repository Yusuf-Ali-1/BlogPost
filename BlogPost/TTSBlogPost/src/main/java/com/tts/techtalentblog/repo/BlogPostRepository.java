package com.tts.techtalentblog.repo;

import com.tts.techtalentblog.model.BlogPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
//we're passing the generic data types in to instruct CrudRepository how to setup our database
public interface BlogPostRepository extends CrudRepository<BlogPost, Long> {
    List<BlogPost> findAll();
//    List<BlogPost> findByAuthorIgnoreCase(String author);
//	List<BlogPost> save(String blogPost);

    BlogPost findById(long id);
    BlogPost deleteById(long id);


}
