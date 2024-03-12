package edu.gsu.eventplanner.member.application.command;

import edu.gsu.eventplanner.member.domain.Member;
import edu.gsu.eventplanner.member.domain.exception.ExistedMemberException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@Getter

@AllArgsConstructor
public class MemberSignupCommand {
    private String username;
    private String nickname;
    private String password;
    private String email;
    private String contactNumber;
    private String bio;

    public Member execute(Optional<Member> findByEmailMember, Optional<Member> findByContactNumberMember){
        if(findByEmailMember.isPresent()){
            //already registered
            throw new ExistedMemberException();
        }
        if(findByContactNumberMember.isPresent()){
            //already registered
            throw new ExistedMemberException();
        }

        return Member.signup(username,nickname,password,email,contactNumber,bio);
    }
}
