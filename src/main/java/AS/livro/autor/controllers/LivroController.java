package AS.livro.autor.controllers;

import AS.livro.autor.dto.livros.request.LivroRequest;
import AS.livro.autor.dto.livros.response.LivroResponseDTO;
import AS.livro.autor.entities.Livro;
import AS.livro.autor.services.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<LivroResponseDTO> getAllLivros() {
        return this.livroService.getAllLivros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> getLivroById(@PathVariable Long id) {
        Livro livro = livroService.getLivro(id);
        LivroResponseDTO dto = new LivroResponseDTO(
                livro.getTitulo(),
                livro.getDescricao(),
                livro.getAutor().getNome()
        );
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<Livro> createLivro(@RequestBody LivroRequest livroRequest) {
        Livro livro = this.livroService.createLivro(livroRequest);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(livro.getId()).toUri();

        return ResponseEntity.created(uri).body(livro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> updateLivro(@PathVariable Long id, @RequestBody LivroRequest livroRequest) {
        Livro livro = livroService.updateLivro(id, livroRequest);
        return ResponseEntity.ok(livro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivro(@PathVariable Long id) {
        livroService.deleteLivro(id);
        return ResponseEntity.noContent().build();
    }
}
