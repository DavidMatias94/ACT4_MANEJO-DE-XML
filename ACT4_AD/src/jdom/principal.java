package jdom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class principal {

	public static void main(String[] args) {
		
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder analizador;
		Document doc;
		
		try {
			analizador = fabrica.newDocumentBuilder();
			// Creamos nuevo documento vacio
			doc = analizador.newDocument();
			
			Element concierto = doc.createElement("concierto");
			doc.appendChild(concierto);
			
			agregarConcierto(concierto, doc);
			// Guardamos en disco el nuevo documento XML.
			guardar(doc);
			
			System.out.println("El archivo se ha creado con éxito");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void agregarConcierto(Element concierto, Document doc) {
		
		//creamos el elemento fecha y hora
		Element fecha = doc.createElement("fecha");
		concierto.appendChild(fecha);
		Text textoFecxha = doc.createTextNode("20-OCT-2018");
		fecha.appendChild(textoFecxha);
		
		Element hora = doc.createElement("hora");
		concierto.appendChild(hora);
		Text textoHora = doc.createTextNode("21:30");
		hora.appendChild(textoHora);
		
		//ahora vamos a añadir los participantes
		Element participantes = doc.createElement("participantes");
		concierto.appendChild(participantes);
		
		Element participante = doc.createElement("participante");
		participantes.appendChild(participante);
		
		Element entrada = doc.createElement("entrada");
		Text textoEntrada = doc.createTextNode("21:30");
		entrada.appendChild(textoEntrada);
		participante.appendChild(entrada);
		Element grupo = doc.createElement("grupo");
		participante.appendChild(grupo);
		Text textoGrupo = doc.createTextNode("Las ardillas de Dakota");
		grupo.appendChild(textoGrupo);
		
		
		//añadimos el segundo participante
		participante = doc.createElement("participante");
		participantes.appendChild(participante);
		
		entrada = doc.createElement("entrada");
		entrada.appendChild(doc.createTextNode("22:15"));
		participante.appendChild(entrada);
		grupo = doc.createElement("grupo");
		grupo.appendChild(doc.createTextNode("Fito y Fitipaldis"));
		participante.appendChild(grupo);
	
		//añadimos el tercer participante
		participante = doc.createElement("participante");
		participantes.appendChild(participante);
		
		entrada = doc.createElement("entrada");
		entrada.appendChild(doc.createTextNode("23:00"));
		participante.appendChild(entrada);
		grupo = doc.createElement("grupo");
		grupo.appendChild(doc.createTextNode("ColdPlay"));
		participante.appendChild(grupo);
		
		
		
		}
	
	private static void guardar(Document doc) throws TransformerException {
		
		TransformerFactory fabricaConversor = TransformerFactory.newInstance();
		
		Transformer conversor = fabricaConversor.newTransformer();
		
		DOMSource fuente = new DOMSource(doc); 
		
		StreamResult resultado = new StreamResult(new File("conciertos.xml"));
		
		conversor.transform(fuente, resultado);
	}

}
