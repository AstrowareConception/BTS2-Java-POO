package fr.bts.sio.api.movie;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/movies")
public final class MovieController {
    private final CatalogService service;

    public MovieController(CatalogService service) {
        this.service = service;
    }

    @GetMapping
    public List<MovieResponse> search(
            @RequestParam(defaultValue = "") String query,
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "20") @Min(1) @Max(100) int size) {
        return service.search(query, page, size);
    }

    @GetMapping("/{id}")
    public MovieResponse findById(@PathVariable @Min(1) long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<MovieResponse> create(@Valid @RequestBody CreateMovieRequest request) {
        MovieResponse created = service.create(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.id())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PatchMapping("/{id}/archive")
    public ResponseEntity<Void> archive(@PathVariable @Min(1) long id) {
        service.archive(id);
        return ResponseEntity.noContent().build();
    }
}
