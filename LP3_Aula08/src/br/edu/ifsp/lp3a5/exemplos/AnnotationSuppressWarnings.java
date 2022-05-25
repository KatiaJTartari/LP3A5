package br.edu.ifsp.lp3a5.exemplos;

import java.util.ArrayList;
import java.util.List;

public class AnnotationSuppressWarnings {

	@SuppressWarnings(value = { "unchecked", "rawtypes" })

	public static void main(String[] args) {
		List lista = new ArrayList();
		lista.add("dado");
	}

}
