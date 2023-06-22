package br.com.Inclusivecare.controllers;

import br.com.Inclusivecare.models.pessoaJuridica.DetalhamentoPessoaJuridicaRecord;
import br.com.Inclusivecare.models.pessoaJuridica.PessoaJuridica;
import br.com.Inclusivecare.models.pessoaJuridica.PessoaJuridicaRecord;
import br.com.Inclusivecare.services.PessoaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pessoajuridica")
public class PessoaJuridicaController {

    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;

    @PostMapping("/criar")
    public ResponseEntity create(@RequestBody PessoaJuridicaRecord pessoaJuridica, UriComponentsBuilder builder){
        var pessoa = pessoaJuridicaService.create(pessoaJuridica.toPessoa());
        var uri = builder.path("/pessoajuridica/criar/{id}").buildAndExpand(pessoa.getCnpj()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoPessoaJuridicaRecord(pessoa));
    }

    @GetMapping
    public ResponseEntity findAll(@PageableDefault Pageable page){
        var pessoa = pessoaJuridicaService.findAll(page);
        return ResponseEntity.ok(pessoa);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String cnpj){
        pessoaJuridicaService.delete(cnpj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable String cnpj){
        var pessoa = pessoaJuridicaService.getById(cnpj);
        return ResponseEntity.ok(new DetalhamentoPessoaJuridicaRecord(pessoa));
    }


}
