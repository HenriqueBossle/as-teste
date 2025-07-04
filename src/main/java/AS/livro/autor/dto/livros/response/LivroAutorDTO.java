package AS.livro.autor.dto.livros.response;

public class LivroAutorDTO {
    private Long id;
    private String nome;
    private String email;
    private String biografia;

    public LivroAutorDTO() {}

    public LivroAutorDTO(Long id, String nome, String email, String biografia) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.biografia = biografia;
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
