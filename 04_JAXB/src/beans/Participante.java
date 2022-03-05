package beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="Participante")

@XmlType(propOrder = {
	    "entrada",
	    "grupo",    
	})

public class Participante {
	
	
	
	private String entrada;
	
	private String grupo;
	
	
	public Participante(String entrada, String grupo) {
		super();
		this.entrada = entrada;
		this.grupo = grupo;
	}


	public Participante() {
		super();
	}

	@XmlElement
	public String getEntrada() {
		return entrada;
	}


	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	@XmlElement
	public String getGrupo() {
		return grupo;
	}


	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}


	@Override
	public String toString() {
		return "Participante [entrada=" + entrada + ", grupo=" + grupo + "]";
	}
	
	
	
	
	
	

}
