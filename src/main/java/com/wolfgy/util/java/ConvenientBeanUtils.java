package com.wolfgy.util.java;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.lang.Nullable;

/**
 * 
 * <p>
 * Description:Java bean操作工具类<br />
 * </p>
 * @title ConvenientBeanUtils.java
 * @package com.wolfgy.util.java 
 * @author wolfgy
 * @version 0.1 2019年6月23日
 */
public class ConvenientBeanUtils {

	/**
	 * 
	 * <p>
	 * Description:获取bean中空属性名<br />
	 * Note:String若为blank也被视为空
	 * </p>
	 * 
	 * @author wolfgy
	 * @version 0.1 2018年7月11日
	 * @param obj
	 *            要获取属性名的Java Bean对象
	 * @return String[]
	 */
	public static String[] getNullPropertyNames(Object obj) {
		BeanWrapper src = new BeanWrapperImpl(obj);
		PropertyDescriptor[] pds = src.getPropertyDescriptors();

		Set<String> emptyNames = new HashSet<>();
		for (PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if ((!"class".equals(pd.getName()))
					&& ((srcValue == null) || ((pd.getPropertyType().getName().equals("java.lang.String"))
							&& (StringUtils.isBlank((String) srcValue))))) {
				emptyNames.add(pd.getName());
			}
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}

	/**
	 * 
	 * <p>
	 * Description:获取bean中的非空属性名<br />
	 * Note:String若为blank也被视为空
	 * </p>
	 * 
	 * @author wolfgy
	 * @version 0.1 2018年7月11日
	 * @param obj
	 *            要获取属性名的Java Bean对象
	 * @return String[]
	 */
	public static String[] getNotNullPropertyNames(Object obj) {
		final BeanWrapper src = new BeanWrapperImpl(obj);
		PropertyDescriptor[] pds = src.getPropertyDescriptors();

		Set<String> notNullPropertyNames = new HashSet<>();
		for (PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if (!"class".equals(pd.getName())) {
				if (srcValue != null) {
					if ((!pd.getPropertyType().getName().equals("java.lang.String"))
							|| (pd.getPropertyType().getName().equals("java.lang.String")
									&& StringUtils.isNotBlank((String) srcValue))) {
						notNullPropertyNames.add(pd.getName());
					}
				}

			}
		}
		String[] result = new String[notNullPropertyNames.size()];
		return notNullPropertyNames.toArray(result);
	}

	/**
	 * 
	 * <p>
	 * Description:拷贝属性到目标对象，同时排除指定属性<br />
	 * Note:源对象和目标对象类型不需要一致或有关联(如继承等)，只要属性名、属性类型匹配即可拷贝。源对象提供了
	 * 但是目标对象未提供的属性将被自动忽略。<br />
	 * </p>
	 * 
	 * @author wolfgy
	 * @version 0.1 2018年7月11日
	 * @param source
	 *            源对象
	 * @param target
	 *            目标对象
	 * @param ignoreProperties
	 *            需要排除的屬性字段 如:"id,name,age" 
	 */
	public static void copyPropertiesIgnoreSpecified(Object source, Object target, @Nullable String ignoreProperties) {
		String[] dim2 = null;
		if (StringUtils.isNotBlank(ignoreProperties)) {
			dim2 = StringUtils.split(ignoreProperties, ",");
		}
		BeanUtils.copyProperties(source, target, dim2);
	}
	
	/**
	 * 
	 * <p>
	 * Description:拷贝非空属性到目标对象<br />
	 * Note:源对象和目标对象类型不需要一致或有关联(如继承等)，只要属性名、属性类型匹配即可拷贝。源对象提供了
	 * 但是目标对象未提供的属性将被自动忽略。<br />
	 * String若为blank也被视为空
	 * </p>
	 * 
	 * @author wolfgy
	 * @version 0.2 2018年7月11日
	 * @param source
	 *            源对象
	 * @param target
	 *            目标对象
	 */
	public static void copyPropertiesIgnoreNull(Object source, Object target) {
		BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
	}

	/**
	 * 
	 * <p>
	 * Description:拷贝非空属性到目标对象，同时排除指定属性<br />
	 * Note:源对象和目标对象类型不需要一致或有关联(如继承等)，只要属性名、属性类型匹配即可拷贝。源对象提供了
	 * 但是目标对象未提供的属性将被自动忽略。<br />
	 * String若为blank也被视为空
	 * </p>
	 * 
	 * @author wolfgy
	 * @version 0.2 2018年7月11日
	 * @param source
	 *            源对象
	 * @param target
	 *            目标对象
	 * @param ignoreProperties
	 *            需要排除的屬性字段 如:"id,name,age"
	 */
	public static void copyPropertiesIgnoreNullAndSpecified(Object source, Object target,
			@Nullable String ignoreProperties) {
		String[] nullNames = getNullPropertyNames(source);
		String a = StringUtils.join(nullNames, ",");
		StringBuffer sb = new StringBuffer(a);
		if (StringUtils.isNotBlank(ignoreProperties)) {
			sb.append(",").append(ignoreProperties);
		}
		String[] dim2 = null;
		if (StringUtils.isNotBlank(sb.toString())) {
			dim2 = StringUtils.split(sb.toString(), ",");
		}
		BeanUtils.copyProperties(source, target, dim2);
	}
	

	/**
	 * 
	 * <p>
	 * Description:只从source中拷贝target中属性值为空的字段<br />
	 * Note:源对象和目标对象类型不需要一致或有关联(如继承等)，只要属性名、属性类型匹配即可拷贝。源对象提供了
	 * 但是目标对象未提供的属性将被自动忽略。<br />
	 * String若为blank也被视为空
	 * </p>
	 * 
	 * @author wolfgy
	 * @version 0.1 2018年7月11日
	 * @param source
	 *            源对象
	 * @param target
	 *            目标对象
	 */
	public static void copyPropertiesIgnoreNotNullInTarget(Object source, Object target) {
		BeanUtils.copyProperties(source, target, getNotNullPropertyNames(target));
	}

	/**
	 * 
	 * <p>
	 * Description:只从source中拷贝target中属性值为空的字段，同时排除指定属性<br />
	 * Note:源对象和目标对象类型不需要一致或有关联(如继承等)，只要属性名、属性类型匹配即可拷贝。源对象提供了
	 * 但是目标对象未提供的属性将被自动忽略。<br />
	 * String若为blank也被视为空
	 * </p>
	 * 
	 * @author wolfgy
	 * @version 0.1 2018年7月11日
	 * @param source
	 *            源对象
	 * @param target
	 *            目标对象
	 * @param ignoreProperties
	 *            需要排除的屬性字段,多个字段用半角逗号拼接。如:"id,name,age"。可以为null。 void
	 */
	public static void copyPropertiesIgnoreNotNullInTargetAndSpecified(Object source, Object target,
			@Nullable String ignoreProperties) {
		String[] notNullPropertyNames = getNotNullPropertyNames(target);
		String a = StringUtils.join(notNullPropertyNames, ",");
		StringBuffer sb = new StringBuffer(a);
		if (StringUtils.isNotBlank(ignoreProperties)) {
			sb.append(",").append(ignoreProperties);
		}
		String[] dim2 = null;
		if (StringUtils.isNotBlank(sb.toString())) {
			dim2 = StringUtils.split(sb.toString(), ",");
		}
		BeanUtils.copyProperties(source, target, dim2);
	}


}
