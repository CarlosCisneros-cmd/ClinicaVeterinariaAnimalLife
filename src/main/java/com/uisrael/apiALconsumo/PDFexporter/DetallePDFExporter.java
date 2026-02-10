package com.uisrael.apiALconsumo.PDFexporter;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.uisrael.apiALconsumo.modelo.dto.response.CabeceraResponseDto;
import com.uisrael.apiALconsumo.modelo.dto.response.DetallesResponseDto;

import jakarta.servlet.http.HttpServletResponse;

public class DetallePDFExporter {

    private List<DetallesResponseDto> listaDetalles;
    private CabeceraResponseDto cabecera;

    public DetallePDFExporter(List<DetallesResponseDto> listaDetalles, CabeceraResponseDto cabecera) {
        this.listaDetalles = listaDetalles;
        this.cabecera = cabecera;
    }

    private void escribirCabeceraTabla(PdfPTable tabla) {
        PdfPCell celda = new PdfPCell();
        celda.setBackgroundColor(new Color(0, 102, 204));
        celda.setPadding(5);

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fuente.setColor(Color.WHITE);

        String[] columnas = {"Fecha", "Peso", "Temp.", "Descripción", "Diagnóstico", "Análisis"};
        
        for (String titulo : columnas) {
            celda.setPhrase(new Phrase(titulo, fuente));
            tabla.addCell(celda);
        }
    }

    private void escribirDatosTabla(PdfPTable tabla) {
        Font fuenteCelda = FontFactory.getFont(FontFactory.HELVETICA, 10);
        
        for (DetallesResponseDto detalle : listaDetalles) {

            tabla.addCell(new Phrase(String.valueOf(detalle.getFechaCreacion()), fuenteCelda));
            tabla.addCell(new Phrase(detalle.getPeso() + " kg", fuenteCelda));
            tabla.addCell(new Phrase(detalle.getTemperatura() + " °C", fuenteCelda));
            tabla.addCell(new Phrase(detalle.getDescripcion(), fuenteCelda));
            tabla.addCell(new Phrase(detalle.getDiagnostico(), fuenteCelda));
            tabla.addCell(new Phrase(detalle.getAnalisis(), fuenteCelda));
        }
    }

    public void exportar(HttpServletResponse response) throws DocumentException, IOException {
        Document documento = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(documento, response.getOutputStream());

        documento.open();

        // 1. Título Principal
        Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);
        fuenteTitulo.setColor(new Color(0, 102, 204));
        Paragraph titulo = new Paragraph("HISTORIAL CLÍNICO VETERINARIO", fuenteTitulo);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        titulo.setSpacingAfter(20);
        documento.add(titulo);

        // 2. Información de la Mascota y Dueño (Ficha Técnica)
        PdfPTable tablaInfo = new PdfPTable(2);
        tablaInfo.setWidthPercentage(100);
        tablaInfo.setSpacingAfter(20);
        tablaInfo.getDefaultCell().setBorder(Rectangle.NO_BORDER);

        Font fuenteEtiqueta = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
        
        // Columna Izquierda: Mascota
        PdfPCell columna1 = new PdfPCell();
        columna1.setBorder(Rectangle.NO_BORDER);
        columna1.addElement(new Phrase("PACIENTE: " + cabecera.getFkPaciente().getNombre(), fuenteEtiqueta));
        columna1.addElement(new Phrase("ESPECIE: " + cabecera.getFkPaciente().getEspecie()));
        columna1.addElement(new Phrase("RAZA: " + cabecera.getFkPaciente().getRaza()));
        columna1.addElement(new Phrase("COLOR: " + cabecera.getFkPaciente().getColor()));
        tablaInfo.addCell(columna1);

        // Columna Derecha: Dueño
        PdfPCell columna2 = new PdfPCell();
        columna2.setBorder(Rectangle.NO_BORDER);
        columna2.addElement(new Phrase("PROPIETARIO: " + cabecera.getNombreCliente(), fuenteEtiqueta));
        columna2.addElement(new Phrase("FECHA NAC. MASCOTA: " + cabecera.getFkPaciente().getFechaNacimiento()));
        tablaInfo.addCell(columna2);

        documento.add(tablaInfo);

        // 3. Tabla de Detalles Médicos
        PdfPTable tablaDetalles = new PdfPTable(6);
        tablaDetalles.setWidthPercentage(100);
        tablaDetalles.setWidths(new float[] {1.5f, 1f, 1f, 3f, 3f, 3f});

        escribirCabeceraTabla(tablaDetalles);
        escribirDatosTabla(tablaDetalles);

        documento.add(tablaDetalles);
        
        // Pie de página simple
        Paragraph pie = new Paragraph("\nDocumento generado por Sistema Clínica Veterinaria Animal Life", 
                FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 8));
        pie.setAlignment(Paragraph.ALIGN_RIGHT);
        documento.add(pie);

        documento.close();
    }
}