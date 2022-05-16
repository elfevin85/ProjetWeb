package com.example.demothymeleaf.security;

import com.example.demothymeleaf.Domain.Staff;
import com.example.demothymeleaf.Repository.StaffRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private final StaffRepository staffRepository;
    public UserPrincipalDetailsService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String s) throws
            UsernameNotFoundException {
        final Staff staff =
                this.staffRepository.findByUsername(s).orElseThrow(() -> new
                        UsernameNotFoundException("User login not found"));
        return new UserPrincipal(staff);
    }
}
