package com.tx.springboot_02.action;

import com.github.pagehelper.PageInfo;
import com.tx.springboot_02.biz.TRecordBiz;
import com.tx.springboot_02.biz.TStudentBiz;
import com.tx.springboot_02.pojo.TRecord;
import com.tx.springboot_02.pojo.TStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/c/users")
public class TStudentAction {
    @Autowired
    private TStudentBiz sbiz;
    @Autowired
    private TRecordBiz rbiz;


    @GetMapping("login")
    public String login() {
       return "login";
    }

    @PostMapping("loginIn")
    public String loginIn(Model model, TStudent student ,HttpSession session){
        TStudent stu=sbiz.login(student.getName(),student.getCode());
        if(stu!=null){
            session.setAttribute("USERS",stu.getName());
            PageInfo<TStudent> pageInfo = sbiz.findAll(1, 3);
            //pageInfo.getList().clear();
            model.addAttribute("PAGE_INFO", pageInfo);
            return "StudentSys";
        }else {
            model.addAttribute("MSG", "用户名或密码错误");
            return "login";//必须是模板文件名【转发】
        }
    }

    @GetMapping("getList")
    public String getMessageList( Integer p,  Integer s,String stucode, Model model) {
        PageInfo<TStudent> pageInfo = sbiz.findAll(p, s);
        //pageInfo.getList().clear();
        List<TRecord> tr=rbiz.findTRecord(stucode);
        model.addAttribute("tr",tr);
        model.addAttribute("PAGE_INFO", pageInfo);
        return "StudentSys";
    }

    @GetMapping("sanction")
    public String getsanction(Integer p,  Integer s,String des,String name ,Model model) {
        System.out.println(s+"---"+p+"---"+des+"--"+name);
        PageInfo<TRecord> pageInfo = rbiz.findAll(p, s,des,name);
        model.addAttribute("PAGE_INFO", pageInfo);
        return "sanctionSys";
    }

    @GetMapping("sanction1")
    public String getsanction1(String des,String name ,Model model) {
        PageInfo<TRecord> pageInfo = rbiz.findAll(1, 3,des,name);
        model.addAttribute("PAGE_INFO", pageInfo);
        return "sanctionSys";
    }
    @GetMapping("del1")
    public String removeMessageInfo1(Integer mid) {
       rbiz.deleteByPrimaryKey(mid);
        return "redirect:/c/users/sanction?p=1&s=3";
    }
    @GetMapping("inser")
    public String insert() {
        return "insert";
    }

    @PostMapping("insertr")
    public String loginIn(TRecord tRecord){
        int count=rbiz.insertSelective(tRecord);
        if(count!=0){
            return "redirect:/c/users/sanction?p=1&s=3";
        }
        return "insert";
    }

    @GetMapping("up")
    public String up(Integer id,Model model) {
        TRecord re= rbiz.selectByPrimaryKey(id);
        model.addAttribute("re",re);
        return "update";
    }

    @PostMapping("update")
    public String update(TRecord tRecord){
        int count=rbiz.updateByPrimaryKeySelective(tRecord);
        if(count!=0){
            return "redirect:/c/users/sanction?p=1&s=3";
        }
        return "update";
    }


}
