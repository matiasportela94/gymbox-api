package com.gymbox.bootstrap;

import com.gymbox.model.user.ERole;
import com.gymbox.repository.user.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import com.gymbox.model.user.Role;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"default"})
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final RoleRepository roleRepository;

    public Bootstrap(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if (roleRepository.count() == 0L) {
            log.debug("Loading Roles");
            loadRoles();
        }
    }

    private void loadRoles() {

        Role adminRole = new Role(ERole.ROLE_ADMIN);
        Role userRole = new Role(ERole.ROLE_USER);

        roleRepository.save(adminRole);
        roleRepository.save(userRole);
    }
}