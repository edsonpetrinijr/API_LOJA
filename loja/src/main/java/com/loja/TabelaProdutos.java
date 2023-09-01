package com.loja;

import java.util.ArrayList;
import java.util.List;

public class TabelaProdutos {
    List<Produto> produtos = new ArrayList<>();

    /**
     * No construtor a lista de produtos
     * será preenchida :)
     */
    public TabelaProdutos() {
        Produto caneta = new Produto(1, "Caneta BIC", "Caneta BIC na cor azul", 1.99);
        Produto borracha = new Produto(2, "Borracha branca", "Borracha branca comum", 3.99);
        Produto lapis = new Produto(3, "Lápis Faber Castell", "Lápis Faber Castell comum", 2.99);
        Produto apontador = new Produto(4, "Apontador", "Apontador comum com reservatório", 7.99);
        Produto caderno = new Produto(5, "Caderno espiral", "Caderno espiral de 96 folhas", 15.99);
        Produto controle = new Produto(6, "Controle do projetor", "Controle do projetor Epson", 69.99);
        Produto tesoura = new Produto(7, "Tesoura escolar", "Tesoura escolar com cabo colorido", 4.99);
        Produto cola = new Produto(8, "Cola líquida", "Cola líquida para papel", 1.49);
        Produto marcador = new Produto(9, "Marcador de texto", "Marcador de texto amarelo", 2.29);
        Produto regua = new Produto(10, "Régua de 30 cm", "Régua de plástico transparente", 0.99);

        this.produtos.add(caneta);
        this.produtos.add(borracha);
        this.produtos.add(lapis);
        this.produtos.add(apontador);
        this.produtos.add(caderno);
        this.produtos.add(controle);
        this.produtos.add(tesoura);
        this.produtos.add(cola);
        this.produtos.add(marcador);
        this.produtos.add(regua);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    /**
     * Método que busca um produto pelo seu ID
     *
     * @param produtoId
     * @return
     */
    public Produto getProdutosById(int produtoId) {
        Produto produtoProcurado = null;

        for (Produto produto : this.produtos) {
            if (produto.getId() == produtoId) {
                produtoProcurado = produto;
                break;
            }
        }

        return produtoProcurado;
    }

    /**
     * Método que cadastra um novo produto.
     * Primeiro busca o último item na lista
     * Depois incrementa o ID
     * Atribui o novo ID para o produto a ser salvo
     * @param novoProduto
     * @return
     */
    public Produto createNewProduto(Produto novoProduto) {
        int ultimoIndex = this.produtos.size() - 1;

        Produto ultimoProduto = this.produtos.get(ultimoIndex);
        int proximoId = ultimoProduto.getId() + 1;

        novoProduto.setId(proximoId);

        this.produtos.add(novoProduto);
        return novoProduto;
    }

    /**
     * Método que atualiza um produto
     * Primeiro busca o produto que será atualizado pelo ID
     * Depois atribui as novas informações: nome, descrição e valor
     * Finalmente salva o produto atualziado
     * @param produtoId
     * @param novasInformacoesDoProduto
     */
    public void updateProduct(int produtoId, Produto novasInformacoesDoProduto) {
        Produto produtoProcurado = this.getProdutosById(produtoId);

        if (produtoProcurado != null) {
            produtoProcurado.setNome(novasInformacoesDoProduto.getNome());
            produtoProcurado.setDescricao(novasInformacoesDoProduto.getDescricao());
            produtoProcurado.setValorUnitario(novasInformacoesDoProduto.getValorUnitario());
        }
    }
}
