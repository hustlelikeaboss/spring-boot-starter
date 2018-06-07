package design.hustlelikeaboss.web.service;

import design.hustlelikeaboss.business.domain.UserProfile;
import design.hustlelikeaboss.business.service.UserProfileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(UserProfileServiceController.class)
public class UserProfileServiceControllerTest {

    @MockBean
    private UserProfileService userProfileService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnUserProfile() throws Exception {
        int userId = 1;

        UserProfile userProfile = new UserProfile();
        userProfile.setUserId(1);
        userProfile.setEmail("test@email.com");
        userProfile.setFirstName("test");
        userProfile.setLastName("demo");
        userProfile.setActive(true);

        List<String> roles = new ArrayList<>();
        roles.add("USER");
        userProfile.setRoles(roles);

        given(userProfileService.getUserProfileById(1)).willReturn(userProfile);
        this.mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("json"))
                .andExpect(content().string(containsString("")));
    }
}