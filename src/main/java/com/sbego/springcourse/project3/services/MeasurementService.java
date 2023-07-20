package com.sbego.springcourse.project3.services;

import com.sbego.springcourse.project3.models.Measurement;
import com.sbego.springcourse.project3.repositories.MeasurementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Service
public class MeasurementService {
    private final MeasurementRepository measurementRepository;

    private final SensorService sensorService;

    public MeasurementService(MeasurementRepository measurementRepository, SensorService sensorService) {
        this.measurementRepository = measurementRepository;
        this.sensorService = sensorService;
    }

    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }

    public Measurement findOne(int id) {
        Optional<Measurement> measurement = measurementRepository.findById(id);

        return measurement.orElseThrow(null);
    }

    @Transactional
    public void save(Measurement measurement) {
        enrichMeasurement(measurement);

        measurementRepository.save(measurement);
    }

    private void enrichMeasurement(Measurement measurement) {
        measurement.setSensor(sensorService.findOneByName(measurement.getSensor().getName()));
        measurement.setMeasurementDateTime(LocalDateTime.now());
    }
}
