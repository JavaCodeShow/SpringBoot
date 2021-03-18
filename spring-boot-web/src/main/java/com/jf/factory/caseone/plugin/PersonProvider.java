package com.jf.factory.caseone.plugin;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonProvider extends PluginProvider<Integer, PersonPlugin> {

	@Autowired(required = false)
	public PersonProvider(List<PersonPlugin> plugins) {
		super(plugins);
	}

	public PersonProvider() {
		this(Collections.emptyList());
	}

}
