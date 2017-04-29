package com.repp;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;

/**
 * Created by 1 on 23.04.2017.
 */
@TestConfiguration
@Import(MerchApplication.class)
public class TestsConfiguration {
}
