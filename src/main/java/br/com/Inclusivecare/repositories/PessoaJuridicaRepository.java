package br.com.Inclusivecare.repositories;

import br.com.Inclusivecare.models.pessoaJuridica.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, String> {
    PessoaJuridica findByEMail(String email);
}
