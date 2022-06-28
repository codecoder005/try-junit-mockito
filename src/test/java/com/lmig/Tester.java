package com.lmig;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Tester {
    @Test
    void testAdd(){
        int a = 1;
        int b = 2;
        int c = a + b;
        assertThat(c).isEqualTo(3);
    }
}
