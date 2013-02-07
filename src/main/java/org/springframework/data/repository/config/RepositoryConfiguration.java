/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.repository.config;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.data.repository.query.QueryLookupStrategy;

/**
 * Configuration information for a single repository instance.
 * 
 * @author Oliver Gierke
 */
public interface RepositoryConfiguration<T extends RepositoryConfigurationSource> {

	/**
	 * Returns the id of the {@link BeanDefinition} the repository shall be registered under.
	 * 
	 * @return
	 * @deprecated bean ids should be determined using a {@link BeanNameGenerator} during classpath scanning.
	 */
	@Deprecated
	String getBeanId();

	/**
	 * Returns the base packages that the repository was scanned under.
	 * 
	 * @return
	 */
	Iterable<String> getBasePackages();

	/**
	 * Returns the interface name of the repository.
	 * 
	 * @return
	 */
	String getRepositoryInterface();

	/**
	 * Returns the key to resolve a {@link QueryLookupStrategy} from eventually.
	 * 
	 * @see QueryLookupStrategy.Key
	 * @return
	 */
	Object getQueryLookupStrategyKey();

	/**
	 * Returns the location of the file containing Spring Data named queries.
	 * 
	 * @return
	 */
	String getNamedQueriesLocation();

	/**
	 * Returns the class name of the custom implementation.
	 * 
	 * @return
	 */
	String getImplementationClassName();

	/**
	 * Returns the bean name of the custom implementation.
	 * 
	 * @return
	 */
	String getImplementationBeanName();

	/**
	 * Returns the name of the {@link FactoryBean} class to be used to create repository instances.
	 * 
	 * @return
	 */
	String getRepositoryFactoryBeanName();

	/**
	 * Returns the source of the {@link RepositoryConfiguration}.
	 * 
	 * @return
	 */
	Object getSource();

	/**
	 * Returns the {@link RepositoryConfigurationSource} that backs the {@link RepositoryConfiguration}.
	 * 
	 * @return
	 */
	T getConfigurationSource();
}