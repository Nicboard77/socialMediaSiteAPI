package com.blorfer.main.Blip;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlipRepository extends JpaRepository<Blip,Long> {
}
