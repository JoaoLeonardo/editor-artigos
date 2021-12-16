package br.edu.utfpr.editorartigos.exception;

public class UsuarioLogadoDiferenteDoAutorException extends Exception {

    private final String message;

    public UsuarioLogadoDiferenteDoAutorException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
