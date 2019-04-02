package io.mosip.mds.controller;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.xuggler.ICodec;
import com.xuggle.xuggler.IPixelFormat;
import com.xuggle.xuggler.IVideoPicture;
import com.xuggle.xuggler.video.ConverterFactory;
import com.xuggle.xuggler.video.IConverter;

@RestController
public class StreamController {
	// send the video stream to the client just copies the video no control of frames
	@GetMapping("/stream")
	public ResponseEntity<String> getVideoStream(HttpServletResponse response) throws MalformedURLException {
		// path to video file
		String fileName = "C:\\sartaj.mp4";
		File file = new File(fileName);
		InputStream fileStream = null;
		try {
			fileStream = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		UrlResource video = new UrlResource(file.toURI());
		try {
			IOUtils.copy(fileStream, response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaTypeFactory.getMediaType(video).get());
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	// incomplete
	@GetMapping("/webcam")
	public ResponseEntity<String> getWebcamStream(HttpServletResponse response) throws Throwable {
		File file = new File("output.ts");

		IMediaWriter writer = ToolFactory.makeWriter(file.getName());

		Dimension size = WebcamResolution.QVGA.getSize();

		writer.addVideoStream(0, 0, ICodec.ID.CODEC_ID_H264, size.width, size.height);

		Webcam webcam = Webcam.getDefault();
		webcam.setViewSize(size);
		webcam.open(true);

		long start = System.currentTimeMillis();

		for (int i = 0; i < 50; i++) {

			BufferedImage image = ConverterFactory.convertToType(webcam.getImage(), BufferedImage.TYPE_3BYTE_BGR);
			IConverter converter = ConverterFactory.createConverter(image, IPixelFormat.Type.YUV420P);

			IVideoPicture frame = converter.toPicture(image, (System.currentTimeMillis() - start) * 1000);
			frame.setKeyFrame(i == 0);
			frame.setQuality(0);

			writer.encodeVideo(0, frame);

			// 10 FPS
			Thread.sleep(100);
		}

		writer.close();
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
}
