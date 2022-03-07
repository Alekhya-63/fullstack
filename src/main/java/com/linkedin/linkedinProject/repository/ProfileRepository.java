package com.linkedin.linkedinProject.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.linkedin.linkedinProject.model.Login;
import com.linkedin.linkedinProject.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer>{

	Profile findByUserAndName(Login login, String name);

	Profile findByUser(Optional<Login> user);

	Profile findByUser(Login user);

}
