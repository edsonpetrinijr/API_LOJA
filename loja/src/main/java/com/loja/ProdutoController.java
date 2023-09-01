package com.loja;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    private TabelaProdutos tabelaProdutos;

    public ProdutoController() {
        this.tabelaProdutos = new TabelaProdutos();
    }

    @GetMapping
    public List<Produto> buscarTodosOsProdutos() {
        return this.tabelaProdutos.getProdutos();
    }

    @GetMapping("/{produtoId}")
    public Produto buscarProdutoPeloId(@PathVariable int produtoId) {
        Produto produtoProcurado = this.tabelaProdutos.getProdutosById(produtoId);

        return produtoProcurado;
    }

}
