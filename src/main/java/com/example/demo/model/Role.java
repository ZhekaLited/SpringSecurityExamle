package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role  implements GrantedAuthority{
    public Long id;
    public String name;
    @Override
    public String getAuthority() {
        return "ROLE_"+name;
    }
}
