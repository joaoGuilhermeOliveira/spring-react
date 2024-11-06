package io.github.joaoguilherme.imageliteapi.controller;

import io.github.joaoguilherme.imageliteapi.domain.entity.Image;
import io.github.joaoguilherme.imageliteapi.domain.mapper.ImageMapper;
import io.github.joaoguilherme.imageliteapi.domain.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/images")
@Slf4j
@RequiredArgsConstructor
public class ImagesController {

    private final ImageService imageService;

    private final ImageMapper imageMapper;
    @PostMapping
    public ResponseEntity save(@RequestParam("file") MultipartFile file, @RequestParam("name") String name, @RequestParam("tags")List<String> tags) throws IOException {
        log.info("Imagem recebida: name: {}, size: {}", file.getOriginalFilename(), file.getSize());

        Image image = imageMapper.mapToImage(file, name, tags);
        Image savedImage = imageService.save(image);

        URI imageUri = buildImageURL(savedImage);
        return ResponseEntity.created(imageUri).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") String id) {
        var possibleImage = imageService.getBydId(id);
        if (possibleImage.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var image = possibleImage.get();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(image.getExtension().getMediaType());
        headers.setContentLength(image.getSize());
        headers.setContentDispositionFormData("inline; filename=\""+ image.getFileName() + "\"", image.getFileName());

        return new ResponseEntity<>(image.getFile(), headers, HttpStatus.OK);
    }

    private URI buildImageURL(Image image) {
        String imagePath = "/" + image.getId();
        return ServletUriComponentsBuilder.fromCurrentRequest().path(imagePath).build().toUri();
    }
}
