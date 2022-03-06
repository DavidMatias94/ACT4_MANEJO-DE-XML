package beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Concierto")

public class Concierto {
	
	private String fecha;
	private String hora;
	private List <Participante> participante;
	
	
	
	
	public Concierto() {
		participante = new ArrayList<Participante>();
	}




	public String getFecha() {
		return fecha;
	}




	public void setFecha(String fecha) {
		this.fecha = fecha;
	}




	public String getHora() {
		return hora;
	}




	public void setHora(String hora) {
		this.hora = hora;
	}




	public List<Participante> getParticipante() {
		return participante;
	}




	public void setParticipante(List<Participante> participante) {
		this.participante = participante;
	}
	
	
	
	

}
