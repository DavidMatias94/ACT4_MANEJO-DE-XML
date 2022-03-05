package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import beans.Participante;

public class XMLToObject {

	public static void main(String[] args) {
		
		
		try {
			JAXBContext contexto = JAXBContext.newInstance(Participante.class);
			//Esta vez creamos un objeto que nos permite pasar
			//de XML a Object, es decir deserializar
			Unmarshaller u = contexto.createUnmarshaller();
			File fichero = new File("participante.xml");
			if (fichero.exists()) {
				Participante p = (Participante) u.unmarshal(fichero);
				System.out.println(p.getEntrada());
				System.out.println(p.getGrupo());
				System.out.println(p);
			} else {
				System.out.println("Fichero XML Participante.xml no encontrado");
			}

		} catch (JAXBException e) {
			System.out.println(e.getMessage());
		}

	}

}
