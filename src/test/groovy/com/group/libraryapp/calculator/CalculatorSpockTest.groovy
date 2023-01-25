package com.group.libraryapp.calculator

import spock.lang.Specification

class CalculatorSpockTest extends Specification {

    def addTest() {

        given:
        Calculator calculator = new Calculator(number)

        expect:
        calculator.add(addNumber)
        calculator.number == result

        where:
        number | addNumber | result
        5      | 3         | 10
        12     | 98        | 115
        1001   | 533       | 1534

    }

}