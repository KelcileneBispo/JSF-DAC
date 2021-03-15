package br.edu.ifpb.domain;

    public class CPF {
    private String numero;
    private static final int TAMANHO = 11;

    public CPF() {
    }

    public CPF(String numero) {
        this.numero = numero;
    }


    public boolean  valido(){
        return this.numero.length() == TAMANHO;
    }

    public String formatado(){
        return String.format(
                "%s.%s.%s-%s",
                this.numero.substring(0,3),
                this.numero.substring(3,6),
                this.numero.substring(6,9),
                this.numero.substring(9,11)
        );
    }

    public String valor() {
        return this.numero;
    }
}
