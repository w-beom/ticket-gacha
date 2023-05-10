package kr.co.ticketgacha.application;

import kr.co.ticketgacha.domain.Member;
import kr.co.ticketgacha.domain.MemberRepository;
import kr.co.ticketgacha.presentation.dto.request.CreateMemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public void signUp(CreateMemberRequest createMemberRequest) {
        Member member = Member.builder()
                .id(createMemberRequest.getId())
                .pw(createMemberRequest.getPw())
                .email(createMemberRequest.getEmail())
                .name(createMemberRequest.getName())
                .phone(createMemberRequest.getPhone())
                .banned(false)
                .admin(false)
                .build();

        memberRepository.save(member);
    }
}
