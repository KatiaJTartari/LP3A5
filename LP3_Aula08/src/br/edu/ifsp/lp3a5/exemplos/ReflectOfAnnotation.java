package br.edu.ifsp.lp3a5.exemplos;

import java.lang.reflect.Field;

public class ReflectOfAnnotation {
	@Deprecated
	public static int value = 1;

	public static void main(String[] args) throws Exception {

		Field field = ReflectOfAnnotation.class.getField("value");
		if (field.isAnnotationPresent(Deprecated.class)) {
			System.out.println("Campo anotado com Deprecated");
		} else {
			System.out.println("Campo não anotado com Deprecated");
		}
	}
}
