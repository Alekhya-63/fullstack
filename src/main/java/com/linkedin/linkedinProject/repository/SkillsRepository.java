package com.linkedin.linkedinProject.repository;
import com.linkedin.linkedinProject.model.Login;
import com.linkedin.linkedinProject.model.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SkillsRepository extends JpaRepository<Skills, Integer> {
    public void deleteBySkill(String skill);

    public Skills findBySkill(String skill);

    boolean existsBySkill(String skill);

	public Skills findById(int sid);

	public boolean existsByUserAndSkill(Optional<Login> findById, String name);

	public Skills findByUserAndSkill(Login login, String skill);

	public Skills[] findByUser(Login login);

	public Skills findByUserAndSkill(Optional<Login> login, String skill);
}
