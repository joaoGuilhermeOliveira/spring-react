package io.github.joaoguilherme.imageliteapi.domain.mapper;

import io.github.joaoguilherme.imageliteapi.domain.dto.ImageDto;
import io.github.joaoguilherme.imageliteapi.domain.entity.Image;
import io.github.joaoguilherme.imageliteapi.domain.enums.ImageExtension;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
public class ImageMapper {

    public Image mapToImage(MultipartFile file, String name, List<String> tags) throws IOException {
        return Image.builder().name(name).tags(String.join(",", tags)).extension(ImageExtension.valueOf(MediaType.valueOf(file.getContentType()))).file(file.getBytes()).size(file.getSize()).build();
    }

    public ImageDto imagetoDto(Image image, String url) {
        return ImageDto.builder().url(url).extension(image.getExtension().name()).name(image.getName()).size(image.getSize()).uploadDate(image.getUploadDate().toLocalDate()).build();
    }

}
