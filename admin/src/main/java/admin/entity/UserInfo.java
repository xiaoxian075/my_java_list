package admin.entity;

import java.io.Serializable;


/**
 * 用户实体类
 * @author liuyazhuang
 *
 */
public class UserInfo implements Serializable{
	private static final long serialVersionUID = 1332643889208978231L;
	
	/**
	 * id
	 */
	private Integer id;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 年龄
	 */
	private Integer age;

	public UserInfo() {
		super();
	}
	
	public UserInfo(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public UserInfo(String name, String sex, Integer age) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	
	public UserInfo(Integer id, String name, String sex, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
	
}

