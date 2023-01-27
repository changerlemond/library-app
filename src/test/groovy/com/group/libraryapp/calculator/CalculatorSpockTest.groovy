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
        5      | 3         | 8
        12     | 98        | 110
        1001   | 533       | 1534

    }

    def divideTest() {

        given:
        Calculator calculator = new Calculator(15)

        when:
        calculator.divide(3)

        then:
        5 == calculator.number

    }

    def divideExceptionTest() {

        given:
        Calculator calculator = new Calculator(10)

        when:
        calculator.divide(0)

        then:
        def exception = thrown(IllegalArgumentException.class)
        exception.message == "0으로 나눌 수 없습니다"

    }

    def minusTest() {

        given:
        Calculator calculator = new Calculator(5)

        when:
        calculator.minus(2)

        then:
        3 == calculator.number

    }

    def multiplyTest() {

        given:
        Calculator calculator = new Calculator(initNumber)

        expect:
        calculator.multiply(multiplyNumber)

        where:
        initNumber | multiplyNumber | result
        5          | 5              | 25
        15         | 3              | 45
        12         | 3              | 36

    }

}
