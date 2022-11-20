package com.simplilearn.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadDownloadController {

	class SUCCESS {
		String message;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SUCCESS fileUpload(@RequestParam("file") MultipartFile file) throws IOException {

		// Write code to read and write file at some location
		File newFile = new File("C:\\temp\\" + file.getOriginalFilename());
		if (!newFile.exists()) {
			newFile.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(newFile);
		fos.write(file.getBytes());
		fos.close();

		SUCCESS s = new SUCCESS();
		s.setMessage("File uploaded successfully");
		// Return response
		return s;
	}
	
	@RequestMapping(value="/download", method=RequestMethod.GET)
	public ResponseEntity<Object> downloadFile(@RequestParam("fileName") String fileName) throws FileNotFoundException {
		// Read file
		File file = new File("C:\\temp\\"+fileName);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		
		// Populate header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=Downloaded-"+fileName);
		
		return ResponseEntity.ok().headers(headers).contentType(MediaType.parseMediaType("application/txt")).body(resource);
	}
}