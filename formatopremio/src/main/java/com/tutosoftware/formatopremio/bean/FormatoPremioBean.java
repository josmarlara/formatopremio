package com.tutosoftware.formatopremio.bean;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.tutosoftware.formatopremio.model.Equipo;
import com.tutosoftware.formatopremio.model.Logro;
import com.tutosoftware.formatopremio.model.Premio;



@ManagedBean
@SessionScoped
public class FormatoPremioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String modalidad;
	private String imagenDeportista;
	private UploadedFile file;
	private String urlImagenTemporal;
	private String deporte;
	private String especialidad;
	private String asociacion;
	private String propuesta;
	private String candidato;
	private String candidatoApellidoPaterno;
	private String candidatoApellidoMaterno;
	private Date fecha;
	private String lugarNacimiento;
	private String curp;
	private String email;
	private String telefono;
	private String celular;
	private String calle;
	private String numExt;
	private String numInt;
	private String colonia;
	private String codigoPostal;
	private String municipio;
	private String estado;
	private boolean visiblePanelIndividual=false;
	private boolean visiblePanelEquipo=false;
	private ArrayList<Equipo> equipos =new ArrayList<Equipo>();
	Equipo equipo = new Equipo();
	private ArrayList<Logro> logros= new ArrayList<Logro>();
	Logro logro = new Logro();
	private ArrayList<Premio> premios= new ArrayList<Premio>();
	Premio premio = new Premio();
	
	
	
	
public String getModalidad() {
		return modalidad;
	}



	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}



public String getImagenDeportista() {
		return imagenDeportista;
	}



	public void setImagenDeportista(String imagenDeportista) {
		this.imagenDeportista = imagenDeportista;
	}



public UploadedFile getFile() {
		return file;
	}



	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public String getUrlImagenTemporal() {
		return urlImagenTemporal;
	}



	public void setUrlImagenTemporal(String urlImagenTemporal) {
		this.urlImagenTemporal = urlImagenTemporal;
	}


	
	public void getEnablePropuesta() {
		
		
		if(propuesta.equals("individual")) {
			visiblePanelIndividual=true;
			visiblePanelEquipo=false;
			
		}
		
        if(propuesta.equals("equipo")) {
			
        	visiblePanelIndividual=false;
			visiblePanelEquipo=true;
		}
	}
	
	
	
	

	public void subirImagen(FileUploadEvent event) {
		byte[] bytes=event.getFile().getContents();
	
		imagenDeportista=event.getFile().getFileName();
		System.out.println("El archivo fue subido: "+imagenDeportista);
		urlImagenTemporal=guardarFicheroTemporal(bytes,imagenDeportista);
        
    }

public String getDeporte() {
		return deporte;
	}



	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}



public String getEspecialidad() {
		return especialidad;
	}



	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}



public String getAsociacion() {
		return asociacion;
	}



	public void setAsociacion(String asociacion) {
		this.asociacion = asociacion;
	}



public String getPropuesta() {
		return propuesta;
	}



	public void setPropuesta(String propuesta) {
		this.propuesta = propuesta;
	}



public String getCandidato() {
		return candidato;
	}



	public void setCandidato(String candidato) {
		this.candidato = candidato;
	}



public String getCandidatoApellidoPaterno() {
		return candidatoApellidoPaterno;
	}



	public void setCandidatoApellidoPaterno(String candidatoApellidoPaterno) {
		this.candidatoApellidoPaterno = candidatoApellidoPaterno;
	}



	public String getCandidatoApellidoMaterno() {
		return candidatoApellidoMaterno;
	}



	public void setCandidatoApellidoMaterno(String candidatoApellidoMaterno) {
		this.candidatoApellidoMaterno = candidatoApellidoMaterno;
	}



public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



public String getLugarNacimiento() {
		return lugarNacimiento;
	}



	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}



public String getCurp() {
		return curp;
	}



	public void setCurp(String curp) {
		this.curp = curp;
	}



public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



public String getCelular() {
		return celular;
	}



	public void setCelular(String celular) {
		this.celular = celular;
	}



public String getCalle() {
		return calle;
	}



	public void setCalle(String calle) {
		this.calle = calle;
	}



	public String getNumExt() {
		return numExt;
	}



	public void setNumExt(String numExt) {
		this.numExt = numExt;
	}



	public String getNumInt() {
		return numInt;
	}



	public void setNumInt(String numInt) {
		this.numInt = numInt;
	}



	public String getColonia() {
		return colonia;
	}



	public void setColonia(String colonia) {
		this.colonia = colonia;
	}



	public String getCodigoPostal() {
		return codigoPostal;
	}



	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}



	public String getMunicipio() {
		return municipio;
	}



	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}







public boolean isVisiblePanelIndividual() {
		return visiblePanelIndividual;
	}



	public void setVisiblePanelIndividual(boolean visiblePanelIndividual) {
		this.visiblePanelIndividual = visiblePanelIndividual;
	}



public boolean isVisiblePanelEquipo() {
		return visiblePanelEquipo;
	}



	public void setVisiblePanelEquipo(boolean visiblePanelEquipo) {
		this.visiblePanelEquipo = visiblePanelEquipo;
	}



public ArrayList<Equipo> getEquipos() {
		return equipos;
	}



	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}



public Equipo getEquipo() {
	return equipo;
}



public void setEquipo(Equipo equipo) {
	this.equipo = equipo;
}



public ArrayList<Logro> getLogros() {
	return logros;
}



public void setLogros(ArrayList<Logro> logros) {
	this.logros = logros;
}



public Logro getLogro() {
	return logro;
}



public void setLogro(Logro logro) {
	this.logro = logro;
}



public ArrayList<Premio> getPremios() {
	return premios;
}



public void setPremios(ArrayList<Premio> premios) {
	this.premios = premios;
}



public Premio getPremio() {
	return premio;
}



public void setPremio(Premio premio) {
	this.premio = premio;
}



public void imprimir() {
		
		Document document = new Document(PageSize.LETTER);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			
			
			
			
			
			PdfWriter writer= PdfWriter.getInstance(document, baos);
			document.open();
			Image imagen = Image.getInstance(getClass().getResource("/com/tutosoftware/formatopremio/image/premio.png"));
			imagen.setAbsolutePosition(0f,700f);
			document.add(imagen);
			Image imagen2 = Image.getInstance(getClass().getResource("/com/tutosoftware/formatopremio/image/premio1.png"));
			imagen2.setAbsolutePosition(450f,700f);
			document.add(imagen2);
			Font font1 = new Font();
			font1.setSize(12);
			font1.setStyle(Font.BOLD);
			Font font2 = new Font();
			font2.setSize(10);
			Font font3 = new Font();
			font3.setSize(12);
			font3.setColor(BaseColor.WHITE);
			font3.setStyle(Font.BOLD);
			document.add(new Paragraph("                                                      PREMIO ESTATAL DEL DEPORTE 2020 \n",font1));
			document.add(new Paragraph("                                                                      CONSEJO DE PREMIACIÓN \n",font2));
			document.add(new Paragraph("                                                        FORMATO DE PREMIACIÓN \n",font1));
			document.add(new Paragraph("\n",font1));
			//document.add(new Paragraph("                                                      PROPUESTA EN LA MODALIDAD \n",font3));
			PdfPTable table = new PdfPTable(1);
			table.setWidthPercentage(100.0f);
			PdfPCell cell = new PdfPCell();
			cell.setBackgroundColor(BaseColor.BLACK);
			cell.setPhrase(new Phrase("                                                      PROPUESTA EN LA MODALIDAD \n", font3));
			table.addCell(cell);
			document.add(table);
			document.add(new Paragraph("MODALIDAD: "+modalidad,font2));
			document.add(new Paragraph("Deporte: "+deporte+"                                            Especialidad: "+especialidad,font2));
			document.add(new Paragraph("Propuesta elaborada por: "+asociacion,font2));
			document.add(new Paragraph("\n\n\n\n",font2));
			
			PdfContentByte cb = writer.getDirectContent();
			cb.saveState(); 
			cb.setColorStroke(BaseColor.BLACK); 
			cb.moveTo(79,640);
			cb.lineTo(220,640);
			cb.moveTo(312,640);
			cb.lineTo(440,640);
			cb.moveTo(156,625);
			cb.lineTo(460,625);
			cb.stroke(); 
			cb.restoreState();
			Image imagen3 = Image.getInstance(urlImagenTemporal);
			imagen3.scaleToFit(100,100);
			imagen3.setAbsolutePosition(470f,580f);
			document.add(imagen3);
			
			if(propuesta.equals("individual")) {
				
				PdfPTable table1 = new PdfPTable(1);
				table1.setWidthPercentage(100.0f);
				PdfPCell cell1 = new PdfPCell();
				cell1.setBackgroundColor(BaseColor.BLACK);
				cell1.setPhrase(new Phrase("                                                      DATOS DE CANDIDATO (PROPUESTA INDIVIDUAL) \n", font3));
				table1.addCell(cell1);
				document.add(table1);
				document.add(new Paragraph("Nombre del candidato: "+candidatoApellidoPaterno+" "+candidatoApellidoMaterno+" "+candidato,font2));
				String mes = mostrarFecha(fecha);
				document.add(new Paragraph("Fecha de nacimiento: "+mes+"         Lugar de nacimiento: "+lugarNacimiento,font2));
				document.add(new Paragraph("C.U.R.P. "+curp+"             Correo electrónico: "+email,font2));
				document.add(new Paragraph("Teléfono: "+telefono+"             No. celular: "+celular,font2));
				document.add(new Paragraph("Domicilio: "+calle+" "+numExt+" "+numInt+" "+colonia+" "+codigoPostal,font2));
				document.add(new Paragraph("            "+municipio+" "+estado,font2));
				document.add(new Paragraph("\n\n",font2));	
				
				PdfContentByte cb1 = writer.getDirectContent();
				cb1.saveState(); 
				
				cb1.moveTo(142,530);
				cb1.lineTo(560,530);
				cb1.moveTo(138,515);
				cb1.lineTo(245,515);
				cb1.moveTo(360,515);
				cb1.lineTo(560,515);
				cb1.moveTo(79,500);
				cb1.lineTo(220,500);
				cb1.moveTo(312,500);
				cb1.lineTo(560,500);
				cb1.moveTo(79,485);
				cb1.lineTo(160,485);
				cb1.moveTo(230,485);
				cb1.lineTo(500,485);
				cb1.moveTo(79,470);
				cb1.lineTo(530,470);
				cb1.moveTo(79,455);
				cb1.lineTo(530,455);
				cb1.stroke(); 
				cb1.restoreState();
				
			}
			
			if(propuesta.equals("equipo")) {
				
				PdfPTable table2 = new PdfPTable(1);
				table2.setWidthPercentage(100.0f);
				PdfPCell cell2 = new PdfPCell();
				cell2.setBackgroundColor(BaseColor.BLACK);
				cell2.setPhrase(new Phrase("   PROPUESTA POR EQUIPO O DEPORTES DE CONJUNTO (INTEGRANTES DEL EQUIPO) \n", font3));
				table2.addCell(cell2);
				document.add(table2);
				
				
				
				PdfPTable table3 = new PdfPTable(4);
				table3.setWidthPercentage(100.0f);
				table3.setWidths(new float[] {1.0f,4.0f,2.0f,2.0f});
				table3.setSpacingBefore(10);
				PdfPCell cell3 = new PdfPCell();
				cell3.setPhrase(new Phrase(" ", font2));
				table3.addCell(cell3);
				cell3.setPhrase(new Phrase("    Nombre de los Integrantes del Equipo", font2));
				table3.addCell(cell3);
				cell3.setPhrase(new Phrase(" Fecha de Nacimiento ", font2));
				table3.addCell(cell3);
				cell3.setPhrase(new Phrase(" Teléfono ", font2));
				table3.addCell(cell3);
			
				int i=0;
				for(Equipo e:equipos) {
					
					++i;
					table3.addCell(new Phrase(" "+i, font2));
					table3.addCell(new Phrase(e.getApellidoPaterno()+" "+e.getApellidoMaterno()+" "+e.getNombre(), font2));
					table3.addCell(new Phrase(mostrarFecha(e.getFechaNacimiento()), font2));
					table3.addCell(new Phrase(e.getTelefono(), font2));
					
				}
				
			
				
				
				
				document.add(table3);
				
				
				
				
				
			}
			
			
			PdfPTable table4 = new PdfPTable(1);
			table4.setWidthPercentage(100.0f);
			PdfPCell cell4 = new PdfPCell();
			cell4.setBackgroundColor(BaseColor.BLACK);
			cell4.setPhrase(new Phrase(" LOGROS QUE ACREDITEN EL MERECIMIENTO DEL PREMIO ESTATAL DEL DEPORTE 2020 \n", font3));
			table4.addCell(cell4);
			document.add(table4);
			
			PdfPTable table5 = new PdfPTable(4);
			table5.setWidthPercentage(100.0f);
			table5.setWidths(new float[] {3.0f,3.0f,1.0f,3.0f});
			table5.setSpacingBefore(10);
			PdfPCell cell5 = new PdfPCell();
			PdfPCell cell6 = new PdfPCell();
			cell6.setBackgroundColor(BaseColor.BLACK);
			cell6.setPhrase(new Phrase("RESULTADOS DEPORTIVOS", font3));
			cell6.setColspan(4);
			table5.addCell(cell6);
			cell5.setPhrase(new Phrase("Evento", font2));
			table5.addCell(cell5);
			cell5.setPhrase(new Phrase("Sede y fecha", font2));
			table5.addCell(cell5);
			cell5.setPhrase(new Phrase("Lugar obtenido", font2));
			table5.addCell(cell5);
			cell5.setPhrase(new Phrase("Comentario del lugar obtenido ", font2));
			table5.addCell(cell5);
		
			
			for(Logro l:logros) {
				table5.addCell(new Phrase(l.getEvento(), font2));
				table5.addCell(new Phrase(l.getSede(), font2));
				table5.addCell(new Phrase(l.getLugar(), font2));
				table5.addCell(new Phrase(l.getComentario(), font2));
			}
			
			
			document.add(table5);
			
			
			
			PdfPTable table6 = new PdfPTable(1);
			table6.setWidthPercentage(100.0f);
			PdfPCell cell7 = new PdfPCell();
			cell7.setBackgroundColor(BaseColor.BLACK);
			cell7.setPhrase(new Phrase("RECONOCIMIENTOS Y PREMIOS \n", font3));
			table6.addCell(cell7);
			document.add(table6);
			
			PdfPTable table7 = new PdfPTable(3);
			table7.setWidthPercentage(100.0f);
			table7.setWidths(new float[] {1.0f,3.0f,3.0f});
			table7.setSpacingBefore(10);
			PdfPCell cell8 = new PdfPCell();
			
			cell8.setPhrase(new Phrase("Año", font2));
			table7.addCell(cell8);
			cell8.setPhrase(new Phrase("Descripción del reconocimiento o premio", font2));
			table7.addCell(cell8);
			cell8.setPhrase(new Phrase("Otorgado por", font2));
			table7.addCell(cell8);
			
		
			
			for(Premio p:premios) {
				table7.addCell(new Phrase(p.getYear(), font2));
				table7.addCell(new Phrase(p.getDescripcion(), font2));
				table7.addCell(new Phrase(p.getOtorgado(), font2));
				
			}
			
			
			document.add(table7);
			
			
		}catch (Exception ex) {
            System.out.println("Error " + ex);
        }
		
		document.close();
		FacesContext context = FacesContext.getCurrentInstance();
		Object response = context.getExternalContext().getResponse();
		if (response instanceof HttpServletResponse) {
            HttpServletResponse hsr = (HttpServletResponse) response;
            hsr.setContentType("application/pdf");
            hsr.setHeader("Content-disposition", "attachment;filename=/formato.pdf");
            hsr.setContentLength(baos.size());
            try {
                  ServletOutputStream out = hsr.getOutputStream();
                  baos.writeTo(out);
                  out.flush();
            } catch (IOException ex) {
                  System.out.println("Error:  " + ex.getMessage());
            }
            context.responseComplete();
      }
		
		
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		String path = servletContext.getRealPath("/img/tmp");
		
		 File file = new File(path); 
	     File[] files = file.listFiles(); 
	     for (File f:files) 
	     {
	    	 if (f.isFile() && f.exists()) 
	           { 
	    	 f.delete(); 
	         System.out.println("successfully deleted"); 
	         }else{ 
	         System.out.println("cant delete a file due to open or error"); 
	         } 
	     }
		
				
	}


public void agregarIntegrante() {
	
	Equipo equip=new Equipo();
	
	equip.setNombre(equipo.getNombre());
	equip.setApellidoPaterno(equipo.getApellidoPaterno());
	equip.setApellidoMaterno(equipo.getApellidoMaterno());
	equip.setFechaNacimiento(equipo.getFechaNacimiento());
	equip.setTelefono(equipo.getTelefono());
	equipos.add(equip);
	
	equipo.setNombre("");;
	equipo.setApellidoPaterno("");
	equipo.setApellidoMaterno("");
	equipo.setFechaNacimiento(null);
	equipo.setTelefono("");
}


public void agregarLogro() {
	Logro lo = new Logro();
	lo.setEvento(logro.getEvento());
	lo.setSede(logro.getSede());
	lo.setLugar(logro.getLugar());
	lo.setComentario(logro.getComentario());
	
	logros.add(lo);
	
	logro.setEvento("");
	logro.setSede("");
	logro.setLugar("");
	logro.setComentario("");
	
	
	
	
}

public void agregarPremio() {
	Premio pr = new Premio();
	pr.setYear(premio.getYear());
	pr.setDescripcion(premio.getDescripcion());
	pr.setOtorgado(premio.getOtorgado());
	
	premios.add(pr);
	
	
	premio.setYear("");
	premio.setDescripcion("");
	premio.setOtorgado("");
	
	
	
}





public void limpiarFormulario() {
	
	ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
	String path = servletContext.getRealPath("/img/tmp");
	
	 File file = new File(path); 
     File[] files = file.listFiles(); 
     for (File f:files) 
     {
    	 if (f.isFile() && f.exists()) 
           { 
    	 f.delete(); 
         System.out.println("successfully deleted"); 
         }else{ 
         System.out.println("cant delete a file due to open or error"); 
         } 
     }
     
     modalidad="";
     deporte="";
     especialidad="";
     asociacion="";
     propuesta="";
     candidato="";
 	 candidatoApellidoPaterno="";
     candidatoApellidoMaterno="";
 	 fecha=null;
 	 lugarNacimiento="";
 	 curp="";
 	 email="";
 	 telefono="";
 	 celular="";
 	 calle="";
 	 numExt="";
 	 numInt="";
 	 colonia="";
     codigoPostal="";
     municipio="";
 	 estado="";
     equipos.clear();
     logros.clear();
     premios.clear();
     visiblePanelIndividual=false;
 	 visiblePanelEquipo=false;
	
}







	
	public static String guardarFicheroTemporal(byte[] bytes,String nombreArchivo) {
		String ubicacionImagen=null;
		
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		String path = servletContext.getRealPath("/img/tmp/"+nombreArchivo);
		System.out.println("El path es: "+path);
	    File f = null;
	    InputStream in = null;
	    
	    try {
	    	f = new File(path);
	    	in = new ByteArrayInputStream(bytes);
	    	System.out.println();
	    	FileOutputStream out = new FileOutputStream(f.getAbsolutePath());
	    	int c=0;
	    	while((c=in.read())>=0) {
	    		out.write(c);
	    	}
	    	out.flush();
	    	out.close();
	    	ubicacionImagen=path;
	    	
	    }catch(Exception e) {
	    	System.err.println("No se pudo cargar la imagen: "+e);
	    }
	    System.out.println("La imagen es: "+ubicacionImagen);
		return ubicacionImagen;
	}
	
	public static String mostrarFecha(Date fecha) {
		Calendar cal= Calendar.getInstance();
		cal.setTime(fecha);
		int dia=cal.get(Calendar.DAY_OF_MONTH);
		int mes=cal.get(Calendar.MONTH)+1;
		int year=cal.get(Calendar.YEAR);
		
		String mesString;
		
		switch (mes) {
        case 1:  mesString = "Enero";
                 break;
        case 2:  mesString  = "Febrero";
                 break;
        case 3:  mesString = "Marzo";
                 break;
        case 4:  mesString = "Abril";
                 break;
        case 5:  mesString = "Mayo";
                 break;
        case 6:  mesString = "Junio";
                 break;
        case 7:  mesString = "Julio";
                 break;
        case 8:  mesString = "Agosto";
                 break;
        case 9:  mesString = "Septiembre";
                 break;
        case 10: mesString = "Octubre";
                 break;
        case 11: mesString = "Noviembre";
                 break;
        case 12: mesString = "Diciembre";
                 break;
        default: mesString = "Invalid month";
                 break;
                 
                 
        }
		
		String fechaNacimiento=""+dia+" de "+mesString+" "+year;
		
		return fechaNacimiento;
	}

}
