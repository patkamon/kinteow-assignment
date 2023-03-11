package ku.kinteow.service;

import ku.kinteow.model.Member;
import ku.kinteow.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import ku.kinteow.dto.SignupDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;

@Service
public class SignupService {

    @Autowired
    private MemberRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public boolean isUsernameAvailable(String username) {
        return repository.findByUsername(username) == null;
    }

    public int createMember(SignupDto member) {
        Member newMember = modelMapper.map(member, Member.class);
        newMember.setCreatedAt(Instant.now());

        String hashedPassword = passwordEncoder.encode(member.getPassword());

        newMember.setPassword(hashedPassword);

        repository.save(newMember);
        return 1;
    }

    public Member getMember(String username) {
        return repository.findByUsername(username);
    }
}

