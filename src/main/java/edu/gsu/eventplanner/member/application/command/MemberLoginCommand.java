package edu.gsu.eventplanner.member.application.command;

import edu.gsu.eventplanner.member.domain.Member;
import edu.gsu.eventplanner.member.domain.exception.InvaildPasswordException;
import edu.gsu.eventplanner.member.domain.exception.NotFoundMemberException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@AllArgsConstructor
@Getter
public class MemberLoginCommand {
    private String inputLoginEmail;
    private String inputPassword;

    public Member excute(Optional<Member> optionalMember){
        if(optionalMember.isEmpty()){
            throw new NotFoundMemberException();
        }
        Member member = optionalMember.get();
        if(!member.isValidPassword(inputPassword)){
            // wrong password
            throw new InvaildPasswordException();
        }
        member.login();
        return member;

    }
}
