/**
 * 
 */
package com.olam.example.pdftemplate.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.olam.example.pdftemplate.PdfGeneratorUtil;

/**
 * @author mahesh.srinivas
 *
 */
@RestController
public class PdfController {
	
	@Autowired
	PdfGeneratorUtil pdfGeneratorUtil;

	 @RequestMapping(value = "/generatePdf", method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<byte[]> citiesReport() throws Exception {

		 Map<String,String> data = new HashMap<String,String>();
	        data.put("name","mAHESH");
	        ByteArrayOutputStream bis =   pdfGeneratorUtil.createPdf("greetings",data); 

	      

	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "inline; filename=greetings.pdf");

	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(bis.toByteArray());
	    }

}
