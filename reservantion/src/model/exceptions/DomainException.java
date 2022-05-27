package model.exceptions;

public class DomainException extends RuntimeException{
    private static final long serialVersiononUID = 1L;
    public DomainException(String msg){
        super(msg);
    }
}

/*Serializar um objeto, dentro da plataforma Java, significa converter o estado atual dele em um
formato padrão e depois disponibilizá-lo em um stream de bytes que poderá ser escrito em disco ou
transmitido.

Repare que a palavra serializar, dentro do Java, é um pouco mais do que “entregar em partes” –
que seria a definição da mesma. É preciso que essas partes tenham uma estrutura padronizada para que
seja possível a desserialização.*/
