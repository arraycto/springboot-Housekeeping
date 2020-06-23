package com.briup.jz.dao;

import com.briup.jz.bean.AccountSystem;
import com.briup.jz.bean.AccountSystemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountSystemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_system
     *
     * @mbg.generated Thu Jun 11 15:13:29 GMT+08:00 2020
     */
    long countByExample(AccountSystemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_system
     *
     * @mbg.generated Thu Jun 11 15:13:29 GMT+08:00 2020
     */
    int deleteByExample(AccountSystemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_system
     *
     * @mbg.generated Thu Jun 11 15:13:29 GMT+08:00 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_system
     *
     * @mbg.generated Thu Jun 11 15:13:29 GMT+08:00 2020
     */
    int insert(AccountSystem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_system
     *
     * @mbg.generated Thu Jun 11 15:13:29 GMT+08:00 2020
     */
    int insertSelective(AccountSystem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_system
     *
     * @mbg.generated Thu Jun 11 15:13:29 GMT+08:00 2020
     */
    List<AccountSystem> selectByExample(AccountSystemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_system
     *
     * @mbg.generated Thu Jun 11 15:13:29 GMT+08:00 2020
     */
    AccountSystem selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_system
     *
     * @mbg.generated Thu Jun 11 15:13:29 GMT+08:00 2020
     */
    int updateByExampleSelective(@Param("record") AccountSystem record, @Param("example") AccountSystemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_system
     *
     * @mbg.generated Thu Jun 11 15:13:29 GMT+08:00 2020
     */
    int updateByExample(@Param("record") AccountSystem record, @Param("example") AccountSystemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_system
     *
     * @mbg.generated Thu Jun 11 15:13:29 GMT+08:00 2020
     */
    int updateByPrimaryKeySelective(AccountSystem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_system
     *
     * @mbg.generated Thu Jun 11 15:13:29 GMT+08:00 2020
     */
    int updateByPrimaryKey(AccountSystem record);
}