/*
 * Copyright © 2017 the original authors (http://cereebro.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.cereebro.sample.boot.snitch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import io.cereebro.core.annotation.ConsumerHint;
import io.cereebro.core.annotation.DependencyHint;
import io.cereebro.core.annotation.RelationshipHints;

@SpringBootApplication
public class CereebroSampleSnitchApplication {

    public static void main(String[] args) {
        SpringApplication.run(CereebroSampleSnitchApplication.class, args);
    }

    @Bean
    @DependencyHint(name = "captain-america", type = "annotated-method")
    public Example example1() {
        return new Example();
    }

    @Bean
    @ConsumerHint(name = "apocalypse", type = "villain")
    public Example example2() {
        return new Example();
    }

    static class Example {

    }

    @Component
    @RelationshipHints(consumers = { @ConsumerHint(name = "hulk", type = "annotated-class") })
    static class AnnotatedClass {

    }

    @DependencyHint(name = "thor", type = "interface")
    interface AnnotatedInterface {

    }

    @Component
    static class AnnotatedInterfaceImpl implements AnnotatedInterface {

    }

}
