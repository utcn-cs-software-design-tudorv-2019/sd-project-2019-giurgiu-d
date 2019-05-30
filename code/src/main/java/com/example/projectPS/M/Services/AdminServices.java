package com.example.projectPS.M.Services;

import com.example.projectPS.M.Model.Admin;
import com.example.projectPS.M.Repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServices {

        @Autowired
        AdminRepository adminRepo;
        public List<Admin> getAllAdmins()
        {
            return adminRepo.findAll();
        }
        public Admin create(Admin cr)
        {
            return adminRepo.save(cr);
        }
        public void delete(Admin cr)
        {
            adminRepo.delete(cr);
        }
        public void update(Admin old, Admin st)
        {
            if(old==null)
            {
                System.out.println("eror at update");
            }
            else
            {
                adminRepo.delete(old);
                adminRepo.save(st);
            }
        }
        public Admin findById(int id){return adminRepo.findAdminByIdAdmin(id);}
        public Admin findByAdminName(String name){return adminRepo.findByAdminName(name);}
        public Admin findByPassword(String name){return adminRepo.findByPassword(name);}
    }

