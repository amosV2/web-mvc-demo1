package cn.demo.dao;

import java.util.List;

import cn.demo.utils.ReflectionUtils;
import org.apache.commons.dbutils.QueryRunner;

public class DAO<T> {

	private QueryRunner queryRunner = new QueryRunner();

	private Class<T> clazz;

	public DAO(){
		clazz = ReflectionUtils.getSuperGenericType(getClass());
	}

	/**
	 * 新增、修改、删除
	 * @param sql
	 * @param args
	 */
	public void update(String sql,Object...args){

	}

	/**
	 * 查询列表
	 * @param sql
	 * @param args
	 * @return
	 */
	public List<T> getForList(String sql,Object...args){

		return null;
	}

	/**
	 * 查询单个对象
	 * @param sql
	 * @param args
	 * @return
	 */
	public T getOne(String sql,Object...args){

		return null;
	}

	/**
	 * 查询一个字段
	 * @param sql
	 * @param args
	 * @param <E>
	 * @return
	 */
	public <E> E getValue(String sql,Object...args){
		return null;
	}

}
