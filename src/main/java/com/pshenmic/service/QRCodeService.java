package com.pshenmic.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

@Service
public class QRCodeService {


    @Value(value = "blm.hostname")
    private String hostname;


    private final Logger log = LoggerFactory.getLogger(QRCodeService.class);

    /**
     * @param text {String} text to encode
     * @return {String} qr-code for input string encoded in base64
     */

    public String generateCode(String text) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();

            BitMatrix result = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200);
            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(result);

            // Create a byte array output stream.
            ByteArrayOutputStream bao = new ByteArrayOutputStream();

            // Write to output stream
            ImageIO.write(bufferedImage, "jpg", bao);

            byte[] bytes = bao.toByteArray();
            return Base64.getEncoder().encodeToString(bytes);
        } catch (IOException | WriterException e) {
            log.error("Error while generating qrCodeService for string: {}", text, e);
            return null;
        }
    }


    /**
     * Gets blm.hostname property and constructs full url, then encode it in base64
     *
     * @param productId {Long}
     * @return {String}
     */

    public String generateCodeFromProductId(Long productId) {
        return generateCode(hostname + "/product/" + productId);
    }


}
