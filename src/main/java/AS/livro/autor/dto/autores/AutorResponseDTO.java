package AS.livro.autor.dto.autores;

import java.util.ArrayList;
import java.util.List;

public class AutorResponseDTO {
    private String nome;
    private String email;
    private String biografia;
    private List<AutorLivroDTO> livros = new ArrayList<>();

    public AutorResponseDTO(String nome, String email, String biografia, List<AutorLivroDTO> livros) {
        this.nome = nome;
        this.email = email;
        this.biografia = biografia;
        this.livros = livros;
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

    public List<AutorLivroDTO> getLivros() {
        return livros;
    }

    public void setLivros(List<AutorLivroDTO> livros) {
        this.livros = livros;
    }
}
