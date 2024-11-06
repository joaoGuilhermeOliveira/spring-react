package io.github.joaoguilherme.imageliteapi.infra.repository;

import io.github.joaoguilherme.imageliteapi.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {
}
