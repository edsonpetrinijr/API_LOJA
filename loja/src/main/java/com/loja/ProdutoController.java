package com.loja;

import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Produto cadastrarNovoProduto(@RequestBody Produto novoProduto) {
        return this.tabelaProdutos.createNewProduto(novoProduto);
    }

    @PutMapping("/{produtoId}")
    public void atualizarProduto(@PathVariable int produtoId, @RequestBody Produto novasInformacoesDoProduto) {
        this.tabelaProdutos.updateProduct(produtoId, novasInformacoesDoProduto);
    }

}
