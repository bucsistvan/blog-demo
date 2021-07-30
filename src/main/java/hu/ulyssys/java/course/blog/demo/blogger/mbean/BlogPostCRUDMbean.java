package hu.ulyssys.java.course.blog.demo.blogger.mbean;

import hu.ulyssys.java.course.blog.demo.blogger.entity.BlogPost;
import hu.ulyssys.java.course.blog.demo.blogger.entity.Category;
import hu.ulyssys.java.course.blog.demo.blogger.service.BlogPostService;
import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class BlogPostCRUDMbean implements Serializable {

    private List<BlogPost> list;

    private BlogPost selectedBlogPost;

    private String category;

    @Inject
    private BlogPostService blogPostService;

    @PostConstruct
    private void init(){
        list = blogPostService.getAll();
        selectedBlogPost = new BlogPost();
    }

    public void initSave() {
        selectedBlogPost = new BlogPost();
    }


    public void save() {
        if (selectedBlogPost.getId() == null) {
            selectedBlogPost.setId(System.currentTimeMillis());
            blogPostService.add(selectedBlogPost);
            list = blogPostService.getAll();
            selectedBlogPost = new BlogPost();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres hozzáadás"));
        } else {
            blogPostService.update(selectedBlogPost);
            list = blogPostService.getAll();
            selectedBlogPost = new BlogPost();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres módosítás"));
        }
        PrimeFaces.current().executeScript("PF('authorDialog').hide()");
    }

    public void remove(){
        blogPostService.remove(selectedBlogPost);
        list = blogPostService.getAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres törlés"));
        selectedBlogPost = new BlogPost();
    }

    public void setCategory(String category) {
        this.category = category;
        selectedBlogPost.setCategory(Category.valueOf(category));
        System.out.println("A választott kategória: "+category);
    }

    public String getCategory() {
        return category;
    }

    public Category[] getCategories(){
        return Category.values();
    }

    public List<BlogPost> getList() {
        return list;
    }

    public void setList(List<BlogPost> list) {
        this.list = list;
    }

    public BlogPost getSelectedBlogPost() {
        return selectedBlogPost;
    }

    public void setSelectedBlogPost(BlogPost selectedBlogPost) {
        this.selectedBlogPost = selectedBlogPost;
    }
}
