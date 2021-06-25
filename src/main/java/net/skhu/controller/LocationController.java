package net.skhu.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.entity.Location;
import net.skhu.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping(path = "/location")
public class LocationController {
    @Autowired
    LocationService locationService;

    @GetMapping("/search/{idx}")
    public Location getLoc(@PathVariable("idx") int loc_idx) {
        Location location = locationService.searchId(loc_idx);

        return location;
    }

}
