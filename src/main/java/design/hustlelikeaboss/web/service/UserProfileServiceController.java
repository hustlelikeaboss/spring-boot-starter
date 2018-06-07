package design.hustlelikeaboss.web.service;

import design.hustlelikeaboss.business.domain.UserProfile;
import design.hustlelikeaboss.business.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserProfileServiceController {

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/users")
    public List<UserProfile> getAllUserProfiles() {
        return this.userProfileService.getAllUserProfiles();
    }

    @GetMapping("/users/{userId}")
    public UserProfile getUserProfileById(@PathVariable("userId")int userId) {
        return this.userProfileService.getUserProfileById(userId);
    }

    @GetMapping("/roles/{role}")
    public List<UserProfile> getUserProfileByRole(@PathVariable("role")String roleName) {
        return this.userProfileService.getUserProfilesByRole(roleName);
    }
}
