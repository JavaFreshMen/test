package com.njusoft.its.utils;
/** 
*
* @author 作者 E-mail:857332533@qq.com 
* @date 创建时间：2017年12月9日 下午5:53:08 
* @version 1.0 
* @since JDK 1.7
*/
public class DistanceUtils {

	//获取距离
	public static double GetDistance(double Lat1, double Long1, double Lat2,
			double Long2)
	{
		double Lat1r = ConvertDegreeToRadians(Lat1);
		double Lat2r = ConvertDegreeToRadians(Lat2);
		double Long1r = ConvertDegreeToRadians(Long1);
		double Long2r = ConvertDegreeToRadians(Long2);

		double R = 6371; // Earth's radius (km)
		double d = Math.acos(Math.sin(Lat1r) * Math.sin(Lat2r) +
				Math.cos(Lat1r)* Math.cos(Lat2r) * Math.cos(Long2r - Long1r))* R;
		return d * 1000;
	}

	private static double ConvertDegreeToRadians(double degrees)
	{
		return (Math.PI / 180) * degrees;
	}

	/**
	 * 非空返回true
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str)
	{		
		return str!=null && !"".equals(str.trim());
	}
}
