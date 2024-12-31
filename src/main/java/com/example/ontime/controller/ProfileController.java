package com.example.ontime.controller;

import com.example.ontime.model.dto.ProfileDTO;
import com.example.ontime.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.TimeZone;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public String viewProfile(Model model) {
        // TODO: Get actual user ID from session
        String userId = "1"; // Temporary hardcoded user ID
        ProfileDTO profile = profileService.getProfileByUserId(userId);
        
        List<String> timezones = Arrays.asList(TimeZone.getAvailableIDs());
        model.addAttribute("profile", profile);
        model.addAttribute("timezones", timezones);
        return "profile";
    }

    @GetMapping("/edit")
    public String showEditProfileForm(Model model) {
        // TODO: Get actual user ID from session
        String userId = "1"; // Temporary hardcoded user ID
        ProfileDTO profile = profileService.getProfileByUserId(userId);
        
        List<String> timezones = Arrays.asList(TimeZone.getAvailableIDs());
        model.addAttribute("profile", profile);
        model.addAttribute("timezones", timezones);
        return "edit-profile";
    }

    @PostMapping("/edit")
    public String updateProfile(@ModelAttribute ProfileDTO profileDTO,
                              RedirectAttributes redirectAttributes) {
        // TODO: Get actual user ID from session
        String userId = "1"; // Temporary hardcoded user ID
        profileService.updateProfile(userId, profileDTO);
        redirectAttributes.addFlashAttribute("message", "Profile updated successfully!");
        return "redirect:/profile";
    }
}
