package com.aps.env.service;

import com.aps.env.comm.*;
import com.aps.env.dao.ComMenuMapper;
import com.aps.env.dao.ComPersonMapper;
import com.aps.env.entity.ComPerson;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewMainServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/9</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class MainServiceImpl implements MainService {
    @Resource
    private ComMenuMapper comMenuMapper;
    @Resource
    private ComPersonMapper comPersonMapper;

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void referPersonMenu(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        int personId = (int) httpSession.getAttribute(CommUtil.SESSION_PERSON_ID);
        ObjectNode personInf = JsonUtil.getObjectNodeInstance();

        responseData.setData(comMenuMapper.selectPersonMenu(personId));
        personInf.put(CommUtil.SESSION_USER_NAME, (String) httpSession.getAttribute(CommUtil.SESSION_USER_NAME));
        personInf.put(CommUtil.SESSION_USER_ID, (String) httpSession.getAttribute(CommUtil.SESSION_USER_ID));
        responseData.setSubJoinJson(personInf);
    }

    /**
     * @param httpSession
     * @param requestMdyPar
     * @param responseData
     */
    @Override
    public void modifyPersonPassword(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData) {
        ComPerson person = comPersonMapper.selectByPrimaryKey((int) httpSession.getAttribute(CommUtil.SESSION_PERSON_ID));
        String pswo = requestMdyPar.getInPar().get(0).get("pswo");
        String pswn = requestMdyPar.getInPar().get(0).get("pswn");

        if (null == person) {
            responseData.setCode(-100);
            responseData.setMessage("登陆超时，请重新登入!!");
            return;
        }

        if (!pswo.equals(MD5Util.getMD5String(StringUtil.desDecryptStr(person.getUserPsw(), CommUtil.LOCK_WORD)))) {
            responseData.setCode(-100);
            responseData.setMessage("您录入旧密码有误!!");
            return;
        }
        person.setUserPsw(StringUtil.desEncryptStr(pswn, CommUtil.LOCK_WORD));

        if (comPersonMapper.updateByPrimaryKeySelective(person) == 0) {
            responseData.setCode(-100);
            responseData.setMessage("用户已不存在!!");
            return;
        }

        responseData.setCode(0);
    }
}
