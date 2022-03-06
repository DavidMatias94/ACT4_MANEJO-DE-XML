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
			/*
			 * Obtiene el contexto asociado a la clase Persona, con dicho
			 * contexto podremos convertir el objeto a un xml y a la inversa. 
			 * Provoca una excepción de tipo JAXBException si la clase Persona 
			 * no cumple los requisitos para la conversión a XML, es decir, 
			 * contener las anotaciones necesarias y no cuenta con un constructor 
			 * sin argumentos.
			 */
			contexto = JAXBContext.newInstance(Concierto.class);//inyeccion de dependecia
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}

		Marshaller m;
		try {
			/*
			 * Obtiene el objeto Marshaller asociado al contexto.
			 * Con dicho objeto podremos convertir un objeto en xml
			 * es decir, lo serializaremos
			 */
			m = contexto.createMarshaller();
			/*
			 * stablecer la propiedad JAXB_FORMATTED_OUTPUT con el valor true 
			 * permite que en la conversión a formato XML se incluyan retornos 
			 * de carro e indentación (sangrado del texto). 
			 * Prueba a ejecutar el programa con los valores true y 
			 * false para ver la diferencia.
			 */
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			

			Concierto concierto = new Concierto();
			concierto.setFecha("22-OCT-2022");
			concierto.setHora("22:00");	
			concierto.getParticipante().add(new Participante("22:30","Green Day"));
			concierto.getParticipante().add(new Participante("23:15","The Offspring"));
			concierto.getParticipante().add(new Participante("00:00","Simple Plan"));
			concierto.getParticipante().add(new Participante("00:45","Coldplay"));
			concierto.getParticipante().add(new Participante("01:15","U2"));
			
			//Convertimos un objeto a xml y lo imprimimos por pantalla
			m.marshal(concierto, System.out);
			//tambien podemos crear un fichero
			m.marshal(concierto, new File("conciertos.xml"));
			System.out.println("Se ha creado con éxito el fichero");
		} catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
