package io.github.joaoguilherme.imageliteapi.domain.service;

import io.github.joaoguilherme.imageliteapi.domain.entity.Image;

import java.util.Optional;

public interface ImageService {

    Image save(Image image);

    Optional<Image> getBydId(String id);

}
