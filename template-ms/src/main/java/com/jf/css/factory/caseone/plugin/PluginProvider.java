package com.jf.css.factory.caseone.plugin;

import java.util.List;

import com.google.common.collect.ImmutableMap;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2020-12-15 12:03
 * @since: 2.20.1
 */
public abstract class PluginProvider<K, P extends Plugin<K>> {

	private ImmutableMap<K, P> pluginMap;

	public PluginProvider(List<P> plugins) {
		ImmutableMap.Builder<K, P> builder = ImmutableMap.builder();

		for (P plugin : plugins) {
			builder.put(plugin.getKey(), plugin);
		}
		pluginMap = builder.build();
	}

	/**
	 * 获取指定 plugin
	 *
	 * @param key
	 * @return
	 */
	public P get(K key) {
		return pluginMap.get(key);
	}

}
