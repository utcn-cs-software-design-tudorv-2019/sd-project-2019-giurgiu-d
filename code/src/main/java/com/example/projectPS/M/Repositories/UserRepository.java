package com.example.projectPS.M.Repositories;

import com.example.projectPS.M.Model.Admin;
import com.example.projectPS.M.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
