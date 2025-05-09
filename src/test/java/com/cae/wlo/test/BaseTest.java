package com.cae.wlo.test;

import com.cae.common.Secret;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseTest {

    public String decrypt(String encrypted) {
        String secret = System.getenv("WLO_SECRET");
        return new Secret().decrypt(encrypted, secret);
    }

}
