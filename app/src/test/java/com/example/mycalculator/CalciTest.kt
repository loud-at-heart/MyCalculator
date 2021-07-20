package com.example.mycalculator

import junit.framework.TestCase

class CalciTest : TestCase() {

    fun testAdd() {
        var calc = Calci()
        var actual =calc.add(10,20)
        var expected = 10 + 20
        assertEquals(actual,expected)
    }
}