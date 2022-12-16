package com.group.libraryapp.calculator

fun main() {
    val calculatorTest = CalculatorTest()
    calculatorTest.addTest()
    calculatorTest.minusTest()
    calculatorTest.multiplyTest()
    calculatorTest.divideTest()
    calculatorTest.divideExceptionTest()
}

class CalculatorTest {

    // given - when - then 패턴
    fun addTest() {
        // given : 1. 테스트 대상을 만들어 준비하는 과정
        val calculator = Calculator(5)

        // when : 2. 실제 우리가 테스트하고 싶은 기능을 호출하는 과정
        calculator.add(3)

        // then: 3. 호출 이후 이도한대로 결과가 나왔는지 확인하는 과정
        // 방법은 세가지
        // (1) data class 활용해서 객체 자체로 equals
        // (2) getter를 열어서 프로퍼티를 가져와서 값을 비교
        // (3) backing property를 사용
        if (calculator.number != 8) {
            throw IllegalStateException()
        }
    }

    fun minusTest() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.minus(3)

        // then
        if (calculator.number != 2) {
            throw IllegalStateException()
        }
    }

    fun multiplyTest() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.multiply(3)

        // then
        if (calculator.number != 15) {
            throw IllegalStateException()
        }
    }

    fun divideTest() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.divide(2)

        // then
        if (calculator.number != 2) {
            throw IllegalStateException()
        }
    }

    fun divideExceptionTest() {
        //given
        val calculator = Calculator(5)

        //when
        try {
            calculator.divide(0)
        } catch (exception: IllegalArgumentException) {
            if (exception.message != "0으로 나눌 수 없습니다") {
                throw IllegalStateException("메시지가 다릅니다.")
            }
            // 테스트 성공!
            return
        } catch (exception: Exception) {
            throw IllegalStateException()
        }
        throw IllegalStateException("기대하는 에러가 발생하지 않았습니다.")
    }

}