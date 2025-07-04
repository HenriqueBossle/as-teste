package AS.livro.autor.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String email;
    private String biografia;
    @OneToMany(mappedBy = "autor")
    private List<Livro> livros = new ArrayList<>();

    public Autor() {}

    public Autor(Long id, String nome, String email, String biografia, List<Livro> livros) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.biografia = biografia;
        this.livros = livros;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}
