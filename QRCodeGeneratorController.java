package com.rrb.QRCodeGenerator.controller;

import java.net.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rrb.QRCodeGenerator.service.QRCodeService;

@RestController
public class QRCodeGeneratorController {
	
	@Autowired
	QRCodeService qrCodeService;
	
	@GetMapping("/")
	public String homme() {
		return"Welome to QR Code Generator";
	}
	
	@GetMapping("/generateQRcode")
	public ResponseEntity<?>generateQRCodeByText(@RequestParam("text") String text){
		
		try {
			byte[] qrCodeImage = qrCodeService.generateQRCode(text);
			
			return ResponseEntity.ok()
					.header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION,"inline; filename=QRCode.png")
					.contentType(MediaType.IMAGE_PNG)
					.body(qrCodeImage);
		}
		catch(Exception e) {
			return ResponseEntity.status(500).body(e.getMessage()); 
		}
		
	}
}
