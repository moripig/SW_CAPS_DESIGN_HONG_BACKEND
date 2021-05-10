package net.skhu.service;


import net.skhu.entity.Location;
import net.skhu.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Autowired
    LocationRepository locationRepository;

    public Location searchId(int idx) {
        return locationRepository.findByIdx(idx);
    }
}
