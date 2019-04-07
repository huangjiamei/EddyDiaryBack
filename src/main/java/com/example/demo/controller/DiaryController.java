package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.DiaryEntity;
import com.example.demo.service.DiaryService;
import com.example.demo.util.HttpClientUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import com.example.demo.entity.UserEntity;
/**
 * Created by damei on 19/2/27.
 */
@Controller //控制层注解
@RequestMapping("/") //配置url映射，作用在类上
public class DiaryController {
    @Autowired
    private DiaryService diaryService;

    //Map userMap = new HashMap();
    UserEntity user = new UserEntity();


    @RequestMapping("/login")
    @ResponseBody
    public void login (@RequestBody String infoData, HttpServletRequest request) {
        System.out.println(infoData);
        JSONObject info = JSONObject.parseObject(infoData);
        String code = (String) info.get("code");
        String encryptedData = (String) info.get("encryptedData");
        String  iv =  (String) info.get("iv");
        String nickName = (String) info.get("nickName");
        String avatarUrl = (String) info.get("avatarUrl");

        if(!StringUtils.isNotBlank(code)){
            //return ResultData.build(202,"未获取到用户凭证code");
            System.out.println("未获取到用户凭证code");
        }
        String appid = "wx85a319f39e4fa599";
        String appSecret = "fdc0cf46b22f3d2f8cd627463d454f7a";
        String apiUrl="https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+appSecret+"&js_code="+code+"&grant_type=authorization_code";
        System.out.println(apiUrl);
        String responseBody = HttpClientUtil.doGet(apiUrl);
        System.out.println(responseBody);
        JSONObject jsonObject = JSON.parseObject(responseBody);
        String openid = jsonObject.get("openid").toString();
        user.setUserid(openid);
        user.setUsername(nickName);
        user.setUserpicture(avatarUrl);
        System.out.println(user.toString());
        if(StringUtils.isNotBlank(jsonObject.getString("openid"))&&StringUtils.isNotBlank(jsonObject.getString("session_key"))){
            /*
            //解密获取用户信息
            JSONObject userInfoJSON= WechatGetUserInfoUtil.getUserInfo(encryptedData,jsonObject.getString("session_key"),iv);
            if(userInfoJSON!=null){
                //这步应该set进实体类
                List<UserEntity> userEntityList = diaryService.getAllUsers();
                if(userEntityList != null) {
                    List<String> ids = new ArrayList<String>();
                    for(UserEntity userEntity : userEntityList) {
                        ids.add(userEntity.getUserid());
                    }
                    if(!ids.contains(userInfoJSON.get("openId").toString())) {
                        user.setUserid(userInfoJSON.get("openId").toString());
                        user.setUsername(userInfoJSON.get("nickName").toString());
                        user.setUserpicture(userInfoJSON.get("avatarUrl").toString());
                        diaryService.addUser(user);
                    }
                }else {
                        user.setUserid(userInfoJSON.get("openId").toString());
                        user.setUsername(userInfoJSON.get("nickName").toString());
                        user.setUserpicture(userInfoJSON.get("avatarUrl").toString());
                        diaryService.addUser(user);
                }

                */

            List<UserEntity> userEntityList = diaryService.getAllUsers();
            if(userEntityList != null) {
                List<String> ids = new ArrayList<String>();
                for(UserEntity userEntity : userEntityList) {
                    ids.add(userEntity.getUserid());
                }
                System.out.println(ids);
                if(!ids.contains(openid)) {

                    diaryService.addUser(user);
                }
            }else {
                diaryService.addUser(user);
            }
            System.out.println("登陆成功");
            }
            /*else{
                //return ResultData.build(202,"解密失败");
                System.out.println("解密失败");
            }

        }
        */else{
            //return ResultData.build(202,"未获取到用户openid 或 session");
            System.out.println("未获取到用户openid 或 session");

        }

    }



    @RequestMapping("/diary") //配置url映射，作用在方法上
    //@GetMapping("/diary")
    @ResponseBody
    public List<DiaryEntity> getDiaries() {

        return diaryService.getAllDiaries();
    }


    //@PostMapping("/adddiary")
    @RequestMapping("/adddiary")
    @ResponseBody
    public void addDiary(HttpServletRequest request) {
        DiaryEntity diary = new DiaryEntity();
        diary.setIsprivate(request.getParameter("isPrivate"));
        diary.setDdate(request.getParameter("date"));
        diary.setDtime(request.getParameter("time"));
        diary.setWeek(request.getParameter("week"));
        diary.setLocation(request.getParameter("location"));
        diary.setMood(request.getParameter("mood"));
        diary.setContent(request.getParameter("content"));
        diary.setTag(request.getParameter("tag"));
        diary.setDiarypicture(request.getParameter("diarypicture"));
        diary.setUserByUserid(user);
        diaryService.addDiary(diary);
        //System.out.println(request.getParameter("date"));

    }

    //@PostMapping("deletediary")
    @RequestMapping("/deletediary")
    @ResponseBody
    public void deleteDiaryById (HttpServletRequest request) {
        System.out.println(request.getParameter("diaryid"));
        diaryService.deleteDiaryByiId(request.getParameter("diaryid"));
    }
}
