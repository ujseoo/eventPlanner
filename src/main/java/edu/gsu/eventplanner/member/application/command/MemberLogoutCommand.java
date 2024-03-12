package edu.gsu.eventplanner.member.application.command;

import edu.gsu.eventplanner.member.domain.Member;
import edu.gsu.eventplanner.member.domain.exception.NotAuthorizedException;
import edu.gsu.eventplanner.member.domain.exception.NotFoundMemberException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@AllArgsConstructor
@Getter
public class MemberLogoutCommand {
    private String accessToken;


    public Member excute(Optional<Member> optionalMember){
        if(optionalMember.isEmpty()){
            //cant find member
            throw new NotAuthorizedException();
        }
        Member member = optionalMember.get();
        member.logout();
        return member;
    }
}
