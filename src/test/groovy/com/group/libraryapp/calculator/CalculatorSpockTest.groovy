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

    def divideExceptionTest() {

        given:
        Calculator calculator = new Calculator(10)

        when:
        calculator.divide(0)

        then:
        def exception = thrown(IllegalArgumentException.class)
        exception.message == "0으로 나눌 수 없습니다"

    }

    def "mock으로 임의의 값 넣어주는 테스트"() {

        given:
        def calculator = GroovyMock(Calculator.class)

        when:
        calculator.getNumber() >> 5

        then:
        5 == calculator.getNumber()

    }

}
