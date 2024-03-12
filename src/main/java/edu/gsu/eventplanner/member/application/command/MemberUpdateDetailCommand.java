package edu.gsu.eventplanner.member.application.command;

import edu.gsu.eventplanner.member.domain.Member;
import edu.gsu.eventplanner.member.domain.exception.NotAuthorizedException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@AllArgsConstructor
@Getter
public class MemberUpdateDetailCommand {
    private String accessToekn;
    private String inputNickName;
    private String inputContactNumber;
    private String inputBio;

    public Member excute(Optional<Member>optionalMember){
        if(optionalMember.isEmpty()){
            //no login info
            throw  new NotAuthorizedException();

        }
        Member member = optionalMember.get();
        return member.updateMemberDetail(inputNickName,inputContactNumber,inputBio);
    }
}
