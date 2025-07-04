package AS.livro.autor.services;

import AS.livro.autor.dto.autores.AutorLivroDTO;
import AS.livro.autor.dto.autores.AutorResponseDTO;
import AS.livro.autor.entities.Autor;
import AS.livro.autor.repositories.AutorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AutorService {
    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Page<AutorResponseDTO> getAutores(Pageable pageable) {
        return autorRepository.findAll(pageable)
                .map(autor -> new AutorResponseDTO(
                        autor.getNome(),
                        autor.getEmail(),
                        autor.getBiografia(),
                        autor.getLivros().stream()
                                .map(livro -> new AutorLivroDTO(
                                        livro.getId(),
                                        livro.getTitulo(),
                                        livro.getDescricao()
                                ))
                                .toList()
                ));
    }

    public Autor getAutor(Long id) {
        return autorRepository.findById(id).orElseThrow();
    }

    public Autor createAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor updateAutor(Long id, Autor autorAtualizado) {
        Autor autor = autorRepository.findById(id).orElseThrow();

        autor.setNome(autorAtualizado.getNome());
        autor.setEmail(autorAtualizado.getEmail());
        autor.setBiografia(autorAtualizado.getBiografia());

        return autorRepository.save(autor);
    }

    public void deleteAutor(Long id) {
        autorRepository.deleteById(id);
    }
}
