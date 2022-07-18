package spring.practice.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring.practice.AppConfig;
import spring.practice.member.*;

import java.util.List;

@Controller
public class MemberController {

    AppConfig appConfig = new AppConfig();
    MemberManage manageMember = appConfig.memberManage();
    MemberRepository memberRepository = appConfig.memberRepository();

    @GetMapping("/members/new")
    public String 회원가입() {
        return "members/createMember";
    }

    @PostMapping("/members/new")
    public String 회원조회(MemberForm form) {
        form.setId();
        Member member = new Member(form.getName(), form.getAge(), form.getId());
        member.setName(form.getName());
        member.setAge(form.getAge());

        System.out.println("member = " + member.getName() + ", 나이 = " + member.getAge());
        manageMember.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = manageMember.findMembers();
        model.addAttribute("members", members);
        return "members/findMember";
    }
}
