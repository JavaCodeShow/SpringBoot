package com.jf.css.factory.caseone.plugin;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2020-12-15 12:04
 * @since: 2.20.1
 */
public interface Plugin<K> {

	/**
	 * get plugin key
	 *
	 * @return
	 */
	K getKey();

}
