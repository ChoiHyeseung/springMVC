package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username"); // 이름 받아오기
        int age = Integer.parseInt(paramMap.get("age")); // 나이 받아오기

        Member member = new Member(username, age); // 이름과 나이를 담은 Member 객체 생성
        memberRepository.save(member); // 그 정보 저장

        ModelView mv = new ModelView("save-result"); // 뷰 불러오기
        mv.getModel().put("member", member); // 저장된 결과 jsp쪽으로 포워드
        return mv;



    }
}
