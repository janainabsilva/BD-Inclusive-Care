package br.com.Inclusivecare.models.pessoaJuridica;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PessoaJuridicaRecord(@NotNull
                                   @Size(min = 11, max = 11)
                                   String cnpj,
                                   String nomeFantasia,
                                   String telefone,
                                   @Email
                                   String email,
                                   String senha,
                                   String cep) {
    public PessoaJuridica toPessoa(){
        return new PessoaJuridica(cnpj(), nomeFantasia(), telefone(), email(), senha(), cep());
    }
}
