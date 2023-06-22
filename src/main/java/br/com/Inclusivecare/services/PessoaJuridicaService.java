package br.com.Inclusivecare.services;

import br.com.Inclusivecare.models.pessoaJuridica.PessoaJuridica;
import br.com.Inclusivecare.repositories.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PessoaJuridicaService {

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    //create
    public PessoaJuridica create(PessoaJuridica pessoaJuridica){
        return pessoaJuridicaRepository.save(pessoaJuridica);
    }

    //read
    public PessoaJuridica getById(String cnpj){
        var pessoa = pessoaJuridicaRepository.findById(cnpj);
        if(pessoa.isEmpty()){
            throw new RuntimeException("Não existe");
        }else{
            return pessoa.get();
        }
    }

    public Page findAll(Pageable page){
        return pessoaJuridicaRepository.findAll(page);
    }

    //update

    //delete
    public void delete(String cnpj){
        pessoaJuridicaRepository.deleteById(cnpj);
    }
}
