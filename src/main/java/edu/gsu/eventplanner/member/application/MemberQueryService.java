package edu.gsu.eventplanner.member.application;

import edu.gsu.eventplanner.member.application.dto.MemberDetailView;
import edu.gsu.eventplanner.member.application.dto.MemberFindEmailView;
import edu.gsu.eventplanner.member.application.dto.MemberFindPasswordView;
import edu.gsu.eventplanner.member.domain.Member;
import edu.gsu.eventplanner.member.domain.exception.NotAuthorizedException;
import edu.gsu.eventplanner.member.domain.exception.NotFoundMemberException;
import edu.gsu.eventplanner.member.domain.exception.NotMatchInputParameterException;
import edu.gsu.eventplanner.member.domain.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MemberQueryService {
    private final MemberRepository memberRepository;
    public MemberQueryService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    //1.search my Detail
    @Transactional(readOnly = true)
    public MemberDetailView findMyDetail(String accessToken){
        var optionalMember = memberRepository.findByAccessToken(accessToken);
        if(optionalMember.isEmpty()){
            //no login info
            throw new NotAuthorizedException();
        }
        return MemberDetailView.from(optionalMember.get());
    }
    //2. Find other detail
    //can delete
    @Transactional(readOnly = true)
    public MemberDetailView findMyEmail(String  accessToken, String email){
        memberRepository.findByAccessToken(accessToken).orElseThrow(NotAuthorizedException::new);
        var optionalMember = memberRepository.findByEmail(email);
        if(optionalMember.isEmpty()){
            //해당 회원이 없을 경우
            throw new NotFoundMemberException();
        }
        return MemberDetailView.from(optionalMember.get());
    }
    //3 find my email
    @Transactional(readOnly = true)
    public MemberFindEmailView findMyEmail(String contactNumber){
        var optionalMember = memberRepository.findByContactNumber(contactNumber);
        if(optionalMember.isEmpty()){
            //there is no member
            throw new NotFoundMemberException();
        }
        return MemberFindEmailView.from(optionalMember.get());
    }

    //4 find my password
    @Transactional(readOnly = true)

    public MemberFindPasswordView findMyPassword(String email, String username, String contactNumber){
        var optionalMember = memberRepository.findByEmail(email);
        if(optionalMember.isEmpty()){
            //there is no member
            throw new NotFoundMemberException();
        }
        Member member = optionalMember.get();
        if(!member.getUsername().equals(username)){
            // Info not match
            throw new NotMatchInputParameterException();
        }

        if (!member.getContactNumber().equals(contactNumber)){
            //info not match
            throw new NotMatchInputParameterException();
        }
        return MemberFindPasswordView.from(member);
    }
}
