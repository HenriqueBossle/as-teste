package AS.livro.autor.services;

import AS.livro.autor.dto.livros.request.LivroRequest;
import AS.livro.autor.dto.livros.response.LivroResponseDTO;
import AS.livro.autor.entities.Livro;
import AS.livro.autor.entities.Autor;
import AS.livro.autor.repositories.LivroRepository;
import AS.livro.autor.repositories.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    public LivroService(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    public List<LivroResponseDTO> getAllLivros() {
        return this.livroRepository.findAll()
                .stream()
                .map(item -> new LivroResponseDTO(
                        item.getTitulo(),
                        item.getDescricao(),
                        item.getAutor().getNome() // apenas o nome
                )).toList();
    }

    public Livro getLivro(Long id) {
        return livroRepository.findById(id).orElseThrow();
    }

    public Livro createLivro(LivroRequest livroRequest) {
        Autor autor = autorRepository.findById(livroRequest.getAutorId()).orElseThrow();

        Livro livro = new Livro();
        livro.setTitulo(livroRequest.getTitulo());
        livro.setDescricao(livroRequest.getDescricao());
        livro.setAutor(autor);

        return livroRepository.save(livro);
    }

    public Livro updateLivro(Long id, LivroRequest livroRequest) {
        Livro livro = livroRepository.findById(id).orElseThrow();
        Autor autor = autorRepository.findById(livroRequest.getAutorId()).orElseThrow();

        livro.setTitulo(livroRequest.getTitulo());
        livro.setDescricao(livroRequest.getDescricao());
        livro.setAutor(autor);

        return livroRepository.save(livro);
    }

    public void deleteLivro(Long id) {
        livroRepository.deleteById(id);
    }
}
