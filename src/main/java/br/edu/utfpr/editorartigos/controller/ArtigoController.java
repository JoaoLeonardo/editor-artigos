package br.edu.utfpr.editorartigos.controller;

import br.edu.utfpr.editorartigos.model.Artigo;
import br.edu.utfpr.editorartigos.service.ArtigoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("artigo/")
@RequiredArgsConstructor
public class ArtigoController {
    private final ArtigoService artigoService;

    @PostMapping("incluir")
    public Artigo incluir(@RequestBody Artigo artigo) throws Exception {
        if (artigo != null) {
            artigo.setVisualizacoes(0L);
        }
        return artigoService.cadastrarArtigo(artigo);
    }

    @PutMapping("atualizar")
    public Artigo alterar(@RequestBody Artigo artigo) throws Exception {
        return artigoService.cadastrarArtigo(artigo);
    }

    @DeleteMapping("{id}")
    public void excluir(@PathVariable("id") Long id) {
        artigoService.deletarArtigo(id);
    }


    @GetMapping("pesquisar-todos")
    public List<Artigo> pesquisarTodos() {
        return artigoService.listarTodos();
    }

    @GetMapping("{id}")
    public Artigo findOne(@PathVariable("id") Long id) {
        return artigoService.findById(id);
    }

    @GetMapping("artigos-usuario")
    public Set<Artigo> artigosPorUsuario() {
        return artigoService.artigosPorUsuario();
    }

    @GetMapping("destaque")
    public Set<Artigo> artigosPorDestaque() {
        return artigoService.artigosMaisVistos();
    }

    @GetMapping("recomendacao")
    public Set<Artigo> artigosRecomendacao() {
        return artigoService.recomendacaoPorUsuario();
    }

    @GetMapping("filtro/titulo-chave")
    public List<Artigo> artigosFiltro(@Param("filtro") String filtro) {
        return artigoService.findArtigoByTituloOrPalavrasChave(filtro);

    }
}
