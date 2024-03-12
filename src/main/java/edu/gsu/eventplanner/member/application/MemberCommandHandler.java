package edu.gsu.eventplanner.member.application;

import edu.gsu.eventplanner.member.application.command.MemberLoginCommand;
import edu.gsu.eventplanner.member.application.command.MemberLogoutCommand;
import edu.gsu.eventplanner.member.application.command.MemberSignupCommand;
import edu.gsu.eventplanner.member.application.command.MemberUpdateDetailCommand;
import edu.gsu.eventplanner.member.domain.Member;
import edu.gsu.eventplanner.member.domain.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MemberCommandHandler {
    private final MemberRepository memberRepository;

    public MemberCommandHandler(MemberRepository memberRepository){
        this.memberRepository =memberRepository;

    }
    //1 register
    @Transactional
    public Member handle(MemberSignupCommand command){
        //No same emails
        var findByEmailMember = memberRepository.findByEmail(command.getEmail());
        var findByContactNumberMember = memberRepository.findByContactNumber(command.getContactNumber());
        return memberRepository.save(command.execute(findByEmailMember,findByContactNumberMember));

    }
    //2 login
    @Transactional
    public Member handle(MemberLoginCommand command){
        var member = memberRepository.findByEmail(command.getInputLoginEmail());
        return  memberRepository.save(command.excute(member));
    }
    //3 logout
    @Transactional
    public Member handle(MemberLogoutCommand command){
        var member = memberRepository.findByAccessToken(command.getAccessToken());
        return memberRepository.save(command.excute(member));
    }
    //4 change detail
    @Transactional
    public Member handle(MemberUpdateDetailCommand command){
        var member = memberRepository.findByAccessToken(command.getAccessToekn());
        return memberRepository.save(command.excute(member));
    }
}
