package com.zps.dao;

import com.github.pagehelper.Page;
import com.zps.pojo.Member;

import java.util.List;

public interface MemberDao {
    public List<Member> findAll();

    public Page<Member> selectByCondition(String queryString);

    //增加会员信息
    public void add(Member member);

    public void deleteById(Integer id);

    public Member findById(Integer id);

    //通过电话号码查询该该用户是否是会员
    public Member findByTelephone(String telephone);

    public void edit(Member member);

    public Integer findMemberCountBeforeDate(String date);

    public Integer findMemberCountByDate(String date);

    public Integer findMemberCountAfterDate(String date);

    public Integer findMemberTotalCount();

    public List<Integer> findMemberCountByDateList(List<String> list);
}
