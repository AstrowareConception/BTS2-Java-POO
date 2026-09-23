package fr.bts.sio.api.shared;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * À compléter : une méthode @ExceptionHandler par famille d'erreurs utile.
 * Toutes les réponses doivent partager un format cohérent.
 */
@RestControllerAdvice
public final class ApiExceptionHandler {
    public ProblemDetail todo() {
        return ProblemDetail.forStatus(501);
    }
}
