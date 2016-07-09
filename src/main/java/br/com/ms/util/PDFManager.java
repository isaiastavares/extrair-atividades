package br.com.ms.util;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * Classe utilit&aacute;ria para trabalhar com PDF
 */
public class PDFManager {

	private PDFParser parser;
	private PDFTextStripper pdfStripper;
	private PDDocument pdDoc;
	private COSDocument cosDoc;

	private String text;
	private String filePath;
	private File file;

	/**
	 * Construtor padr&atilde;o
	 */
	public PDFManager() {
		super();
	}

	/**
	 * Converte o PDF em texto
	 * @return retorna o conte&uacute;do do PDF em String
	 * @throws IOException
	 */
	public String toText() throws IOException {
		this.pdfStripper = null;
		this.pdDoc = null;
		this.cosDoc = null;

		try {
			file = new File(filePath);
			parser = new PDFParser(new RandomAccessFile(file, "r"));

			parser.parse();
			cosDoc = parser.getDocument();
			pdfStripper = new PDFTextStripper();
			pdDoc = new PDDocument(cosDoc);
			pdDoc.getNumberOfPages();
			pdfStripper.setStartPage(1);
			pdfStripper.setEndPage(10);

			text = pdfStripper.getText(pdDoc);
			return text;
		} finally {
			if (pdDoc != null) {
				pdDoc.close();
			}
		}
	}

	/**
	 * Seta o caminho do PDF
	 * @param filePath caminho onde se encontra o PDF
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
