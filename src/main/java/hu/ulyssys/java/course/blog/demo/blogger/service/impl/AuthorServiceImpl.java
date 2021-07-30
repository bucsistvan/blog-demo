package hu.ulyssys.java.course.blog.demo.blogger.service.impl;

import hu.ulyssys.java.course.blog.demo.blogger.entity.Author;
import hu.ulyssys.java.course.blog.demo.blogger.service.AuthorService;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AuthorServiceImpl implements AuthorService {

    List<Author> list = new ArrayList();

    @Override
    public List<Author> getAll() {
        return list;
    }

    @Override
    public void add(Author author) {
        list.add(author);
    }

    @Override
    public void remove(Author author) {
        list.remove(author);
    }

    @Override
    public void update(Author author) {
        for (Author author1: getAll()) {
            if(author1.getId().equals(author.getId())){
                author1.setFirstName(author.getFirstName());
                author1.setLastName(author.getLastName());
                author1.setUserName(author.getUserName());
                author1.setCreatedDate(author.getCreatedDate());
                author1.setLastModifiedDate(author.getLastModifiedDate());
                break;
            }
        }
    }
}
