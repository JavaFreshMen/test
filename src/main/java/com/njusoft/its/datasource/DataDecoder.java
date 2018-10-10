package com.njusoft.its.datasource;
/** 
*
* @author 作者 E-mail:857332533@qq.com 
* @date 创建时间：2017年10月24日 下午1:38:31 
* @version 1.0 
* @since JDK 1.7
*/
public interface DataDecoder<T> {
	/**
	 * 解析数据  返回解析结果
	 * @param data
	 * @return
	 */
	public boolean decodeData(T data);
	
	/**
	 * 获取线路编号
	 * @return
	 */
	public String getLineCode();
}
