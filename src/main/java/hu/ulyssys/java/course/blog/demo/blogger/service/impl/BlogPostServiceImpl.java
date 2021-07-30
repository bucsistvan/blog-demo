package hu.ulyssys.java.course.blog.demo.blogger.service.impl;

import hu.ulyssys.java.course.blog.demo.blogger.entity.BlogPost;
import hu.ulyssys.java.course.blog.demo.blogger.service.BlogPostService;

import java.util.ArrayList;
import java.util.List;

public class BlogPostServiceImpl implements BlogPostService {

    List<BlogPost> list = new ArrayList();

    @Override
    public List<BlogPost> getAll() {
        return list;
    }

    @Override
    public void add(BlogPost blogPost) {
        list.add(blogPost);
    }

    @Override
    public void remove(BlogPost blogPost) {
        list.remove(blogPost);
    }

    @Override
    public void update(BlogPost blogPost) {
        for (BlogPost blogPost1: getAll()) {
            if(blogPost1.getId().equals(blogPost.getId())){
                blogPost1.setTitle(blogPost.getTitle());
                blogPost1.setContent(blogPost.getContent());
                blogPost1.setCategory(blogPost.getCategory());
                blogPost1.setCreatedDate(blogPost.getCreatedDate());
                blogPost1.setLastModifiedDate(blogPost.getLastModifiedDate());
                blogPost1.setPublishedDate(blogPost.getPublishedDate());
                break;
            }
        }
    }
}
