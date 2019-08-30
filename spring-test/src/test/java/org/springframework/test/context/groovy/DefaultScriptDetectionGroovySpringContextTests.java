/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.test.context.groovy;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.tests.sample.beans.Employee;
import org.springframework.tests.sample.beans.Pet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration test class that verifies proper detection of a default
 * Groovy script (as opposed to a default XML config file).
 *
 * @author Sam Brannen
 * @since 4.1
 * @see DefaultScriptDetectionGroovySpringContextTestsContext
 */
@RunWith(SpringJUnit4ClassRunner.class)
// Config loaded from DefaultScriptDetectionGroovySpringContextTestsContext.groovy
@ContextConfiguration
public class DefaultScriptDetectionGroovySpringContextTests {

	@Autowired
	private Employee employee;

	@Autowired
	private Pet pet;

	@Autowired
	protected String foo;


	@Test
	public final void verifyAnnotationAutowiredFields() {
		assertThat(this.employee).as("The employee field should have been autowired.").isNotNull();
		assertThat(this.employee.getName()).isEqualTo("Dilbert");

		assertThat(this.pet).as("The pet field should have been autowired.").isNotNull();
		assertThat(this.pet.getName()).isEqualTo("Dogbert");

		assertThat(this.foo).as("The foo field should have been autowired.").isEqualTo("Foo");
	}

}