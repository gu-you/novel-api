package com.example.novel.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SpringSecurity需要的用户详情
 * Created by macro on 2022/3/26.
 */
public class AdminUserDetails implements UserDetails {

    private SysUser umsAdmin;
    private List<SysRole> roleList;
    public AdminUserDetails(SysUser umsAdmin, List<SysRole> roleList) {
        this.umsAdmin = umsAdmin;
        this.roleList = roleList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        return roleList.stream()
                .filter(role -> role.getRoleKey()!=null)
                .map(role ->new SimpleGrantedAuthority(role.getRoleKey()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return umsAdmin.getPassWord();
    }

    @Override
    public String getUsername() {
        return umsAdmin.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return umsAdmin.getStatus().equals(1);
    }
}
