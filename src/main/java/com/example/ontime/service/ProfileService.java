package com.example.ontime.service;

import com.example.ontime.entity.Profile;
import com.example.ontime.entity.User;
import com.example.ontime.model.dto.ProfileDTO;
import com.example.ontime.repository.ProfileRepository;
import com.example.ontime.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;

    public ProfileDTO getProfileByUserId(String userId) {
        Profile profile = profileRepository.findByUserId(userId)
                .orElseGet(() -> createDefaultProfile(userId));
        return convertToDTO(profile);
    }

    public ProfileDTO updateProfile(String userId, ProfileDTO profileDTO) {
        Profile profile = profileRepository.findByUserId(userId)
                .orElseGet(() -> createDefaultProfile(userId));

        profile.setFirstName(profileDTO.getFirstName());
        profile.setLastName(profileDTO.getLastName());
        profile.setBio(profileDTO.getBio());
        profile.setPhoneNumber(profileDTO.getPhoneNumber());
        profile.setLocation(profileDTO.getLocation());
        profile.setTimezone(profileDTO.getTimezone());
        profile.setBirthDate(profileDTO.getBirthDate());

        Profile savedProfile = profileRepository.save(profile);
        return convertToDTO(savedProfile);
    }

    private Profile createDefaultProfile(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        Profile profile = new Profile();
        profile.setUser(user);
        profile.setFirstName(user.getName().split(" ")[0]);
        profile.setLastName(user.getName().contains(" ") ? 
            user.getName().substring(user.getName().indexOf(" ") + 1) : "");
        profile.setBio("Welcome to my profile!");
        profile.setTimezone(java.util.TimeZone.getDefault().getID());
        return profileRepository.save(profile);
    }

    private ProfileDTO convertToDTO(Profile profile) {
        ProfileDTO dto = new ProfileDTO();
        dto.setProfileId(profile.getProfileId());
        dto.setUserId(profile.getUser().getId());
        dto.setFirstName(profile.getFirstName());
        dto.setLastName(profile.getLastName());
        dto.setBio(profile.getBio());
        dto.setPhoneNumber(profile.getPhoneNumber());
        dto.setLocation(profile.getLocation());
        dto.setTimezone(profile.getTimezone());
        dto.setBirthDate(profile.getBirthDate());
        return dto;
    }
}
