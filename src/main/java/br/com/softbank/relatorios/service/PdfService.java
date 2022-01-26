package br.com.softbank.relatorios.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.softbank.relatorios.dto.ClubesDTO;

@Service
public class PdfService {
	
	private static final String LOGO = "https://upload.wikimedia.org/wikipedia/commons/2/26/Escudo_CBF.png";

	
	@Autowired
	private ClubesService clubesService;
	
	public void gerarRelatorio(HttpServletResponse response) throws Exception {	
		String nomeArquivo = "Lista de Clubes Brasileirão 2022.pdf";
		
		Document document = new Document();

		Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		
		Image image = Image.getInstance(LOGO);
		image.setAlignment(2);
		image.scaleToFit(100, 50);
		document.add(image);
		
		Paragraph paragraph = new Paragraph("Clubes", headFont);
		paragraph.setAlignment(1);
		document.add(paragraph);
		document.add(new Paragraph(" "));
		
		PdfPTable table = new PdfPTable(3);
		table.setWidthPercentage(80);
		
		PdfPCell tituloNome = new PdfPCell(new Phrase("Nome", headFont));
		tituloNome.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(tituloNome);
		
		PdfPCell tituloEstado = new PdfPCell(new Phrase("Estado", headFont));
		tituloEstado.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(tituloEstado);
		
		PdfPCell tituloEstadio = new PdfPCell(new Phrase("Estádio", headFont));
		tituloEstadio.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(tituloEstadio);
		
		for(ClubesDTO clube: clubesService.findAll()) {
			PdfPCell valorNome = new PdfPCell(new Phrase(0, clube.getNome()));
			valorNome.setVerticalAlignment(Element.ALIGN_MIDDLE);
			valorNome.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(valorNome);
			
			PdfPCell valorEstado = new PdfPCell(new Phrase(1, clube.getEstado()));
			valorEstado.setVerticalAlignment(Element.ALIGN_MIDDLE);
			valorEstado.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(valorEstado);
			
			PdfPCell valorEstadio = new PdfPCell(new Phrase(2, clube.getEstadio()));
			valorEstadio.setVerticalAlignment(Element.ALIGN_MIDDLE);
			valorEstadio.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(valorEstadio);
		}
		
		
		response.setHeader("content-disposition", "attachment; filename=" + nomeArquivo);
		response.setContentType("application/pdf");

		document.add(table);
		document.close();

		response.flushBuffer();
		response.getOutputStream().flush();
		response.getOutputStream().close();
		
	}

}
