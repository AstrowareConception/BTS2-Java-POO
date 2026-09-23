package fr.bts.sio.quality;

public final class CatalogImportException extends RuntimeException {
    private final int lineNumber;

    public CatalogImportException(String message, int lineNumber, Throwable cause) {
        super(message, cause);
        this.lineNumber = lineNumber;
    }

    public int lineNumber() {
        return lineNumber;
    }
}
