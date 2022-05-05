package br.edu.ifsp.lp3a5.exemplosStreams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CriandoStreamsComFiles {
	public static void main(String args[]) {
		streamsFiles();
	}

	private static void streamsFiles() {
		// Para listar arquivos em um diretório pode-se utilizar o Files.list
		System.out.println("\nCriando um stream com Files.list");
		try {
			Files.list(Paths.get("/tmp")).forEach(System.out::println);

			// Se o objetivo for listar o conteúdo dentro de arquivos texto use Files.lines
			System.out.println("\nCriando um stream com Files.lines");
			final String nmArq = "/tmp/testeStream";
			final List<String> linhas = Arrays.asList("Um título Bacana", "Um subtítulo para encher linguiça",
					"Um texto em latim para marcar o espaço", "Anímula, Vágula, Blândula!!!");
			Path file = Paths.get(nmArq);
			Files.write(file, linhas, StandardCharsets.UTF_8);

			Files.lines(file).forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
