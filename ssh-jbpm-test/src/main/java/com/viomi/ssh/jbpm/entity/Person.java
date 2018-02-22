package com.viomi.ssh.jbpm.entity;

import static javax.persistence.GenerationType.IDENTITY;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "person", schema = "jbpm_test", catalog = "")
public class Person
{
    private Integer userid;
    
    private String name;
    
    private String account;
    
    private Byte status;
    
    public enum Status
    {
        UNKNOWN((byte) -100, "无法识别"),
        DELETE((byte) -1, "删除"),
        DISABLE((byte) 0, "冻结"),
        NORMAL((byte) 1, "正常");
        
        private Byte code;
        
        private String desc;
        
        private Status(Byte code, String desc)
        {
            this.code = code;
            this.desc = desc;
        }
        
        public static Status getByCode(Byte code)
        {
            Status s = UNKNOWN;
            if(code != null)
            {
                for(Status e : Status.values())
                {
                    if(e.code == code)
                    {
                        s = e;
                        break;
                    }
                }
            }
            return s;
        }
        
        public Byte getCode()
        {
            return code;
        }
        
        public String getDesc()
        {
            return desc;
        }
    }
    
    @JsonIgnore
    private String pwd;
    
    private String phone;
    
    private String email;
    
    private Date createdTime;
    
    private Date updatedTime;
    
    private String creator;
    
    private Integer roleId;
    
    private String pwdSalt;
    
    public Person()
    {
        // TODO Auto-generated constructor stub
        super();
    }
    
    public Person(String account, String pwd, String name, String mobile, String email)
    {
        super();
        this.account = account;
        this.pwd = pwd;
        this.name = name;
        this.phone = mobile;
        this.email = email;
    }
    
    @Basic
    @Column(name = "pwd")
    public String getPwd()
    {
        return pwd;
    }
    
    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }
    
    @Basic
    @Column(name = "phone")
    public String getPhone()
    {
        return phone;
    }
    
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "userid")
    public Integer getUserid()
    {
        return userid;
    }
    
    public void setUserid(Integer userid)
    {
        this.userid = userid;
    }
    
    @Basic
    @Column(name = "roleid")
    public Integer getRoleId()
    {
        return roleId;
    }
    
    public void setRoleId(Integer roleId)
    {
        this.roleId = roleId;
    }
    
    @Basic
    @Column(name = "name")
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    @Basic
    @Column(name = "account")
    public String getAccount()
    {
        return account;
    }
    
    public void setAccount(String account)
    {
        this.account = account;
    }
    
    @Basic
    @Column(name = "status")
    public Byte getStatus()
    {
        return status;
    }
    
    public void setStatus(Byte status)
    {
        this.status = status;
    }
    
    @Basic
    @Column(name = "email")
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_time", insertable = true, updatable = false)
    public Date getCreatedTime()
    {
        return createdTime;
    }
    
    public void setCreatedTime(Date createdTime)
    {
        this.createdTime = createdTime;
    }
    
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_time")
    public Date getUpdatedTime()
    {
        return updatedTime;
    }
    
    public void setUpdatedTime(Date updatedTime)
    {
        this.updatedTime = updatedTime;
    }
    
    @Basic
    @Column(name = "creator", updatable = false)
    public String getCreator()
    {
        return creator;
    }
    
    public void setCreator(String creator)
    {
        this.creator = creator;
    }

    @Column(name = "pwd_salt")
    public String getPwdSalt()
    {
        return pwdSalt;
    }

    public void setPwdSalt(String pwdSalt)
    {
        this.pwdSalt = pwdSalt;
    }
    
}
