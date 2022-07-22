package br.com.alura.linguagensapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemController {

    private List<Linguagem> linguagens;

    @Autowired
    public LinguagemController(List<Linguagem> linguagens) {
        this.linguagens = linguagens;
    }

    @GetMapping(value = "/linguagens")
    public List<Linguagem> getLinguagens() {
        return linguagens;
    }

}
