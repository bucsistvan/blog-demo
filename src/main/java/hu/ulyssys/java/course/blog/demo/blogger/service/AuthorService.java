package hu.ulyssys.java.course.blog.demo.blogger.service;

import hu.ulyssys.java.course.blog.demo.blogger.entity.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAll();

    void add(Author author);

    void remove(Author author);

    void update(Author author);
}
