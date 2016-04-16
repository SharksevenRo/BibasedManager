package com.nchu.controller;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.nchu.hibnernate.support.Page;
import com.nchu.model.TbRole;
import com.nchu.model.TbUser;
import com.nchu.service.BaseService;
import com.nchu.web.support.MessageBean;
import com.nuhu.constant.APPConstant;

@Controller
public class RoleController {
	@Autowired
	private BaseService<TbRole> baseService;
	
	@RequestMapping("/user/roles")
	@ResponseBody
	public Page<TbRole> getRoles(){
		Page page=new Page<TbUser>();
		try {
			List<TbRole> roles = baseService.loadAll(new TbRole());
			page.setResult(roles);
			page.setCode(APPConstant.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			page.setCode(APPConstant.ERROR);
			page.setMessage("服务器异常，请刷新");
		}
		return page;
	}
	@RequestMapping("/user/add")
	@ResponseBody
	public MessageBean add(TbRole user){
		
		try {
			baseService.save(user);
			return new MessageBean(APPConstant.SUCCESS, "注册成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new MessageBean(APPConstant.ERROR, "注册失败");
		}
		
	}
	public static void main(String[] args) throws Exception {
        Connection conn = null;
        String sql;
        // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
        // 避免中文乱码要指定useUnicode和characterEncoding
        // 执行数据库操作之前要在数据库管理系统上创建一个数据库，名字自己定，
        // 下面语句之前就要先创建javademo数据库
        String url = "jdbc:mysql://localhost:3306/bibased?"
                + "user=root&password=root&useUnicode=true&characterEncoding=UTF-8";
 
        try {
            // 之所以要使用下面这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，
            // 可以通过Class.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            // or:
            // com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
            // or：
            // new com.mysql.jdbc.Driver();
 
            System.out.println("成功加载MySQL驱动程序");
            // 一个Connection代表一个数据库连接
            conn = (Connection) DriverManager.getConnection(url);
            // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
            Statement stmt = (Statement) conn.createStatement();
            sql = "select * from tb_role";
            ResultSet  result = stmt.executeQuery(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
                
                while (result.next()) {
                    System.out
                            .println(result.getString(1) + "\t" + result.getString(2));// 入如果返回的是int类型可以用getInt()
            }
        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
 
    }
 
}
