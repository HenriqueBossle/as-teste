package AS.livro.autor.services;

import AS.livro.autor.dto.autores.AutorLivroDTO;
import AS.livro.autor.dto.autores.AutorResponseDTO;
import AS.livro.autor.entities.Autor;
import AS.livro.autor.repositories.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorService {
    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<AutorResponseDTO> getAutores() {
        List<Autor> autores = autorRepository.findAll();

        return autores.stream().map(autor -> new AutorResponseDTO(
                autor.getId(),
                autor.getNome(),
                autor.getEmail(),
                autor.getBiografia(),
                autor.getLivros().stream()
                        .map(livro -> new AutorLivroDTO(
                                livro.getId(),
                                livro.getTitulo(),
                                livro.getDescricao()
                        ))
                        .collect(Collectors.toList())
        )).collect(Collectors.toList());
    }

    // Mantém os outros métodos, mas adaptando os retornos para entidades quando necessário.
    // ...

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
