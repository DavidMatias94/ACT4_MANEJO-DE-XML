package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import beans.Concierto;
import beans.Participante;

public class ObjectToXML {

	public static void main(String[] args) {
		
		
		JAXBContext contexto;
		try {
			
			contexto = JAXBContext.newInstance(Participante.class);//inyeccion de dependecia
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}

		Marshaller m;
		try {
			/*
			 
			 * Con este objeto podremos convertir un objeto en xml
			 * lo serializaremos
			 */
			m = contexto.createMarshaller();
			
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			//creamos el participante y el concierto
			Participante p = new Participante( "22:30", "1");
			Concierto concierto = new Concierto();
			concierto.setFecha("28-02-23");
			concierto.setHora("22:00");
			p.setEntrada("22:30");
			p.setGrupo("Green Day");
			
			
			//Convertimos un objeto a xml y lo imprimimos por pantalla
			m.marshal(p, System.out);
			
			m.marshal(p, new File("partricipante.xml"));
		} catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
