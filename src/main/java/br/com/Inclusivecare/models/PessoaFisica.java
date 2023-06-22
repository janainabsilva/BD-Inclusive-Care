package br.com.Inclusivecare.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pessoas_fisica")
public class PessoaFisica {
    @Id
    private String email;
    private String nome;
    private String senha;
}
