package com.sbego.springcourse.project3.repositories;

import com.sbego.springcourse.project3.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    Sensor findSensorByName(String name);
}
