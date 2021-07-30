package hu.ulyssys.java.course.blog.demo.blogger.mbean;

import hu.ulyssys.java.course.blog.demo.blogger.entity.Author;
import hu.ulyssys.java.course.blog.demo.blogger.service.AuthorService;
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
public class AuthorCRUDMbean implements Serializable {

    private List<Author> list;

    private Author selectedAuthor;

    @Inject
    private AuthorService authorService;

    @PostConstruct
    private void init(){
        list = authorService.getAll();
        selectedAuthor = new Author();
    }

    public void initSave() {
        selectedAuthor = new Author();
    }


    public void save() {
        if (selectedAuthor.getId() == null) {
            selectedAuthor.setId(System.currentTimeMillis());
            authorService.add(selectedAuthor);
            list = authorService.getAll();
            selectedAuthor = new Author();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres hozzáadás"));
        } else {
            authorService.update(selectedAuthor);
            list = authorService.getAll();
            selectedAuthor = new Author();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres módosítás"));
        }
        PrimeFaces.current().executeScript("PF('authorDialog').hide()");
    }

    public void remove(){
        authorService.remove(selectedAuthor);
        list = authorService.getAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres törlés"));
        selectedAuthor = new Author();
    }

    public List<Author> getList() {
        return list;
    }

    public void setList(List<Author> list) {
        this.list = list;
    }

    public Author getSelectedAuthor() {
        return selectedAuthor;
    }

    public void setSelectedAuthor(Author selectedAuthor) {
        this.selectedAuthor = selectedAuthor;
    }
}
