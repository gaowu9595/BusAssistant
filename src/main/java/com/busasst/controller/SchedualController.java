package com.busasst.controller;

import com.busasst.bean.SchedualBean;
import com.busasst.dao.SchedualDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/13.
 */
@Controller
@RequestMapping("/schedual")
public class SchedualController {

    @Autowired
    private SchedualDao schedualDao;

    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public String watchSchedual(HttpSession session){
        session.setAttribute("activeId",3);
        return "schedual-mng";
    }


    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public String addSchedual(){

        return "redirect:/schedual/list";
    }

    @RequestMapping(value = "/addshow" , method = RequestMethod.GET)
    public String addSchedualShow(){

        return "schedual-do";
    }


    @ResponseBody
    @RequestMapping(value = "/date" , method = RequestMethod.POST)
    public List<SchedualBean> watchDetaile(String yearmonth , String day){

        String yearAndMonth[] = yearmonth.split("年");
        String month[] = yearAndMonth[1].split("月");
        String date = yearAndMonth[0]+"-"+month[0]+"-"+day;
        System.out.println(date);
        return schedualDao.getDetaile(date);
    }

}
