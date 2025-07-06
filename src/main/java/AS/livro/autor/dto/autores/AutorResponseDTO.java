package AS.livro.autor.dto.autores;

import java.util.List;

public class AutorResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private String biografia;
    private List<AutorLivroDTO> livros;

    public AutorResponseDTO(Long id, String nome, String email, String biografia, List<AutorLivroDTO> livros) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.biografia = biografia;
        this.livros = livros;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getBiografia() {
        return biografia;
    }

    public List<AutorLivroDTO> getLivros() {
        return livros;
    }
}
