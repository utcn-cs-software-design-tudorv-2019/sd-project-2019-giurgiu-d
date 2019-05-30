package com.example.projectPS.M.Repositories;

import com.example.projectPS.M.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    public Admin findAdminByIdAdmin(int id);
    public ArrayList<Admin> findAdminByAdminName(int id);
    public Admin findByAdminName(String name);
    public Admin findByPassword(String name);
}
