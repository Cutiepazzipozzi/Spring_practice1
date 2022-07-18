package spring.practice.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring.practice.AppConfig;
import spring.practice.member.*;
import spring.practice.order.Order;
import spring.practice.order.OrderGenerate;
import spring.practice.order.OrderRepository;

import java.util.List;

@Controller
public class MemberController {

    AppConfig appConfig = new AppConfig();
    MemberManage manageMember = appConfig.memberManage();
    MemberRepository memberRepository = appConfig.memberRepository();
    OrderGenerate orderGenerate = appConfig.orderGenerate();

    OrderRepository orderRepository = appConfig.orderRepository();

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

        manageMember.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = manageMember.findMembers();
        model.addAttribute("members", members);
        return "members/findMember";
    }

    @GetMapping("/members/order")
    public String order() {
        return "members/createOrder";
    }

    @PostMapping("/members/order")
    public String orderList(MemberForm form, Model model) {
        Order order = orderGenerate.createOrder(form.getName(), form.getpName(), form.getPrice(), form.getpNumber());
        Member member = memberRepository.findByName(form.getName());
        member.setName(form.getName());
        order.setpName(form.getpName());
        order.setPrice(form.getPrice());
        order.setpNumber(form.getpNumber());
        manageMember.join(member);
        orderRepository.save(order);
        return "redirect:/";
    }

    @GetMapping("/members/orderList")
    public String orderlist(Model model) {
        List<Member> members = manageMember.findMembers();
        List<Order> orders = orderRepository.findAll();

        model.addAttribute("members", members);
        model.addAttribute("orders", orders);
        return "members/returnOrder";
    }





}
