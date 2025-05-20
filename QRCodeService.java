package com.rrb.QRCodeGenerator.service;

import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

@Service
public class QRCodeService {

	public byte[] generateQRCode(String text) throws Exception {
		
		MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
		BitMatrix bitmatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200);
		
		ByteArrayOutputStream byteArrayOutputstream = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitmatrix, "PNG", byteArrayOutputstream);
		
		return byteArrayOutputstream.toByteArray();
	}
	
}
