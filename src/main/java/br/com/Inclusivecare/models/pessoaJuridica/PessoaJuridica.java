package br.com.Inclusivecare.models.pessoaJuridica;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pessoas_juridicas")
public class PessoaJuridica {
    @Id
    private String cnpj;
    private String nomeFantasia;
    private String telefone;
    private String email;
    private String senha;
    private String cep;
}
