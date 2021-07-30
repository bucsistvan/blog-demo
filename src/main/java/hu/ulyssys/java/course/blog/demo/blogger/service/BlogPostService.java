package hu.ulyssys.java.course.blog.demo.blogger.service;

import hu.ulyssys.java.course.blog.demo.blogger.entity.BlogPost;

import java.util.List;

public interface BlogPostService {

    List<BlogPost> getAll();

    void add(BlogPost blogPost);

    void remove(BlogPost blogPost);

    void update(BlogPost blogPost);
}
