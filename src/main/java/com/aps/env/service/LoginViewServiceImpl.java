package com.aps.env.service;

import com.aps.env.comm.*;
import com.aps.env.dao.ComOrgFormRightsMapper;
import com.aps.env.dao.ComPersonMapper;
import com.aps.env.entity.ComOrgFormRights;
import com.aps.env.entity.ComPerson;
import com.aps.env.entity.ComPersonExample;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <dl>
 * <dt>com.aps.env.service.LoginViewServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/8</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class LoginViewServiceImpl implements LoginViewService {
    @Resource
    private ComPersonMapper comPersonMapper;
    @Resource
    private ComOrgFormRightsMapper comOrgFormRightsMapper;

    /**
     * <p>
     * Title: selectByPrimaryKey
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param personId
     * @return
     * @see LoginViewService#selectPersonByPrimaryKey(java.lang.Integer)
     */
    @Override
    public ComPerson selectPersonByPrimaryKey(Integer personId) {
        return this.comPersonMapper.selectByPrimaryKey(personId);
    }

    /**
     * <p>
     * Title: selectByUserName
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param userId
     * @return
     * @see LoginViewService#selectPersonByUserId(java.lang.String)
     */
    @Override
    public ComPerson selectPersonByUserId(String userId) {
        ComPersonExample comPersonExample = new ComPersonExample();
        comPersonExample.createCriteria().andUserIdEqualTo(userId);

        List<ComPerson> comPersonList = comPersonMapper.selectByExample(comPersonExample);
        if (!CommUtil.isEmptyList(comPersonList)) {
            return comPersonList.get(0);
        } else {
            return new ComPerson();
        }
    }

    /**
     * <p>
     * Title: selectPersonPermissions
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param personId
     * @return
     * @see LoginViewService#selectPersonPermissions(java.lang.Integer)
     */
    @Override
    public List<ComOrgFormRights> selectPersonPermissions(Integer personId) {
        return comOrgFormRightsMapper.selectByPersonId(personId);
    }

    /**
     * @param userId
     * @param password
     * @param verification
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    @Override
    public ModelAndView tryToLogin(String userId, String password, String verification, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession httpSession = httpServletRequest.getSession();
        String userPassword, userVerification;

        userVerification = (String) httpSession.getAttribute(CommUtil.SESSION_VERIFICATION);
        if (!verification.equals(userVerification)) {
            modelAndView.addObject("verification", "1");
            modelAndView.setViewName("index");
        } else {
            ComPersonExample comPersonExample = new ComPersonExample();
            comPersonExample.createCriteria().andUserIdEqualTo(userId);
            List<ComPerson> comPersonList = comPersonMapper.selectByExample(comPersonExample);

            if (CommUtil.isEmptyList(comPersonList)) {
                modelAndView.addObject("verification", "2");
                modelAndView.setViewName("index");
            } else {
                ComPerson comPerson = comPersonList.get(0);

                userPassword = StringUtil.desDecryptStr(comPerson.getUserPsw(), CommUtil.LOCK_WORD);
                userPassword = MD5Util.getMD5String(MD5Util.getMD5String(userPassword) + userVerification);

                if (userPassword.equals(password)) {
                    httpSession.setAttribute(CommUtil.SESSION_PERSON_ID, comPerson.getPersonId());
                    httpSession.setAttribute(CommUtil.SESSION_USER_ID, comPerson.getUserId());
                    httpSession.setAttribute(CommUtil.SESSION_USER_NAME, comPerson.getUserName());

                    CommUtil.updatePermissoned(httpSession, comOrgFormRightsMapper.selectByPersonId(comPerson.getPersonId()));

                    modelAndView.addObject("verification", "0");
                    modelAndView.setViewName("main");
                } else {
                    modelAndView.addObject("verification", "3");
                    modelAndView.setViewName("index");
                }
            }
        }
        return modelAndView;
    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void tryToLoginMobile(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        String userId = requestRefPar.getStringPar("userId");
        String password = requestRefPar.getStringPar("password");
        String userPassword;

        ComPersonExample comPersonExample = new ComPersonExample();
        comPersonExample.createCriteria().andUserIdEqualTo(userId);
        List<ComPerson> comPersonList = comPersonMapper.selectByExample(comPersonExample);

        if (CommUtil.isEmptyList(comPersonList)) {
            responseData.setCode(-200);
            responseData.setMessage("账户不存在...!!");
        } else {
            ComPerson comPerson = comPersonList.get(0);
            userPassword = StringUtil.desDecryptStr(comPerson.getUserPsw(), CommUtil.LOCK_WORD);
            //userPassword = MD5Util.getMD5String(MD5Util.getMD5String(userPassword));
            userPassword = DigestUtils.md5DigestAsHex(userPassword.getBytes());
            if (userPassword.equals(password)) {
                httpSession.setAttribute(CommUtil.SESSION_PERSON_ID, comPerson.getPersonId());
                httpSession.setAttribute(CommUtil.SESSION_USER_ID, comPerson.getUserId());
                httpSession.setAttribute(CommUtil.SESSION_USER_NAME, comPerson.getUserName());

                CommUtil.updatePermissoned(httpSession, comOrgFormRightsMapper.selectByPersonId(comPerson.getPersonId()));

                List<ComPerson> comPersonListTemp = new ArrayList<>();
                comPerson.setUserPsw(null);
                comPersonListTemp.add(comPerson);
                responseData.setCode(0);
                responseData.setData(comPersonListTemp);
            } else {
                responseData.setCode(-201);
                responseData.setMessage("账户密码不匹配...!!");
            }
        }
    }
}
