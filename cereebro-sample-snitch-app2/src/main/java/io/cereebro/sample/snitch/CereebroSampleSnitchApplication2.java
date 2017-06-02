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
package io.cereebro.sample.snitch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import io.cereebro.core.annotation.ConsumerHint;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackageClasses = CereebroSampleSnitchApplication2.class)
@EnableZuulProxy
public class CereebroSampleSnitchApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(CereebroSampleSnitchApplication2.class, args);
    }

    /** Detected as a dependency to sample app1. */
    @FeignClient(name = "cereebro-sample-netflix-app1")
    public static interface SampleApp1Client {

        @RequestMapping("/health")
        Health getHealth();
    }

    /** Other dependency. */
    @FeignClient(name = "jsonplaceholder-typicode-com", url = "https://jsonplaceholder.typicode.com")
    public static interface JsonPlaceHolderApiClient {

        @RequestMapping("/posts/{postId}")
        String getPost(String postId);

    }

    @ConsumerHint(name = "fancy-app", type = "application/mobile/android")
    @Component
    public static class FancyMobileApp {

    }

}
