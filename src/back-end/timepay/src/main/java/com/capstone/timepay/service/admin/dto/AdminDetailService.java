package com.capstone.timepay.service.admin.dto;

import com.capstone.timepay.domain.admin.Admin;
import com.capstone.timepay.domain.admin.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdminDetailService implements UserDetailsService {

    private final AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String adminName) throws UsernameNotFoundException {
        Optional<Admin> admin = adminRepository.findByAdminName(adminName);

        if (!admin.isPresent()) {
            throw new UsernameNotFoundException("User not found with username: " + adminName);
        }

        return new User(
                admin.get().getAdminName(), admin.get().getPassword(),
                new ArrayList<>());
    }
}
