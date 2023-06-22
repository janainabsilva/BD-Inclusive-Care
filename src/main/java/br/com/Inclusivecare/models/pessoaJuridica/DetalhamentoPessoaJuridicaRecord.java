package br.com.Inclusivecare.models.pessoaJuridica;

public record DetalhamentoPessoaJuridicaRecord(String nomeFantasia, String email, String cep) {
    public DetalhamentoPessoaJuridicaRecord(PessoaJuridica pessoaJuridica){
        this(pessoaJuridica.getNomeFantasia(), pessoaJuridica.getEmail(), pessoaJuridica.getCep());
    }
}
