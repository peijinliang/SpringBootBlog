package com.blog.controlller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.blog.domain.Authority;
import com.blog.domain.User;
import com.blog.service.AuthorityService;
import com.blog.service.UserService;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * 主页控制器.
 *
 * @author Marlon
 * @since 1.0.0 2017年5月28日
 * <p>
 * 1、注册应该分为  第三方注册（获取头像和昵称）、
 * 2、手机号绑定
 */

@Controller
public class MainController {

    private static final Long ROLE_USER_AUTHORITY_ID = 2L;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "redirect:/blogs";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("errorMsg", "登陆失败，用户名或者密码错误！");
        return "login";
    }

    //直接进入注册界面
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    @PostMapping("/register")
    public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, Map<String, Object> map) {
        //上来第一部应该是数据清洗
        if (bindingResult.hasErrors()) {
            map.put("error", bindingResult.getFieldError().getDefaultMessage());
            return new ModelAndView("/register", map);
        }
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authorityService.getAuthorityById(ROLE_USER_AUTHORITY_ID));
        user.setAuthorities(authorities);

        userService.registerUser(user);
        return new ModelAndView("/login");
    }

    /**
     * 退出登录
     *
     * @return
     */
    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    //忘记密码
    @GetMapping("/forget")
    public String forget() {
        return "forget";
    }


}
