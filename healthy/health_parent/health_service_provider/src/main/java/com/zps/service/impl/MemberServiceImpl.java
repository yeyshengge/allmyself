package com.zps.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zps.dao.MemberDao;
import com.zps.pojo.Member;
import com.zps.service.MemberService;
import com.zps.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service(interfaceClass = MemberService.class)
@Transactional
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;

    @Override
    public Member findByTelephone(String telephone) {
        return memberDao.findByTelephone(telephone);
    }

    @Override
    public void add(Member member) {
        if (member.getPassword() != null) {
            member.setPassword(MD5Utils.md5(member.getPassword()));
        }
        memberDao.add(member);
    }

    @Override
    public List<Integer> getMemberReport(List<String> list) {
        List<Integer> countList = new ArrayList<>();
        for (String s : list) {
            s = s + ".31";
            countList.add(memberDao.findMemberCountBeforeDate(s));
        }
        return countList;
       /* List<String> countList = new ArrayList<>();
        for (String s : list) {
            s = s + ".31";
            countList.add(s);
        }
        List<Integer> memberCountByDateList = memberDao.findMemberCountByDateList(countList);
        return memberCountByDateList;*/
    }
}
