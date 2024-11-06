package io.github.joaoguilherme.imageliteapi.domain.service;

import io.github.joaoguilherme.imageliteapi.domain.entity.Image;
import io.github.joaoguilherme.imageliteapi.infra.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService{

    private final ImageRepository imageRepository;
    @Override
    @Transactional
    public Image save(Image image) {
        return imageRepository.save(image);
    }
}
