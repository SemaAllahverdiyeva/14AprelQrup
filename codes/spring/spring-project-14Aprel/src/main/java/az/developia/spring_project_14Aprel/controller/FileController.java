package az.developia.spring_project_14Aprel.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/files")
public class FileController {
	@Value(value = "${file.file-dir}")
	private String fileDir;

	@PostMapping("/upload")
	public ResponseEntity<String> upload(@RequestParam MultipartFile file) throws IOException {
		Path folder = Paths.get(fileDir);
		Files.createDirectories(folder);

		String originalFileName = file.getOriginalFilename();

		String extension = "";
		if (originalFileName != null && originalFileName.contains(".")) {
			extension = originalFileName.substring(originalFileName.lastIndexOf("."));
		}

		String randomFileName = UUID.randomUUID() + extension;

		Files.copy(file.getInputStream(), folder.resolve(randomFileName), StandardCopyOption.REPLACE_EXISTING);

		return ResponseEntity.ok("File upload successfully. File name: " + randomFileName);
	}

	@GetMapping("/download/{fileName}")
	public ResponseEntity<Resource> download(@PathVariable String fileName) throws IOException {

		Path filePath = Paths.get(fileDir).resolve(fileName);

		Resource resource = new UrlResource(filePath.toUri());

		if (!resource.exists() || !resource.isReadable()) {
			return ResponseEntity.notFound().build();
		}

		String contentType = Files.probeContentType(filePath);

		if (contentType == null) {
			contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
}
