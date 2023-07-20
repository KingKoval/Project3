package com.sbego.springcourse.project3.services;


import com.sbego.springcourse.project3.models.Sensor;
import com.sbego.springcourse.project3.repositories.SensorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class SensorService {

    private final SensorRepository sensorRepository;

    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public Sensor findOneByName(String name) {
        return sensorRepository.findSensorByName(name);
    }
}
