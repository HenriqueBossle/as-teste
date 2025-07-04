package AS.livro.autor.dto.livros.request;

public class LivroRequest {
    private Long autorId;
    private String titulo;
    private String descricao;

    public LivroRequest() {}

    public LivroRequest(Long autorId, String titulo, String descricao) {
        this.autorId = autorId;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
