package br.com.alura.screematcth.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio(@JsonAlias("Title") String titulo,
                            @JsonAlias("Episode")Integer numero,
                            @JsonAlias("imdbRating") String avaliacacao,
                            @JsonAlias("Released") String dataLancamento) {
}
