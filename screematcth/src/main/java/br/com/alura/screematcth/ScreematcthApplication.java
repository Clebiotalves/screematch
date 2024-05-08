package br.com.alura.screematcth;

import br.com.alura.screematcth.model.DadosEpisodio;
import br.com.alura.screematcth.model.DadosSerie;
import br.com.alura.screematcth.service.ConsumoApi;
import br.com.alura.screematcth.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreematcthApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ScreematcthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("http://www.omdbapi.com/?t=giLmore+girls&apikey=a632162b");
//		System.out.println(json);
//		json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
		json = consumoApi.obterDados("http://www.omdbapi.com/?t=giLmore+girls&season=1&episode=2&apikey=a632162b");
		DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println(dadosEpisodio);
	}
}
