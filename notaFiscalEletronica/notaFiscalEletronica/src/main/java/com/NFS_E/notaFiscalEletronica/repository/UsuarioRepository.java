package com.NFS_E.notaFiscalEletronica.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.NFS_E.notaFiscalEletronica.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario ,UUID> {
    
    UserDetails findByLogin(String login);
}
