package AS.livro.autor.controllers;

import AS.livro.autor.dto.autores.AutorResponseDTO;
import AS.livro.autor.entities.Autor;
import AS.livro.autor.services.AutorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/autores")
public class AutorController {
    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public ResponseEntity<Page<AutorResponseDTO>> getAutores(Pageable pageable) {
        return ResponseEntity.ok(this.autorService.getAutores(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutor(@PathVariable Long id) {
        return ResponseEntity.ok(this.autorService.getAutor(id));
    }

    @PostMapping
    public ResponseEntity<Autor> createAutor(@RequestBody Autor autor) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(autor.getId()).toUri();

        return ResponseEntity.created(uri).body(this.autorService.createAutor(autor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> updateAutor(@PathVariable Long id, @RequestBody Autor autorAtualizado) {
        Autor autor = autorService.updateAutor(id, autorAtualizado);
        return ResponseEntity.ok(autor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Long id) {
        this.autorService.deleteAutor(id);
        return ResponseEntity.noContent().build();
    }
}
